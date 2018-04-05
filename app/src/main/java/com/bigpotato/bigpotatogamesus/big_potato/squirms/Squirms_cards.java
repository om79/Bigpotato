package com.bigpotato.bigpotatogamesus.big_potato.squirms;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesus.big_potato.R;

/**
 * Created by POPLIFY on 6/2/2016.
 */
public class Squirms_cards extends Activity {

    ImageView cross;
    Typeface regular,bold;
    int[] anspic=new int[]{R.mipmap.squirm_full_1,R.mipmap.squirm_full_2,R.mipmap.squirm_full_3,R.mipmap.squirm_full_4,R.mipmap.squirm_full_5,R.mipmap.squirm_full_6,
    R.mipmap.squirm_full_7,R.mipmap.squirm_full_8,R.mipmap.squirm_full_9,R.mipmap.squirm_full_10,R.mipmap.squirm_full_11,R.mipmap.squirm_full_12};
    RelativeLayout img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cham_card);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        cross=(ImageView) findViewById(R.id.imageVs_bod_new);
        img=(RelativeLayout) findViewById(R.id.imsg);



        try {
            Intent intent = getIntent();

            img.setBackground(getResources().getDrawable(anspic[intent.getIntExtra("data",0)]));


        } catch (Exception e) {
            e.printStackTrace();
        }


        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound();
                finish();

            }
        });


    }

    @Override
    public void onBackPressed() {
        // your code.
            managerOfSound();
            finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
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
}
