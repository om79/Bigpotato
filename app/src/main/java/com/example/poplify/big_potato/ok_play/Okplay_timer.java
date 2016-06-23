package com.example.poplify.big_potato.ok_play;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;

import java.util.concurrent.TimeUnit;

/**
 * Created by POPLIFY on 6/4/2016.
 */
public class Okplay_timer extends Activity
{

    ImageView back,timer_pic;
    Button play,ok;

    private CounterClass timer;  //Inner User-defined Class
    long remainMilli = 0;
    boolean isRunning=false;
    boolean ispause=false;




    int[] pics = new int[] { R.mipmap.p0,R.mipmap.p1,R.mipmap.p2, R.mipmap.p3,R.mipmap.p4,
            R.mipmap.p5,R.mipmap.p6,R.mipmap.p7,R.mipmap.p8,R.mipmap.p9,R.mipmap.p10,R.mipmap.p11,R.mipmap.p12,R.mipmap.p13,
            R.mipmap.p14,R.mipmap.p15,R.mipmap.p15};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okplay_timer);

        timer = new CounterClass(17000,1000);
        timer_pic = (ImageView) findViewById(R.id.imageView10_timer);
        back = (ImageView) findViewById(R.id.back_play_1_timer);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent how23=new Intent(getApplicationContext(),Ok_play_homescreen.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });


        play = (Button) findViewById(R.id.imageButton3_timer);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isRunning)
                {
                    if(!ispause){
                        start();
                    }else{
                        Resume();
                    }
                }else {

                    Pause();
                }




            }
        });
        ok = (Button) findViewById(R.id.imageButton2_timer);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isRunning)
                {
                    if(!ispause){

                        start();
                    }else{

                        remainMilli=0;
                        timer = new CounterClass(17000, 1000); //resume timer from where it is paused
                        timer.start();  //Start the timer
                        isRunning = true;
                        play.setBackgroundResource(R.drawable.pause);
                    }
                }else {

                    start();
                }


            }
        });

    }







    //When start button clicks
    public void start()
    {

        timer.cancel();
        remainMilli=0;
        play.setBackgroundResource(R.drawable.pause);
        timer = new CounterClass(17000, 1000);
        timer.start();   //Start the timer
        isRunning = true;
        ispause = false;
    }

    //When Stop button clicks
    public void Stop()
    {
            remainMilli=15;
            play.setBackgroundResource(R.drawable.pause);
            isRunning = false;
            timer_pic.setImageResource(R.mipmap.p15);
            ispause = false;

    }

    //When Resume button clicks
    public void Resume() {
        if (!isRunning) {  //This method will execute only when timer is not running
            timer = new CounterClass(remainMilli, 1000); //resume timer from where it is paused
            timer.start();  //Start the timer
            isRunning = true;
            play.setBackgroundResource(R.drawable.pause);
        }
    }

    //When Pause button clicks
    public void Pause() {
        if(isRunning){  //This method will execute only when timer is running
            timer.cancel();  //cancel (pause) timer when it is running
           
            timer=null;
            ispause=true;
            isRunning=false;
            play.setBackgroundResource(R.drawable.play);
        }
    }

    //Inner class which extends from CountDownTimer
    public class CounterClass extends CountDownTimer {

        //All three methods (constructor) need to be overridden to use this class

        //Default Constructor
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        //When timer is ticking, what should happen at that duration; will go in this method
        @Override
        public void onTick(long millisUntilFinished) {
            remainMilli = millisUntilFinished;


            long a=TimeUnit.MILLISECONDS.toSeconds(remainMilli)- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(remainMilli));
                Log.i("----",""+a);
            timer_pic.setImageResource(pics[(int)a-1]);


        }

        //When time is finished, what should happen: will go in this method
        @Override
        public void onFinish() {
            // reset all variables
            play.setBackgroundResource(R.drawable.play);
//            timer_pic.setImageResource(R.mipmap.p15);
            isRunning=false;
            ispause=false;
            remainMilli=0;
        }
    }







}
