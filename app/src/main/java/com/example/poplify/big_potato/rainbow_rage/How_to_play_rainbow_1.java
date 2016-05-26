package com.example.poplify.big_potato.rainbow_rage;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.How_to_play_2;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.qwordie.SimpleGestureFilter;

public class How_to_play_rainbow_1 extends AppCompatActivity implements  SimpleGestureFilter.SimpleGestureListener{

    UsefullData usefull;
    Typeface regular,bold;
    private SimpleGestureFilter detector;
    int left_move,right_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usefull=new UsefullData(getApplicationContext());
        usefull.trimCache(getApplicationContext());
        detector = new SimpleGestureFilter(this, this);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        switch (getIntent().getExtras().getString("call","0"))
        {

            case "0":

                setContentView(R.layout.content_how_to_play_rainbow_1);
                TextView v=(TextView)  findViewById(R.id.textView);
                v.setTypeface(regular);

                TextView v1=(TextView)  findViewById(R.id.textView3);
                v1.setTypeface(regular);
                left_move=0;
                right_move=2;

                break;
            case "1":
                setContentView(R.layout.how_to_play_rainbow_2);

                TextView v3=(TextView)  findViewById(R.id.textView);
                v3.setTypeface(regular);

                TextView v4=(TextView)  findViewById(R.id.textView3);
                v4.setTypeface(regular);
                left_move=1;
                right_move=3;
                break;
            case "2":
                setContentView(R.layout.how_to_play_rainbow_3);

                TextView v45=(TextView)  findViewById(R.id.textView);
                v45.setTypeface(regular);

                TextView v54=(TextView)  findViewById(R.id.textView3);
                v54.setTypeface(regular);
                left_move=2;
                right_move=4;

                break;
            case "3":
                setContentView(R.layout.how_to_play_rainbow_4);
                TextView v425=(TextView)  findViewById(R.id.textView);
                v425.setTypeface(regular);

                TextView v524=(TextView)  findViewById(R.id.textView3);
                v524.setTypeface(regular);
                left_move=3;
                right_move=5;
                break;
            case "4":
                setContentView(R.layout.how_to_play_rainbow_5);
                TextView v415=(TextView)  findViewById(R.id.textView);
                v415.setTypeface(regular);

                left_move=4;
                right_move=6;
                break;


        }


    }

    public void how_to_play_screens(View view)
    {
        usefull.trimCache(getApplicationContext());
        switch (view.getId()) {
            case R.id.main_menu: // doStuff
                Intent menuIntent = new Intent(this, RainbowRage.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.first_play: // doStuff

                Intent how1=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how1.putExtra("call","1");
                startActivity(how1);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.two_play: // doStuff

                Intent how2=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how2.putExtra("call","2");
                startActivity(how2);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.third_play: // doStuff

                Intent how3=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how3.putExtra("call","3");
                startActivity(how3);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.fourth_play: // doStuff

                Intent how4=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how4.putExtra("call","4");
                startActivity(how4);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.zero_play_2: // doStuff

                Intent how_2=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_2.putExtra("call","0");
                startActivity(how_2);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.first_play_3: // doStuff

                Intent how_3=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_3.putExtra("call","1");
                startActivity(how_3);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.two_play_4: // doStuff

                Intent how_4=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_4.putExtra("call","2");
                startActivity(how_4);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.third_play_5: // doStuff

                Intent how_5=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_5.putExtra("call","3");
                startActivity(how_5);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT:

               switch (left_move){

                   case 0:
                       Intent menuIntent = new Intent(this, RainbowRage.class);
                       startActivity(menuIntent);
                       overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                    break;
                   case 1:
                       Intent how1=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                       how1.putExtra("call","0");
                       startActivity(how1);
                       overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                       break;
                   case 2:
                       Intent how12=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                       how12.putExtra("call","1");
                       startActivity(how12);
                       overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                       break;
                   case 3:
                       Intent how13=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                       how13.putExtra("call","2");
                       startActivity(how13);
                       overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                       break;
                   case 4:
                       Intent how14=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                       how14.putExtra("call","3");
                       startActivity(how14);
                       overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                       break;
               }

                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                switch (right_move){
                    case 2:
                        Intent how1=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                        how1.putExtra("call","1");
                        startActivity(how1);
                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 3:
                        Intent how13=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                        how13.putExtra("call","2");
                        startActivity(how13);
                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 4:
                        Intent how123=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                        how123.putExtra("call","3");
                        startActivity(how123);
                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 5:
                        Intent how143=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                        how143.putExtra("call","4");
                        startActivity(how143);
                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;

                }

                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                break;
            case SimpleGestureFilter.SWIPE_UP:
                break;

        }
    }
    @Override
    public void onSingleTapUp() {
    }


}
