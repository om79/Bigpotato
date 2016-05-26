package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_1 extends Activity implements View.OnClickListener, SimpleGestureFilter.SimpleGestureListener
{
    ImageView back,next_activity;
    Typeface regular,bold;
    private SimpleGestureFilter detector;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play_1);

        back = (ImageView) findViewById(R.id.back_play_1);
        back.setOnClickListener(this);
        next_activity = (ImageView) findViewById(R.id.next_activity);
        next_activity.setOnClickListener(this);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        detector = new SimpleGestureFilter(this, this);

        TextView v=(TextView)  findViewById(R.id.textView3_1);
        v.setTypeface(regular);
    }


    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events
            case R.id.next_activity:
                Intent how=new Intent(getApplicationContext(),How_to_play_2.class);
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.back_play_1:
                Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
                startActivity(how23);
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

                Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                Intent how=new Intent(getApplicationContext(),How_to_play_2.class);
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
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
