package com.bigpotato.bigpotatogamesus.big_potato.chameleon;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.bigpotato.bigpotatogamesus.big_potato.R;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.Image;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.ImageAdapter;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.UsefullData;
import com.bigpotato.bigpotatogamesus.big_potato.bucket_of_doom.Bod_cards;
import com.bigpotato.bigpotatogamesus.big_potato.bucket_of_doom.Bod_extra_cards;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Cham_extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;
    PopupWindow pwindo;
    SaveData save_data;
    UsefullData usefull;
    LinearLayout rel;
    ArrayList<Image> actorsList=new ArrayList<Image>();
    int[] qpic=new int[]{R.mipmap.cham_face_1,R.mipmap.cham_face_2,R.mipmap.cham_face_3,R.mipmap.cham_face_4,R.mipmap.cham_face_5,R.mipmap.cham_face_6,
           R.mipmap.cham_face_7,R.mipmap.cham_face_8,R.mipmap.cham_face_9,R.mipmap.cham_face_10,R.mipmap.cham_face_11,R.mipmap.cham_face_12};
    ImageView header;


    Typeface regular,bold;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bod_extra_cards);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Cham_extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView_bod_extra);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);
//        layoutParams.leftMargin = 45;
        layoutParams.rightMargin = 15;
//        layoutParams.topMargin = 45;
//        layoutParams.bottomMargin = 45;
        gv.setLayoutParams(layoutParams);
        back = (ImageView) findViewById(R.id.back_bod_extra);
        rel=(LinearLayout) findViewById(R.id.backlayer) ;
        rel.setBackground(getResources().getDrawable(R.mipmap.blur_back));
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        header=(ImageView) findViewById(R.id.imageView) ;
        header.setImageResource(R.mipmap.cham_card_head);




        image_adapter = new ImageAdapter(getApplicationContext(), R.layout.rowhome, actorsList);
        gv.setAdapter(image_adapter);

        new set_images().execute();




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound();
                finish();
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                usefull.trimCache(getApplicationContext());
                save_data.save("Cham"+position,position);
                Intent b= new Intent(Cham_extra_cards.this,Cham_cards.class);
                b.putExtra("data",position);
                startActivity(b);
            }
        });







    }



    @Override
    public void onBackPressed() {
        // your code.
        managerOfSound();
        finish();
//        usefull.trimCache(getApplicationContext());
//        Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
//            usefull.trimCache(getApplicationContext());
//            Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }




    class set_images extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        protected void onPreExecute()
        {
            actorsList.clear();
            dialog = new ProgressDialog(Cham_extra_cards.this, AlertDialog.THEME_HOLO_DARK);
            dialog.setMessage("Please wait a moment");
            dialog.show();
            dialog.setCancelable(false);

        }
      protected Void doInBackground(Void... arg0) {
            for (int i = 0; i < 12; i++) {
                Image actor = new Image();

                if(save_data.isExist("Cham"+i)==true)
                {
                    actor.setimage(qpic[i]);
                    actor.settitle("");

                }else {
                    actor.setimage(R.mipmap.cham_card);
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


    private void managerOfSound() {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.back_button);
        if (!mp.isPlaying()) {
            mp.start();
        } else {

            mp.stop();


        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.reset();
                mp.release();


            }
        });
    }

    @Override
    protected void onResume() {
        new set_images().execute();
        super.onResume();
    }

}

