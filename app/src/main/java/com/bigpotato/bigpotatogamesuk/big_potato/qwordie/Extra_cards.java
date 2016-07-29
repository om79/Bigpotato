package com.bigpotato.bigpotatogamesuk.big_potato.qwordie;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.Image;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.ImageAdapter;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.UsefullData;

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
    MediaPlayer mp;
    boolean mIsBackVisible = false;
    String[] ques={
            "There are six main characters in the first and best ’Toy Story’ movie. Spell one.",
            "A standard drum kit makes a lot of noise and contains five types of drum. Spell one.",
            "According to the McDonald’s website, a ‘Big Mac’ suspiciously contains only seven ingredients. Spell one.",
            "There are four primary ingredients that are required to brew lovely, lovely beer. Spell one.",
            "There are four types of common saxophone (all of which can play ‘Careless Whisper’). Spell one.",
            "Friday the 13th, Hellraiser, Psycho and The Omen all had some villains that you'd probably rather forget. Spell one. (First name only.)",
            "Since 1979 there have been six UK Prime Ministers in power. Spell one. (First name only.)",
            "There are five different coloured rings in the Olympics logo. Spell one.",
            "All aboard the Mystery Machine! Five cowardly and courageous characters teamed up with Scooby Doo on his adventures. Spell one.",
            "Pretend your back at school and try to remember the 10 types of energy in the world. Then spell one.",
            "The most dysfunctional family in animated history, there were seven dwarfs from the Disney movie, ‘Snow White’. Spell one.",
            "The over-bearing and demanding game of ‘Bop It’ (original version) requires a player to perform one of five actions. Spell one.",
            "Phones – everyone's got one, but five brands are the most popular of all. Spell one.",
            "There are five social networks that connect us together more than any others. Spell one.",
            "The Lord of the Rings trilogy featured many funny-looking races, but eight were more prominent than the rest. Spell one (singular not plural).",
            "Need to find something? There's six search engines on the internet that are used more than any other. Spell one.",
            "There are five trees that are native to the UK with a three-letter name (not including Ent). Spell one.",
            "Whether you're a gym-goer or a sofa-dweller, you should still be aware of the world's six biggest sportswear brands. Spell one.",
            "Italians, French, Germans and Portuguese all use a different word for the number '1'. Spell one.",
            "There are seven cities / states that are lucky enough to contain a Disney Land! Spell one."


    };
    String[] ans={
            " Woody, Buzz, Rex, Slinky, Hamm, Potato Head",
            " Bass, Snare, Tom, HiHat, Cymbal",
            " Beef/Patty, Lettuce, Cheese, Pickles, Onions, Bun, Sauce",
            " Grain/Barley, Hops, Yeast, Water",
            " Soprano, Alto, Tenor, Baritone",
            " Jason, Pinhead, Norman, Damien",
            " Margaret, John, Tony, Gordon, David, Theresa",
            " Blue, Yellow, Black, Green, Red",
            " Shaggy, Velma, Daphne, Fred, Scrappy",
            " Magnetic, Kinetic, Heat, Light, Gravity/Gravitational, Chemical, Sound, Elastic, Nuclear, Electrical",
            " Bashful, Doc, Dopey, Happy, Sleepy, Sneezy, Grumpy",
            " Pull, Spin, Flick, Twist, Bop",
            " Samsung, Nokia, Apple, LG, ZTE",
            " Facebook, YouTube, Twitter, LinkedIn, Pinterest",
            " Man, Hobbit, Elf, Dwarf, Orc, Goblin, Uruk hai, Ent",
            " Google, Bing, Yahoo, Ask, AOL, Wow",
            " Ash, Oak, Elm, Yew, Box",
            " Reebok, New Balance, Asics, Puma, Adidas, Nike",
            " Uno, Eins, Un, Um",
            " Florida, Toyko, Paris, Hong Kong, Shanghai, California, Hawaii"



    };
    ArrayList<Image> actorsList=new ArrayList<Image>();
    Animation move,rotation;
    AnimatorSet flip,out,in;
    Handler handler = new Handler();
    Typeface regular,bold;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.extra_cards);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView);
        back = (ImageView) findViewById(R.id.back);
        mp = MediaPlayer.create(this, R.raw.back_button);
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
                mp.start();
                usefull.trimCache(getApplicationContext());
                finish();
//                Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
//                startActivity(how23);
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
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
//            layout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
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
            final LinearLayout hide = (LinearLayout) layout
                    .findViewById(R.id.hidelayout);

            final  View  mCardBackLayout = layout.findViewById(R.id.card_back);
            final View  mCardFrontLayout = layout.findViewById(R.id.card_front);

            int distance = 8000;
            float scale = getResources().getDisplayMetrics().density * distance;
            mCardFrontLayout.setCameraDistance(scale);
            mCardBackLayout.setCameraDistance(scale);

            mIsBackVisible = false;

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


                            new set_images().execute();

                            break;

                    }


                }
            });











            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    pwindo.dismiss();

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
            for (int i = 0; i < 20; i++) {
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



    @Override
    public void onBackPressed() {
        // your code.
        mp.start();
        usefull.trimCache(getApplicationContext());
        finish();
//        Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mp.start();
//            usefull.trimCache(getApplicationContext());
            finish();
//            Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }



}
