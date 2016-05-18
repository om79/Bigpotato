package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_4 extends Activity implements View.OnClickListener
{

    ImageView back,privious;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play_4);

        back = (ImageView) findViewById(R.id.back_play_4);
        back.setOnClickListener(this);

        privious = (ImageView) findViewById(R.id.privious_4);
        privious.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.back_play_4:
                finish();
                break;
            case R.id.privious_4:
                Intent how2=new Intent(getApplicationContext(),How_to_play_3.class);
                startActivity(how2);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

                break;
        }
    }
}
