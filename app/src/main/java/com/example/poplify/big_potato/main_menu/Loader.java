package com.example.poplify.big_potato.main_menu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;

import java.util.Random;

public class Loader extends AppCompatActivity {


    ProgressBar s;
    UsefullData usefull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        s=(ProgressBar) findViewById(R.id.pb_loading);
        usefull=new UsefullData(getApplicationContext());
        ObjectAnimator animation = ObjectAnimator.ofInt(s, "progress", 0, 100);
        animation.setDuration(1500);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();



        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(1700);

                    // After 5 seconds redirect to another intent
                    usefull.trimCache(getApplicationContext());
                    Intent i = new Intent(Loader.this, Game_menu.class);
                    startActivity(i);

                    finish();

                } catch (Exception e) {

                }
            }
        };


        background.start();



    }





}
