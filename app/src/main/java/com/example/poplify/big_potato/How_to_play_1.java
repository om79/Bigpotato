package com.example.poplify.big_potato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_1 extends Activity implements View.OnClickListener
{
    ImageView back,next_activity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play_1);

        back = (ImageView) findViewById(R.id.back_play_1);
        back.setOnClickListener(this);
        next_activity = (ImageView) findViewById(R.id.next_activity);
        next_activity.setOnClickListener(this);
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
                finish();
                break;
        }
    }




}
