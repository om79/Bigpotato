package com.bigpotato.bigpotatogamesuk.big_potato.obla;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;

/**
 * Created by POPLIFY on 6/27/2016.
 */
public class Obla_timer extends Activity
{

    private CounterClass timer;  //Inner User-defined Class
    long remainMilli = 0;
    boolean isRunning=false;
    LinearLayout main_back;

    ImageView t_digit,setting,dot_back,obla_pic;
    SaveData save;
    int pic_index=29,time;
    LinearLayout set_layout;
    MediaPlayer mp,mp2;
    RelativeLayout back;
    boolean ispause=false;
    RadioButton radiobutton30, radiobutton60, radiobutton90;
    int[] back_pics = new int[] { R.mipmap.obla_timer_back0,R.mipmap.obla_timer_back1,R.mipmap.obla_timer_back2, R.mipmap.obla_timer_back3,R.mipmap.obla_timer_back4,
            R.mipmap.obla_timer_back5,R.mipmap.obla_timer_back6,R.mipmap.obla_timer_back7,R.mipmap.obla_timer_back8,R.mipmap.obla_timer_back9,R.mipmap.obla_timer_back10,
            R.mipmap.obla_timer_back11,R.mipmap.obla_timer_back12, R.mipmap.obla_timer_back13,R.mipmap.obla_timer_back14,
            R.mipmap.obla_timer_back15,R.mipmap.obla_timer_back16,R.mipmap.obla_timer_back17,R.mipmap.obla_timer_back18,R.mipmap.obla_timer_back19,R.mipmap.obla_timer_back20
            ,R.mipmap.obla_timer_back21,R.mipmap.obla_timer_back22, R.mipmap.obla_timer_back23,R.mipmap.obla_timer_back24,
            R.mipmap.obla_timer_back25,R.mipmap.obla_timer_back26,R.mipmap.obla_timer_back27,R.mipmap.obla_timer_back28,R.mipmap.obla_timer_back29,R.mipmap.obla_timer_back30
    };
    int[] timer_digit=new int[]{R.mipmap.obla1,R.mipmap.obla2,R.mipmap.obla3, R.mipmap.obla4,R.mipmap.obla5,
            R.mipmap.obla6,R.mipmap.obla7,R.mipmap.obla8,R.mipmap.obla9,R.mipmap.obla10,
            R.mipmap.obla11,R.mipmap.obla12,R.mipmap.obla13, R.mipmap.obla14,R.mipmap.obla15,
            R.mipmap.obla16,R.mipmap.obla17,R.mipmap.obla18,R.mipmap.obla19,R.mipmap.obla20,
            R.mipmap.obla21,R.mipmap.obla22,R.mipmap.obla23, R.mipmap.obla24,R.mipmap.obla25,
            R.mipmap.obla26,R.mipmap.obla27,R.mipmap.obla28,R.mipmap.obla29,R.mipmap.obla30,
            R.mipmap.obla31,R.mipmap.obla32,R.mipmap.obla33, R.mipmap.obla34,R.mipmap.obla35,
            R.mipmap.obla36,R.mipmap.obla37,R.mipmap.obla38,R.mipmap.obla39,R.mipmap.obla40,
            R.mipmap.obla41,R.mipmap.obla42,R.mipmap.obla43, R.mipmap.obla44,R.mipmap.obla45,
            R.mipmap.obla46,R.mipmap.obla47,R.mipmap.obla48,R.mipmap.obla49,R.mipmap.obla50,
            R.mipmap.obla51,R.mipmap.obla52,R.mipmap.obla53, R.mipmap.obla54,R.mipmap.obla55,
            R.mipmap.obla56,R.mipmap.obla57,R.mipmap.obla58,R.mipmap.obla59,R.mipmap.obla60,
            R.mipmap.obla61,R.mipmap.obla62,R.mipmap.obla63, R.mipmap.obla64,R.mipmap.obla65,
            R.mipmap.obla66,R.mipmap.obla67,R.mipmap.obla68,R.mipmap.obla69,R.mipmap.obla70,
            R.mipmap.obla71,R.mipmap.obla72,R.mipmap.obla73, R.mipmap.obla74,R.mipmap.obla75,
            R.mipmap.obla76,R.mipmap.obla77,R.mipmap.obla78,R.mipmap.obla79,R.mipmap.obla80,
            R.mipmap.obla81,R.mipmap.obla82,R.mipmap.obla83, R.mipmap.obla84,R.mipmap.obla85,
            R.mipmap.obla86,R.mipmap.obla87,R.mipmap.obla88,R.mipmap.obla89,R.mipmap.obla90

    };

    Button start,resume,reset,done;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obla_timer);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        save=new SaveData(getApplicationContext());
        start=(Button) findViewById(R.id.bufgdftton4sfsd);
        resume=(Button) findViewById(R.id.budfgfdtton3);
        done=(Button) findViewById(R.id.bufdgfsdgtton3);
        reset=(Button) findViewById(R.id.buttdfgdon4);
        t_digit=(ImageView) findViewById(R.id.imagegghfhgView16);
        obla_pic=(ImageView) findViewById(R.id.imageView15);
        dot_back=(ImageView) findViewById(R.id.imageView29);
        setting=(ImageView) findViewById(R.id.imageVigfdgew16);
        main_back=(LinearLayout) findViewById(R.id.main_timer_back);
        set_layout=(LinearLayout) findViewById(R.id.setting);
        back=(RelativeLayout) findViewById(R.id.back_layout);
        radiobutton30 = (RadioButton)findViewById(R.id.radioButton);
        radiobutton60 = (RadioButton)findViewById(R.id.radioButton2);
        radiobutton90 = (RadioButton)findViewById(R.id.radioButton3);
        radiobutton30.setOnClickListener(myOptionOnClickListener);
        radiobutton60.setOnClickListener(myOptionOnClickListener);
        radiobutton90.setOnClickListener(myOptionOnClickListener);
        mp = MediaPlayer.create(this, R.raw.five_secondstimer);
        mp2 = MediaPlayer.create(this, R.raw.obla_end_of_timer);

        switch (save.getInt("sec")){


            case 60000:
                t_digit.setImageResource(R.mipmap.obla60);
                radiobutton60.setChecked(true);
                radiobutton90.setChecked(false);
                radiobutton30.setChecked(false);
                break;
            case 90000:
                t_digit.setImageResource(R.mipmap.obla90);
                radiobutton90.setChecked(true);
                radiobutton60.setChecked(false);
                radiobutton30.setChecked(false);
                break;
            default:
                t_digit.setImageResource(R.mipmap.obla30);
                radiobutton30.setChecked(true);
                radiobutton90.setChecked(false);
                radiobutton60.setChecked(false);
                break;
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if(isRunning)
                {
                    Pause();


                }else {
                     unlockScreen();
                    Start();
                }
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    set_layout.setVisibility(View.VISIBLE);

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
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                set_layout.setVisibility(View.GONE);

            }
        });

    }

    @Override
    protected void onResume() {
        back_press();
        Log.i("--onResume--","---call---");
//        wl.release();
        super.onResume();
    }

    @Override
    protected void onPause() {
        back_press();
        Log.i("--onPause--","---call---");
//        wl.release();
        super.onPause();
    }


    public void Start()
    {
        pic_index=29;
//        timer.cancel();  //First of all, cancel the running timer
        if(save.isExist("sec")==false) {
            timer = new CounterClass(30000,1000);
            time=30000;
        }else {
            timer = new CounterClass(save.getInt("sec"), 1000);
            time=save.getInt("sec");
            Log.i("--save.getInt(\"sec\")--",""+save.getInt("sec"));
        } //Create a new timer
        timer.start();   //Start the timer
        isRunning = true;
        start.setText("Pause");
        setting.setVisibility(View.GONE);
        ispause=false;
    }

    //When Stop button clicks
    public void Stop(View view)
    {
        main_back.setBackgroundResource(R.mipmap.obla_green);
//        timer.cancel();  //Cancel the running timer
        if(ispause) {
            setting.setVisibility(View.VISIBLE);
            isRunning = false;
            remainMilli = 0;
            start.setText("Start");

            start.setVisibility(View.VISIBLE);
            resume.setVisibility(View.GONE);
            reset.setVisibility(View.GONE);
            dot_back.setImageResource(R.mipmap.obla_timer_back30);
        }else{
            timer.cancel();
            setting.setVisibility(View.VISIBLE);
            isRunning = false;
            remainMilli = 0;
            start.setText("Start");

            start.setVisibility(View.VISIBLE);
            resume.setVisibility(View.GONE);
            reset.setVisibility(View.GONE);
            dot_back.setImageResource(R.mipmap.obla_timer_back30);
        }
        switch (save.getInt("sec")){


            case 60000:
                t_digit.setImageResource(R.mipmap.obla60);
                break;
            case 90000:
                t_digit.setImageResource(R.mipmap.obla90);
                break;
            default:
                t_digit.setImageResource(R.mipmap.obla30);
                break;
        }

    }

    public void back_press()
    {
        if(isRunning==true){
            timer.cancel();
        }

    }
    //When Resume button clicks
    public void Resume(View view) {
        if (!isRunning) {  //This method will execute only when timer is not running
            timer = new CounterClass(remainMilli, 1000); //resume timer from where it is paused
            timer.start();  //Start the timer
            isRunning = true;
            start.setVisibility(View.VISIBLE);
            resume.setVisibility(View.GONE);
            reset.setVisibility(View.GONE);
            ispause=false;
        }
    }

    //When Pause button clicks
    public void Pause() {

        if(isRunning){  //This method will execute only when timer is running
            timer.cancel();  //cancel (pause) timer when it is running
            timer=null;
            isRunning=false;
            ispause=true;
            start.setVisibility(View.GONE);
            resume.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);
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
            Log.i("----",""+(int) (remainMilli / 1000));
            int a=(int) (remainMilli / 1000);
            t_digit.setImageResource(timer_digit[a-1]);

            if (a == 5) {

                mp.start();
            }
            if(pic_index==16){
                main_back.setBackgroundResource(R.mipmap.obla_purple);
            } else if(pic_index==6){
                main_back.setBackgroundResource(R.mipmap.obla_red);
            }else if(pic_index==29){
                main_back.setBackgroundResource(R.mipmap.obla_green);
            }

            if(time==60000){

                        dot_back.setImageResource(back_pics[(int)picNumber(2,a) ]);
                        pic_index=(int)picNumber(2,a);



            }else if(time==90000){

                                        dot_back.setImageResource(back_pics[(int)picNumber(3,a) ]);
                pic_index=(int)picNumber(2,a);


            }else{
                dot_back.setImageResource(back_pics[(int)picNumber(1,a)]);
                pic_index=(int)picNumber(1,a);
            }

            Log.i("---pic_index--",""+pic_index);



        }

        //When time is finished, what should happen: will go in this method
        @Override
        public void onFinish() {

            // reset all variables
//            timerTextView.setText("Time Up!");
            start.setText("Start");
            isRunning=false;
            remainMilli=0;
            t_digit.setImageResource(R.mipmap.obla_timer_back0);
            dot_back.setImageResource(R.mipmap.obla_timer_back0);
            ispause=false;
            mp2.start();
            obla_pic.setImageResource(R.mipmap.obla_tafter_imer);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    main_back.setBackgroundResource(R.mipmap.obla_green);
                    setting.setVisibility(View.VISIBLE);
                    start.setVisibility(View.VISIBLE);
                    resume.setVisibility(View.GONE);
                    reset.setVisibility(View.GONE);
                    dot_back.setImageResource(R.mipmap.obla_timer_back30);
                    obla_pic.setImageResource(R.mipmap.obla_timer_pic);
                    switch (save.getInt("sec")){


                        case 60000:
                            t_digit.setImageResource(R.mipmap.obla60);
                            break;
                        case 90000:
                            t_digit.setImageResource(R.mipmap.obla90);
                            break;
                        default:
                            t_digit.setImageResource(R.mipmap.obla30);
                            break;
                    }
                }
            }, 2000);
        }
    }





    RadioButton.OnClickListener myOptionOnClickListener =
            new RadioButton.OnClickListener()
            {

                @Override
                public void onClick(View v) {// Is the button now checked?
                    boolean checked = ((RadioButton) v).isChecked();

                    // Check which radio button was clicked
                    switch(v.getId()) {
                        case R.id.radioButton:
                            if (checked)
//                                textview.setText("Radio Button 1 is checked by setOnClickListener");
                            save.save("sec",30000);
                            t_digit.setImageResource(R.mipmap.obla30);
                            radiobutton60.setChecked(false);
                            radiobutton90.setChecked(false);
                            break;
                        case R.id.radioButton2:
                            if (checked)
//                                textview.setText("Radio Button 2 is checked by setOnClickListener");
                                save.save("sec",60000);
                            t_digit.setImageResource(R.mipmap.obla60);
                            radiobutton30.setChecked(false);
                            radiobutton90.setChecked(false);
                            break;
                        case R.id.radioButton3:
                            if (checked)
//                                textview.setText("Radio Button 3 is checked by setOnClickListener");
                                save.save("sec",90000);
                            t_digit.setImageResource(R.mipmap.obla90);
                            radiobutton60.setChecked(false);
                            radiobutton30.setChecked(false);
                            break;
                    }

                }
            };


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



    @Override
    protected void onStop() {
        Log.i("--onStop--","---call---");
        Pause();
        super.onStop();
    }

    private void unlockScreen() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }


    public double picNumber(double gap,double sec) {

        double reminder, divident = 0;
        if (sec > gap) {
            reminder = sec % gap;
        } else {
            reminder = 0;
        }

        divident = sec / gap;
        if (reminder != 1 && reminder != 0) {
            divident = divident + picNumber(gap - 1, reminder);
        } else {
            divident = divident + reminder;
        }


        return divident;
    }


}
