package com.example.poplify.big_potato.bucket_of_doom;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.Image;
import com.example.poplify.big_potato.adapters.ImageAdapter;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.ok_play.Ok_play_homescreen;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 6/2/2016.
 */
public class Bod_extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;
    SaveData save_data;
    UsefullData usefull;
    String[] ques={ "There are seven colours in rainbow.\n Spell one",
            "Aggrefgfdgdfgdgssive",
            "Alonefgfdgdfg",
            "Amazedgfdgdfg",
            "Angrydgdfg",
            "Annoyed",
            "Anxious",
            "Artdgfdgdy",
            "Bitchy",
            "Blah"

    };

    ArrayList<Image> actorsList=null;

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


        actorsList=new ArrayList<Image>();
        image_adapter = new ImageAdapter(Bod_extra_cards.this, R.layout.rowhome_bod, actorsList);
        new set_images().execute();
        gv.setAdapter(image_adapter);




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

//                usefull.trimCache(getApplicationContext());
                save_data.save("bod"+position,position);

                Intent b= new Intent(Bod_extra_cards.this,Bod_cards.class);
                b.putExtra("data",ques[position]);
                startActivity(b);


            }
        });






    }


    class set_images extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        protected void onPreExecute()
        {
            actorsList.clear();
            dialog = new ProgressDialog(Bod_extra_cards.this, AlertDialog.THEME_HOLO_DARK);
            dialog.setMessage("Please wait a moment");
            dialog.show();
            dialog.setCancelable(false);

        }
        protected Void doInBackground(Void... arg0) {
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


            return null;
        }
        protected void onPostExecute(Void result)
        {
            dialog.cancel();
            image_adapter.notifyDataSetChanged();
        }

    }




}

