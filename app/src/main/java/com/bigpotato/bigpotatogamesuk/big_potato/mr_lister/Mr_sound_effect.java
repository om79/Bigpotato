package com.bigpotato.bigpotatogamesuk.big_potato.mr_lister;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_sound_effect extends Activity
{

    Button hit,miss;
//    MediaPlayer mp ;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mr_sound);

        hit=(Button) findViewById(R.id.imageButton2);
        miss=(Button) findViewById(R.id.imageButton3);
        back=(ImageView) findViewById(R.id.imageView12_sound_cross);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    mp= MediaPlayer.create(getApplicationContext(), R.raw.mr_lisyer_hit);
//                    mp.start();
                    managerOfSound_hit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    mp= MediaPlayer.create(getApplicationContext(), R.raw.mr_lister_miss);

//                    mp.start();
                    managerOfSound_miss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
//                startActivity(how23);
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });



    }
    @Override
    public void onBackPressed() {
        // your code.
        managerOfSound();
        finish();
//        Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
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
    private void managerOfSound_miss() {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.mr_lister_miss);
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
    private void managerOfSound_hit() {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.mr_lisyer_hit);
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
