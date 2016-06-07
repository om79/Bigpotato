package com.example.poplify.big_potato.bucket_of_doom;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.Image;
import com.example.poplify.big_potato.adapters.ImageAdapter;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 6/2/2016.
 */
public class Bod_extra_cards extends Activity
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

        setContentView(R.layout.bod_extra_cards);

        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Bod_extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView_bod_extra);
        back = (ImageView) findViewById(R.id.back_bod_extra);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");



        image_adapter = new ImageAdapter(getApplicationContext(), R.layout.rowhome, actorsList);
        gv.setAdapter(image_adapter);

        for (int i = 0; i < 10; i++) {
            Image actor = new Image();

            if(save_data.isExist("bod"+i)==true)
            {
                actor.setimage(R.mipmap.bod_open_card);
                actor.settitle(ques[i]);

            }else {
                actor.setimage(R.mipmap.bod_cardface_down);
                actor.settitle("");
            }
            actorsList.add(actor);
        }

        image_adapter.notifyDataSetChanged();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usefull.trimCache(getApplicationContext());
                Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                usefull.trimCache(getApplicationContext());
                save_data.save("bod"+position,position);

                Intent b= new Intent(getApplicationContext(),Bod_cards.class);
                b.putExtra("data",ques[position]);
                startActivity(b);
            }
        });


        flip = (AnimatorSet) AnimatorInflater.loadAnimator(Bod_extra_cards.this,R.animator.flip);
        move = AnimationUtils.loadAnimation(Bod_extra_cards.this, R.anim.move);
        rotation = AnimationUtils.loadAnimation(Bod_extra_cards.this, R.anim.rotate);




    }






}

