package com.bigpotato.bigpotatogamesuk.big_potato.obla;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/23/2016.
 */
public class Obla_extra_cards extends Activity
{

    ImageView act,descr,solve,back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obla_extra_cards);

        act=(ImageView) findViewById(R.id.imageView16_act);
        descr=(ImageView) findViewById(R.id.imageView15_desc);
        solve=(ImageView) findViewById(R.id.imageView17_solove);
        back=(ImageView) findViewById(R.id.backobla);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);


        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act=new Intent(getApplicationContext(),Extra_card_pager.class);
                act.putExtra("obla","act");
                startActivity(act);


            }
        });
        descr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act=new Intent(getApplicationContext(),Extra_card_pager.class);
                act.putExtra("obla","desc");
                startActivity(act);
            }
        });
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act=new Intent(getApplicationContext(),Extra_card_pager.class);
                act.putExtra("obla","solve");
                startActivity(act);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Obla_homapage.class);
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
//        Intent how23=new Intent(getApplicationContext(),Obla_homapage.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Obla_homapage.class);
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

    }
