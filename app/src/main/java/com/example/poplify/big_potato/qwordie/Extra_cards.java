package com.example.poplify.big_potato.qwordie;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.poplify.big_potato.adapters.Image;
import com.example.poplify.big_potato.adapters.ImageAdapter;
import com.example.poplify.big_potato.R;
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
    String[] ques={ "There are seven colours in rainbow.\n Spell one",
            "Aggrefgfdgdfgdgssive",
            "Alonefgfdgdfg gffdgfgfgf",
            "Amazedgfdgdfg",
            "Angrydgdfg",
            "Annoyed",
            "Anxious",
            "Artdgfdgdy",
            "Bitchy",
            "Blah"

    };
    String[] ans={
            " Red\n Orange\n Yellow\n Green\n Blue\n Indigo\n Violet",
            "Alonefgfdgdfggffdgfgfgf",
            "Amazedgfdgdfg",
            "Angrydgdfg",
            "Annoyed",
            "Anxious",
            "Artdgfdgdy",
            "Bitchy",
            "Annoyed",
            "Blah"

    };
    ArrayList<Image> actorsList=new ArrayList<Image>();
    Animation move,rotation;
    AnimatorSet flip;
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

        for (int i = 0; i < 10; i++) {
            Image actor = new Image();

             if(save_data.isExist(""+i)==true)
            {
                actor.setimage(R.mipmap.card_back);
                actor.settitle(ques[i]);

            }else {
                 actor.setimage(R.mipmap.ques_card);
                 actor.settitle("");
             }
            actorsList.add(actor);
        }

        image_adapter.notifyDataSetChanged();


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
                save_data.save(""+position,position);
                initiatePopupWindow(position);
            }
        });


        flip = (AnimatorSet) AnimatorInflater.loadAnimator(Extra_cards.this,R.animator.flip);
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
            textView.setText(ques[position]);
            textView.setTypeface(regular);
            final LinearLayout main = (LinearLayout) layout
                    .findViewById(R.id.main_layout_popup);
//            final ScrollView s = (ScrollView) layout
//                    .findViewById(R.id.popup_element);




            final Button button = (Button) layout.findViewById(R.id.button_reveal);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    usefull.trimCache(getApplicationContext());
                    switch (button.getText().toString())
                    {


                        case "Return to question":
                            flip.setTarget(main);
                            flip.start();
                            textView.setText(ques[position]);
                            button.setText("Reveal answers");
                            card_back.setBackground(getResources().getDrawable(R.mipmap.card_back));


                            break;
                        case "Reveal answers":

                            flip.setTarget(main);
                            flip.start();
                            textView.setText(ans[position]);
                            button.setText("Return to question");
                            card_back.setBackground(getResources().getDrawable(R.mipmap.ans_card));


                            break;

                    }


                }
            });









            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    pwindo.dismiss();
                    actorsList.clear();
                    for (int i = 0; i < 10; i++) {
                        Image actor = new Image();
                        if(save_data.isExist(""+i)==true)
                        {
                            actor.setimage(R.mipmap.card_back);
                            actor.settitle(ques[i]);

                        }else {
                            actor.setimage(R.mipmap.ques_card);
                            actor.settitle("");
                        }
                        actorsList.add(actor);
                    }

                    image_adapter.notifyDataSetChanged();
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
