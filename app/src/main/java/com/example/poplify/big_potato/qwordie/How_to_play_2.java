package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_2 extends Activity implements View.OnClickListener
{

    ImageView back,next_activity,privious;
    Typeface regular,bold;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play_2);

        back = (ImageView) findViewById(R.id.back_play_2);
        back.setOnClickListener(this);
        next_activity = (ImageView) findViewById(R.id.next_activity2);
        next_activity.setOnClickListener(this);
        privious = (ImageView) findViewById(R.id.privious_2);
        privious.setOnClickListener(this);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  findViewById(R.id.textView3__2);
        v.setTypeface(regular);

        TextView v1=(TextView)  findViewById(R.id.textView5__2);
        v1.setTypeface(regular);
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events
            case R.id.next_activity2:
                Intent how=new Intent(getApplicationContext(),How_to_play_3.class);
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.back_play_2:
                Intent how23=new Intent(getApplicationContext(),Qwordie_activity.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.privious_2:
                Intent how2=new Intent(getApplicationContext(),How_to_play_1.class);
                startActivity(how2);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

                break;
        }
    }
}
