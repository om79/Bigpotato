package com.example.poplify.big_potato.mr_lister;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_sound_effect extends Activity
{

    Button hit,miss;
    MediaPlayer mp ;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mr_sound);

        hit=(Button) findViewById(R.id.imageButton2);
        miss=(Button) findViewById(R.id.imageButton3);
        back=(ImageView) findViewById(R.id.imageView12_sound_cross);

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mp= MediaPlayer.create(getApplicationContext(), R.raw.hit);
                mp.start();
            }
        });
        miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp= MediaPlayer.create(getApplicationContext(), R.raw.miss);
                mp.start();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });



    }
    }
