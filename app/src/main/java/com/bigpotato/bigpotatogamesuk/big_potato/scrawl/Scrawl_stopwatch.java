package com.bigpotato.bigpotatogamesuk.big_potato.scrawl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.UsefullData;

/**
 * Created by POPLIFY on 6/29/2016.
 */
public class Scrawl_stopwatch extends Activity
{
    Button done;
    Button start;
    Button reset;
    LinearLayout setting_layout;
    PopupWindow pwindo,end_popup;
    SaveData save;
    Typeface regular,bold;
    private CounterClass timer;  //Inner User-defined Class
    long remainMilli = 0;
    boolean isRunning=false;
    RelativeLayout back;
    UsefullData usefull;
    RadioButton p4, p5, p6,p7,p8,dr60,dr90,dr120,ds30,ds45,ds60;
    int time;
    ImageView title,face_pic,main_back;
    String current_timer="draw";
    boolean ispause=false;
    int player,pic_index=30;
    TextView player_txt,draw,des;
    MediaPlayer mp,mp_end,mp_back,mp_pass;
    int[] back_pics = new int[] { R.mipmap.scrawl_stopwatch_back_0,R.mipmap.scrawl_stopwatch_back_1,R.mipmap.scrawl_stopwatch_back_2, R.mipmap.scrawl_stopwatch_back_3,R.mipmap.scrawl_stopwatch_back_4,
            R.mipmap.scrawl_stopwatch_back_5,R.mipmap.scrawl_stopwatch_back_6,R.mipmap.scrawl_stopwatch_back_7,R.mipmap.scrawl_stopwatch_back_8,R.mipmap.scrawl_stopwatch_back_9,R.mipmap.scrawl_stopwatch_back_10,
            R.mipmap.scrawl_stopwatch_back_11,R.mipmap.scrawl_stopwatch_back_12, R.mipmap.scrawl_stopwatch_back_13,R.mipmap.scrawl_stopwatch_back_14,
            R.mipmap.scrawl_stopwatch_back_15,R.mipmap.scrawl_stopwatch_back_16,R.mipmap.scrawl_stopwatch_back_17,R.mipmap.scrawl_stopwatch_back_18,R.mipmap.scrawl_stopwatch_back_19,R.mipmap.scrawl_stopwatch_back_20
            ,R.mipmap.scrawl_stopwatch_back_21,R.mipmap.scrawl_stopwatch_back_22, R.mipmap.scrawl_stopwatch_back_23,R.mipmap.scrawl_stopwatch_back_24,
            R.mipmap.scrawl_stopwatch_back_25,R.mipmap.scrawl_stopwatch_back_26,R.mipmap.scrawl_stopwatch_back_27,R.mipmap.scrawl_stopwatch_back_28,R.mipmap.scrawl_stopwatch_back_29,R.mipmap.scrawl_stopwatch_back_30
    };
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw);
        save=new SaveData(getApplicationContext());
        setting_layout=(LinearLayout) findViewById(R.id.set_layout);
        main_back=(ImageView) findViewById(R.id.imageView28);
        back=(RelativeLayout) findViewById(R.id.back_lay);
        done=(Button) findViewById(R.id.button3);
        start=(Button) findViewById(R.id.button4_start);
        reset=(Button) findViewById(R.id.button5dgfdgdfg_ppreset);
        usefull=new UsefullData(getApplicationContext());
        title=(ImageView) findViewById(R.id.imageView17_draw);
        face_pic=(ImageView) findViewById(R.id.imageView23_face);
        player_txt=(TextView) findViewById(R.id.textView9);
        des=(TextView) findViewById(R.id.textView8);
        draw=(TextView) findViewById(R.id.textView7);
        p4 = (RadioButton)findViewById(R.id.radioButton4);
        p5 = (RadioButton)findViewById(R.id.radioButton5);
        p6 = (RadioButton)findViewById(R.id.radioButton6);
        p7 = (RadioButton)findViewById(R.id.radioButton7);
        p8 = (RadioButton)findViewById(R.id.radioButton8);
        p4.setOnClickListener(myOptionOnClickListener);
        p5.setOnClickListener(myOptionOnClickListener);
        p6.setOnClickListener(myOptionOnClickListener);
        p7.setOnClickListener(myOptionOnClickListener);
        p8.setOnClickListener(myOptionOnClickListener);
        mp_back = MediaPlayer.create(this, R.raw.back_button);

        dr60 = (RadioButton)findViewById(R.id.radioButton60);
        dr90 = (RadioButton)findViewById(R.id.radioButton90);
        dr120 = (RadioButton)findViewById(R.id.radioButton120);
        dr60.setOnClickListener(myOptionOnClickListener);
        dr90.setOnClickListener(myOptionOnClickListener);
        dr120.setOnClickListener(myOptionOnClickListener);
        mp = MediaPlayer.create(this, R.raw.five_secondstimer);
        mp_end = MediaPlayer.create(this, R.raw.scrawl_end_of_round);
        ds30 = (RadioButton)findViewById(R.id.radioButtonds30);
        ds45 = (RadioButton)findViewById(R.id.radioButtonds45);
        ds60 = (RadioButton)findViewById(R.id.radioButtonds60);
        ds30.setOnClickListener(myOptionOnClickListener);
        ds45.setOnClickListener(myOptionOnClickListener);
        ds60.setOnClickListener(myOptionOnClickListener);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        player_txt.setTypeface(bold);
        des.setTypeface(bold);
        draw.setTypeface(bold);
        face_pic.setImageResource(R.mipmap.face_0);
        dr60.setTypeface(regular);
        dr90.setTypeface(regular);
        dr120.setTypeface(regular);
        ds60.setTypeface(regular);
        ds45.setTypeface(regular);
        ds30.setTypeface(regular);
        p4.setTypeface(regular);
        p5.setTypeface(regular);
        p6.setTypeface(regular);
        p7.setTypeface(regular);
        p8.setTypeface(regular);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face_pic.setImageResource(R.mipmap.face_0);
                Stop2();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_layout.setVisibility(View.INVISIBLE);
                start.setVisibility(View.VISIBLE);
                reset.setVisibility(View.INVISIBLE);
                main_back.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                if(save.isExist("player")==true) {
                    player=save.getInt("player");
                }else{
                    player=4;
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp_back.start();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//                startActivity(how23);
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                unlockScreen();
                if(!isRunning)
                {
                    if(!ispause){


                        start.setText("Pause");
                        Start();
                    }else{
                        start.setText("Pause");
                        Resume();

                    }
                }else {

                    Pause();
                    start.setText("Resume");
                    reset.setVisibility(View.VISIBLE);

                }
            }
        });

//        setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                setting_layout.setVisibility(View.VISIBLE);

                start.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.INVISIBLE);
                main_back.setVisibility(View.INVISIBLE);
//            }
//        });
    }



    private void initiatePopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater

//            if (player == 0) {
//
//                mp_end.start();
//                endPopupWindow();
//                pwindo.dismiss();
//            }
            mp_pass = MediaPlayer.create(this, R.raw.scrawl_pass);
            mp_pass.start();
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.pass_popup,
                    (ViewGroup) findViewById(R.id.popup_element_pass));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(false);
            pwindo.setFocusable(true);


            final ImageView pass_no = (ImageView) layout.findViewById(R.id.imageView26);
            final Button skip = (Button) layout.findViewById(R.id.button4);
            final int[] pass_pics = new int[] { R.mipmap.scrawl_pass_number_1,R.mipmap.scrawl_pass_number_2, R.mipmap.scrawl_pass_number_3,R.mipmap.scrawl_pass_number_4,
                    R.mipmap.scrawl_pass_number_5,R.mipmap.scrawl_pass_number_6,R.mipmap.scrawl_pass_number_7,R.mipmap.scrawl_pass_number_8,R.mipmap.scrawl_pass_number_9,R.mipmap.scrawl_pass_number_10,
            };
            final CountDownTimer time=new CountDownTimer(10000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                    int a=(int) (millisUntilFinished / 1000);
                    pass_no.setImageResource(pass_pics[a]);


                }

                @Override
                public void onFinish() {

//                    player--;
//                    if (player == 0) {
//
//                        face_pic.setImageResource(R.mipmap.face_1);
//                        main_back.setImageResource(R.mipmap.scrawl_stopwatch_back_30);
//                        Stop2();
//                        pwindo.dismiss();
//                        mp_end.start();
//                        endPopupWindow();
//                    } else {
                        pwindo.dismiss();
                        switch (current_timer) {
                            case "draw":

                                current_timer = "des";
                                break;
                            case "des":
                                current_timer = "draw";
                                break;
                        }

                        if (isRunning) {
                            Pause();
                            start.setText("Pause");
                            reset.setVisibility(View.VISIBLE);

                        } else {

                            Start();
                        }

//                    }
                }
            };
            time.start();

            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    time.cancel();
                    mp_pass.stop();
//                    player--;
//                    if (player == 0) {
//                        face_pic.setImageResource(R.mipmap.face_1);
//                        main_back.setImageResource(R.mipmap.scrawl_stopwatch_back_30);
//                        Stop2();
//                        pwindo.dismiss();
//                        mp_end.start();
//                        endPopupWindow();
//                    } else {
                        pwindo.dismiss();
                        switch (current_timer) {
                            case "draw":

                                current_timer = "des";
                                break;
                            case "des":
                                current_timer = "draw";
                                break;
                        }

                        if (isRunning) {
                            Pause();


                        } else {

                            Start();
                        }

//                    }
                }
            });








        } catch (Exception e) {
            e.printStackTrace();
        }

    }








    public void Start()
    {

        face_pic.setImageResource(R.mipmap.face_1);

            if(current_timer.equals("draw")) {
                if(save.isExist("draw")==false) {
                    timer = new CounterClass(60000, 1000);
                    time = 60000;
                }else {
                    timer = new CounterClass(save.getInt("draw"), 1000);
                    time = save.getInt("draw");
                }

            title.setImageResource(R.mipmap.scrawl_draw_black);

        }else if(current_timer.equals("des")){
                if(save.isExist("des")==false) {
                    timer = new CounterClass(31000, 1000);
                    time = 31000;
                    pic_index=30;
                }else {
                    timer = new CounterClass(save.getInt("des"), 1000);
                    time = save.getInt("des");
                }

            title.setImageResource(R.mipmap.scrawl_describe_black);
         } //Create a new timer
        timer.start();   //Start the timer
        isRunning = true;

//        reset.setVisibility(View.VISIBLE);

        ispause = false;

    }

    //When Stop button clicks
    public void Stop2()
    {
//        current_timer = "draw";
//        if(save.isExist("player")==true) {
//            player=save.getInt("player");
//        }else{
//            player=4;
//        }
        isRunning = false;
        start.setText("Start");
        remainMilli = 0;
//        title.setImageResource(R.mipmap.scrawl_draw_black);
        reset.setVisibility(View.INVISIBLE);
        main_back.setImageResource(R.mipmap.scrawl_stopwatch_back_30);

        if(!ispause){
             timer.cancel();
            start.setText("Pause");
            Start();

         }
        ispause=false;
        start.setText("Pause");
        Start();

    }

    public void back_press()
    {
        if(isRunning==true){
            timer.cancel();
        }

    }


    //When Resume button clicks
    public void Resume() {
        if (!isRunning) {  //This method will execute only when timer is not running
            timer = new CounterClass(remainMilli, 1000); //resume timer from where it is paused
            timer.start();  //Start the timer
            isRunning = true;
            ispause=false;
//            start.setVisibility(View.VISIBLE);

            reset.setVisibility(View.INVISIBLE);
        }
    }

    //When Pause button clicks
    public void Pause() {

        if(isRunning){  //This method will execute only when timer is running
            timer.cancel();  //cancel (pause) timer when it is running
            timer=null;
            isRunning=false;
            ispause=true;
            start.setText("Resume");
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


            if(time==60000){
                    main_back.setImageResource(back_pics[(int)picNumber(2,a)]);
                    pic_index=(int)picNumber(2,a);
            }else if(time==90000){
                    main_back.setImageResource(back_pics[(int)picNumber(3,a)]);
                    pic_index=(int)picNumber(3,a);
            }else if(time==120000){
                     main_back.setImageResource(back_pics[(int)picNumber(4,a)]);
                    pic_index=(int)picNumber(4,a);
            }else if(time==45000){

                main_back.setImageResource(back_pics[(int)picNumber(1.5,a)]);
                pic_index=(int)picNumber(1.5,a);
                Log.i("------value---",""+picNumber(1.5,a));

            }else{
                main_back.setImageResource(back_pics[(int)picNumber(1,a)]);
                pic_index=(int)picNumber(1,a);
                Log.i("------value---",""+picNumber(1,a));
//                main_back.setImageResource(back_pics[a]);
//                pic_index--;
//                Log.i("-----------",""+pic_index);

             }


            switch (pic_index)
            {



                case 5:
                     if (current_timer.equals("draw")) {

                    title.setImageResource(R.mipmap.scrawl_draw);
                    face_pic.setImageResource(R.mipmap.face_5);

                } else if (current_timer.equals("des")) {
                    face_pic.setImageResource(R.mipmap.face_5);
                    title.setImageResource(R.mipmap.scrawl_describe);

                }

                    break;
                case 10:
                    face_pic.setImageResource(R.mipmap.face_left);
                    break;

                case 15:
                    face_pic.setImageResource(R.mipmap.face_4);
                    break;
                case 20:
                    face_pic.setImageResource(R.mipmap.face_3);
                    break;
                case 24:
                    face_pic.setImageResource(R.mipmap.face_2);
                    break;


            }

            if(a==5){
                mp.start();
            }
            if(a==1){

                if (current_timer.equals("des")) {



                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            main_back.setImageResource(R.mipmap.scrawl_stopwatch_back_0);
                            face_pic.setImageResource(R.mipmap.face_6);
                        }
                    }, 1000);



                }else{
                    face_pic.setImageResource(R.mipmap.face_6);
                }

            }



        }

        //When time is finished, what should happen: will go in this method
        @Override
        public void onFinish() {
            // reset all variables
//            timerTextView.setText("Time Up!");

            isRunning=false;
            remainMilli=0;

            ispause=false;
            main_back.setImageResource(R.mipmap.scrawl_stopwatch_back_0);
            face_pic.setImageResource(R.mipmap.face_0);
            player--;
            if (player == 0) {

                mp_end.start();
                endPopupWindow();
                pwindo.dismiss();
            }else {
                initiatePopupWindow();
            }

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
                        case R.id.radioButton4:
                            if (checked)
                            save.save("player",4);

                            p5.setChecked(false);
                            p6.setChecked(false);
                            p7.setChecked(false);
                            p8.setChecked(false);
                            break;
                        case R.id.radioButton5:
                            if (checked)
                                save.save("player",5);
                            p4.setChecked(false);
                            p6.setChecked(false);
                            p7.setChecked(false);
                            p8.setChecked(false);
                            break;
                        case R.id.radioButton6:
                            if (checked)
                                save.save("player",6);
                            p5.setChecked(false);
                            p4.setChecked(false);
                            p7.setChecked(false);
                            p8.setChecked(false);
                            break;
                        case R.id.radioButton7:
                            if (checked)
                                save.save("player",7);
                            p5.setChecked(false);
                            p6.setChecked(false);
                            p4.setChecked(false);
                            p8.setChecked(false);
                            break;
                        case R.id.radioButton8:
                            if (checked)
                                save.save("player",8);
                            p5.setChecked(false);
                            p6.setChecked(false);
                            p7.setChecked(false);
                            p4.setChecked(false);
                            break;
                        case R.id.radioButton60:
                            if (checked)
                                save.save("draw",60000);
                            dr90.setChecked(false);
                            dr120.setChecked(false);


                            break;
                        case R.id.radioButton90:
                            if (checked)
                                save.save("draw",90000);
                            dr60.setChecked(false);
                            dr120.setChecked(false);

                            break;
                        case R.id.radioButton120:
                            if (checked)
                                save.save("draw",120000);
                            dr60.setChecked(false);
                            dr90.setChecked(false);

                            break;
                        case R.id.radioButtonds30:
                            if (checked)
                                save.save("des",31000);
                            ds45.setChecked(false);
                            ds60.setChecked(false);


                            break;
                        case R.id.radioButtonds45:
                            if (checked)
                                save.save("des",45000);
                            ds30.setChecked(false);
                            ds60.setChecked(false);

                            break;
                        case R.id.radioButtonds60:
                            if (checked)
                                save.save("des",60000);
                            ds45.setChecked(false);
                            ds30.setChecked(false);

                            break;
                    }

                }
            };




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



    private void endPopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater

            current_timer.equals("draw");
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.scrawl_end_popup,
                    (ViewGroup) findViewById(R.id.popup_element_end));
            end_popup = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            end_popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
            end_popup.setOutsideTouchable(false);
            end_popup.setFocusable(true);


//            final ImageView cross = (ImageView) layout.findViewById(R.id.imageView26);
            final Button menu = (Button) layout.findViewById(R.id.butgfdhfghton4);

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_popup.dismiss();
                    back_press();
                    finish();
//                    Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//                    startActivity(how23);
//                    overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                }
            });
            final Button restart = (Button) layout.findViewById(R.id.butfdfdgdfgton4);

            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_popup.dismiss();
                    back_press();
                    current_timer = "draw";
                    if(save.isExist("player")==true) {
                        player=save.getInt("player");
                    }else{
                        player=4;
                    }
                Start();
                }
            });







        } catch (Exception e) {
            e.printStackTrace();
        }

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
        Pause();
        usefull.trimCache(getApplicationContext());
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        // your code.
        mp_back.start();
        finish();
//        Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
    @Override
    protected void onStart() {
        back_press();
        usefull.trimCache(getApplicationContext());
        super.onStart();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mp_back.start();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    private void unlockScreen() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }

}
