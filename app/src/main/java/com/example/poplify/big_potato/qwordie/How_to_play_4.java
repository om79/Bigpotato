package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_4 extends Activity implements View.OnClickListener, SimpleGestureFilter.SimpleGestureListener
{

    ImageView back,privious;
    Button menu;
    Typeface regular,bold;
    private SimpleGestureFilter detector;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play_4);


        detector = new SimpleGestureFilter(this, this);
        back = (ImageView) findViewById(R.id.back_play_4);
        back.setOnClickListener(this);

        privious = (ImageView) findViewById(R.id.privious_4);
        privious.setOnClickListener(this);

        menu = (Button) findViewById(R.id.button_menu);
        menu.setOnClickListener(this);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  findViewById(R.id.text_View3);
        v.setTypeface(regular);

        menu.setTypeface(bold);
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.back_play_4:
                Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.privious_4:
                Intent how2=new Intent(getApplicationContext(),How_to_play_3.class);
                startActivity(how2);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

                break;
            case R.id.button_menu:
                Intent howm=new Intent(getApplicationContext(),Qwordie_activity.class);
                startActivity(howm);
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

                Intent how23=new Intent(getApplicationContext(),How_to_play_3.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

                break;
            case SimpleGestureFilter.SWIPE_LEFT:

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
