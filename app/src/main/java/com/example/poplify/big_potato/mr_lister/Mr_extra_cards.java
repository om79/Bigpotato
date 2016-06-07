package com.example.poplify.big_potato.mr_lister;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.Image;
import com.example.poplify.big_potato.adapters.ImageAdapter;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_cards;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;

    SaveData save_data;
    UsefullData usefull;

    ArrayList<Image> actorsList=new ArrayList<Image>();
   int[] mrpic=new int[]{R.mipmap.mr1,R.mipmap.mr2,R.mipmap.mr3,R.mipmap.mr4,R.mipmap.mr5,R.mipmap.mr6};
    String [] mr=new String[]{"mr1","mr2","mr3","mr4","mr5","mr16"};

    Typeface regular,bold;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mr_extra_cards);

        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Mr_extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView_bod_extra_mr);
        back = (ImageView) findViewById(R.id.back_bod_extra_mr);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");



        image_adapter = new ImageAdapter(getApplicationContext(), R.layout.rowhome, actorsList);
        gv.setAdapter(image_adapter);

        for (int i = 0; i < 6; i++) {
            Image actor = new Image();

                actor.setimage(mrpic[i]);
                actor.settitle("");

            actorsList.add(actor);
        }

        image_adapter.notifyDataSetChanged();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usefull.trimCache(getApplicationContext());
                Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {



            }
        });







    }






}

