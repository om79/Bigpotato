package com.bigpotato.bigpotatogamesuk.big_potato.scrawl;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

import java.util.Random;

/**
 * Created by POPLIFY on 6/22/2016.
 */
public class Raindoimzar extends Activity
{


    int[] picx={R.mipmap.sr1,R.mipmap.sr2,R.mipmap.sr3,R.mipmap.sr4,R.mipmap.sr5,R.mipmap.sr6};
    ImageView main_pic,cross;
    Button new_rule;
    MediaPlayer mp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomizar);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        main_pic=(ImageView) findViewById(R.id.imageView14_random);
        cross=(ImageView) findViewById(R.id.imageVie_new);
        new_rule=(Button) findViewById(R.id.button3_new);
        mp= MediaPlayer.create(getApplicationContext(), R.raw.back_button);
        main_pic.setImageResource(picx[new Random().nextInt(picx.length)]);
        new_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_pic.setImageResource(picx[new Random().nextInt(picx.length)]);
            }
        });
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//                startActivity(how23);
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // your code.
        mp.start();
        finish();
//        Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mp.start();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
