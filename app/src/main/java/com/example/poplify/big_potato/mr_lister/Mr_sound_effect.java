package com.example.poplify.big_potato.mr_lister;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_sound_effect extends Activity
{

    Button hit,miss;
    MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mr_sound);

        hit=(Button) findViewById(R.id.imageButton2);
        miss=(Button) findViewById(R.id.imageButton3);

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



    }
    }
