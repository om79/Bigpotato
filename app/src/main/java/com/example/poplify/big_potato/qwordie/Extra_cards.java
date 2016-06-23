package com.example.poplify.big_potato.qwordie;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.Image;
import com.example.poplify.big_potato.adapters.ImageAdapter;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;

import java.util.ArrayList;


/**
 * Created by POPLIFY on 5/16/2016.
 */
public class Extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;
    PopupWindow pwindo;
    SaveData save_data;
    UsefullData usefull;
    boolean mIsBackVisible = false;
    String[] ques={
            "There are six main characters in the first and best ’Toy Story’ movie. Spell one.",
            "A standard drum kit makes a lot of noise and contains five types of drum. Spell one.",
            "According to the McDonald’s website, a ‘Big Mac’ suspiciously contains only seven ingredients. Spell one.",
            "There are four primary ingredients that are required to brew lovely, lovely beer. Spell one.",
            "There are four types of common saxophone (all of which can play ‘Careless Whisper’). Spell one.",
            "Friday the 13th, Hellraiser, Psycho and The Omen all had some villains that you'd probably rather forget. Spell one. (First name only.)",
            "Since 1979, there have been five UK Prime Ministers in power. Spell one. (first name only.)",
            "There were five different coloured rings in the Olympics logo (before it got messed up). Spell one.",
            "All aboard the Mystery Machine! Five cowardly and courageous characters teamed up with Scooby Doo on his adventures. Spell one.",
            "Pretend your back at school and try to remember the 10 types of energy in the world. Then spell one.",
            "The most dysfunctional family in animated history, there were seven dwarfs from the Disney movie, ‘Snow White’. Spell one.",
            "The over-bearing and demanding game of ‘Bop It’ (original version) requires a player to perform one of five actions. Spell one."

    };
    String[] ans={
            " Woody, Buzz, Rex, Slinky, Hamm, Potato Head",
            " Bass, Snare, Tom, HiHat, Cymbal",
            " Beef/Patty, Lettuce, Cheese, Pickles, Onions, Bun, Sauce",
            " Grain/Barley, Hops, Yeast, Water",
            " Soprano, Alto, Tenor, Baritone",
            " Jason, Pinhead, Norman, Damien",
            " Margaret, John, Tony, Gordon, David",
            " Blue, Yellow, Black, Green, Red",
            " Shaggy, Velma, Daphne, Fred, Scrappy",
            " Magnetic, Kinetic, Heat, Light, Gravity/Gravitational, Chemical, Sound, Elastic, Nuclear, Electrical",
            " Bashful, Doc, Dopey, Happy, Sleepy, Sneezy, Grumpy",
            " Pull, Spin, Flick, Twist, Bop",



    };
    ArrayList<Image> actorsList=new ArrayList<Image>();
    Animation move,rotation;
    AnimatorSet flip,out,in;
    Handler handler = new Handler();
    Typeface regular,bold;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.extra_cards);

        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView);
        back = (ImageView) findViewById(R.id.back);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  findViewById(R.id.textView2_subtxt);
        v.setTypeface(regular);

        image_adapter = new ImageAdapter(getApplicationContext(), R.layout.rowhome, actorsList);
        gv.setAdapter(image_adapter);

        new set_images().execute();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usefull.trimCache(getApplicationContext());
                Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                usefull.trimCache(getApplicationContext());
                save_data.save("qwordie"+position,position);
                initiatePopupWindow(position);
            }
        });


        flip = (AnimatorSet) AnimatorInflater.loadAnimator(Extra_cards.this,R.animator.flip);
        out = (AnimatorSet) AnimatorInflater.loadAnimator(Extra_cards.this,R.animator.out_animation);
        in = (AnimatorSet) AnimatorInflater.loadAnimator(Extra_cards.this,R.animator.in_animation);
        move = AnimationUtils.loadAnimation(Extra_cards.this, R.anim.move);
        rotation = AnimationUtils.loadAnimation(Extra_cards.this, R.anim.rotate);




    }




    private void initiatePopupWindow(final int position) {
        try {
            // We need to get the instance of the LayoutInflater


            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_view,
                    (ViewGroup) findViewById(R.id.popup_element));
//            layout.startAnimation(animation);
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(false);
            pwindo.setFocusable(true);


            final ImageView cross = (ImageView) layout.findViewById(R.id.imageViewcross);
            final RelativeLayout card_back = (RelativeLayout) layout.findViewById(R.id.card_background);
            final TextView textView = (TextView) layout.findViewById(R.id.textView_ques);
            final TextView textView_ques = (TextView) layout.findViewById(R.id.textView_main_ques);
            textView.setText(ques[position]);
            textView.setTypeface(regular);
            final LinearLayout main = (LinearLayout) layout
                    .findViewById(R.id.main_layout_popup);

            final  View  mCardBackLayout = layout.findViewById(R.id.card_back);
            final View  mCardFrontLayout = layout.findViewById(R.id.card_front);

            int distance = 8000;
            float scale = getResources().getDisplayMetrics().density * distance;
            mCardFrontLayout.setCameraDistance(scale);
            mCardBackLayout.setCameraDistance(scale);



            textView_ques.setText(ques[position]);
            final Button button = (Button) layout.findViewById(R.id.button_reveal);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {




                    switch (button.getText().toString())
                    {


                        case "Return to question":

                            if (!mIsBackVisible) {
                                out.setTarget(mCardFrontLayout);
                                in.setTarget(mCardBackLayout);
                                out.start();
                                in.start();
                                mIsBackVisible = true;
                            } else {
                                out.setTarget(mCardBackLayout);
                                in.setTarget(mCardFrontLayout);
                                out.start();
                                in.start();
                                mIsBackVisible = false;
                            }

                            button.setText("Reveal answers");
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run() {
                                    textView_ques.setText(ques[position]);
                                    card_back.setBackground(getResources().getDrawable(R.mipmap.card_back));
                                }
                            }, 700);




                            break;
                        case "Reveal answers":

                            if (!mIsBackVisible) {
                                out.setTarget(mCardFrontLayout);
                                in.setTarget(mCardBackLayout);
                                out.start();
                                in.start();
                                mIsBackVisible = true;
                            } else {
                                out.setTarget(mCardBackLayout);
                                in.setTarget(mCardFrontLayout);
                                out.start();
                                in.start();
                                mIsBackVisible = false;
                            }

                            button.setText("Return to question");
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run() {
                                    textView.setText(ans[position].replace(",","\n"));

                                    card_back.setBackground(getResources().getDrawable(R.mipmap.ans_card));
                                }
                            }, 700);




                            break;

                    }


                }
            });











            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    pwindo.dismiss();
                   new set_images().execute();
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    class set_images extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        protected void onPreExecute()
        {
            actorsList.clear();
            dialog = new ProgressDialog(Extra_cards.this, AlertDialog.THEME_HOLO_DARK);
            dialog.setMessage("Please wait a moment");
            dialog.show();
            dialog.setCancelable(false);

        }
        protected Void doInBackground(Void... arg0) {
            for (int i = 0; i < 12; i++) {
                Image actor = new Image();
                if(save_data.isExist("qwordie"+i)==true)
                {
                    actor.setimage(R.mipmap.card_back);
                    actor.settitle(ques[i]);

                }else {
                    actor.setimage(R.mipmap.ques_card);
                    actor.settitle("");
                }
                actorsList.add(actor);
            }
            return null;
        }
        protected void onPostExecute(Void result)
        {
            dialog.cancel();
            image_adapter.notifyDataSetChanged();
        }

    }







}
