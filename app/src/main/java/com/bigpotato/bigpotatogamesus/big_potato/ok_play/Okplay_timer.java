package com.bigpotato.bigpotatogamesus.big_potato.ok_play;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesus.big_potato.R;

import java.util.concurrent.TimeUnit;

/**
 * Created by POPLIFY on 6/4/2016.
 */
public class Okplay_timer extends Activity
{

    ImageView back,timer_pic;
    Button ok;
    MediaPlayer mp;
    private CounterClass timer;  //Inner User-defined Class
    long remainMilli = 0;
    boolean isRunning=false;
    boolean ispause=false;
    Boolean isFinished=true;
    boolean stop=true;



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


        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                managerOfSound(R.raw.back_button);
                finish();
            }
        });


//        play = (Button) findViewById(R.id.imageButton3_timer);
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(!isRunning)
//                {
//                    if(!ispause){
//                        isFinished=true;
//                        stop=true;
//                        play.setBackground(getResources().getDrawable(R.mipmap.pause));
//                        start();
//
//                    }else{
//                        play.setBackground(getResources().getDrawable(R.mipmap.pause));
//                        Resume();
//                    }
//                }else {
//                    play.setBackground(getResources().getDrawable(R.mipmap.play));
//                    Pause();
//                }
//
//
//
//
//            }
//        });
        mp = MediaPlayer.create(getApplicationContext(), R.raw.five_secondstimer);
        ok = (Button) findViewById(R.id.imageButton2_timer);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp.isPlaying()) {
                    mp.stop();
                    mp.reset();
                    mp.release();
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.five_secondstimer);
                }
//                managerOfSound("stop");
//                play_btn.start();
                managerOfSound(R.raw.okplay_button);
                if(!isRunning)
                {
                    if(!ispause){
                        isFinished=true;
                        stop=true;
//                        play.setBackground(getResources().getDrawable(R.mipmap.pause));
                        start();
                    }else{

                        remainMilli=0;
                        timer = new CounterClass(17000, 1000); //resume timer from where it is paused
                        timer.start();  //Start the timer
                        isRunning = true;
//                        play.setBackground(getResources().getDrawable(R.mipmap.pause));

                    }
                }else {
                    isFinished=true;
                    stop=true;
//                    play.setBackground(getResources().getDrawable(R.mipmap.pause));
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

        timer = new CounterClass(17000, 1000);
        timer.start();   //Start the timer
        isRunning = true;
        ispause = false;
//        play.setBackground(getResources().getDrawable(R.mipmap.pause));

    }

    //When Stop button clicks
    public void Stop()
    {
            remainMilli=15;

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
//            play.setBackground(getResources().getDrawable(R.mipmap.pause));
        }
    }
    public void back_press()
    {
        if(isRunning==true){
            timer.cancel();
        }

    }
    //When Pause button clicks
    public void Pause() {
        if(isRunning){  //This method will execute only when timer is running
            timer.cancel();  //cancel (pause) timer when it is running
//            play.setBackground(getResources().getDrawable(R.mipmap.play));
            timer=null;
            ispause=true;
            isRunning=false;

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
            if (a == 6) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.five_secondstimer);
                mp.start();
//                managerOfSound("start");
            }else if(a==1) {
                managerOfSound(R.raw.okplay_end_of_timer);
//                stop_sound.start();

            }


        }

        //When time is finished, what should happen: will go in this method
        @Override
        public void onFinish() {
            // reset all variables

//            timer_pic.setImageResource(R.mipmap.p15);
            isRunning=false;
            ispause=false;
            remainMilli=0;
            isFinished=false;
            stop=false;

            start_flash();
        }
    }



    @Override
    public void onBackPressed() {
        // your code.
        managerOfSound(R.raw.back_button);
        finish();
//        Intent how23=new Intent(getApplicationContext(),Ok_play_homescreen.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound(R.raw.back_button);
            finish();
//            Intent how23=new Intent(getApplicationContext(),Ok_play_homescreen.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onResume() {
        back_press();
        super.onResume();
    }

    @Override
    protected void onPause() {
        back_press();
        super.onPause();
    }
    @Override
    protected void onStop() {
        back_press();
        super.onStop();
    }

    public  void start_flash() {

//        play.setBackground(getResources().getDrawable(R.mipmap.play));
        final Handler handler = new Handler();
        Thread th = new Thread() {
            public void run() {

                if(stop){
                    timer_pic.setVisibility(View.VISIBLE);
                    return;
                }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (timer_pic.getVisibility() == View.VISIBLE) {
                                timer_pic.setVisibility(View.INVISIBLE);
                            } else {
                                timer_pic.setVisibility(View.VISIBLE);
                            }

                        }
                    });
                }

                handler.postDelayed(this, 500);

            }

        };
        th.start();
    }




    private void managerOfSound(int sound) {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), sound);

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
