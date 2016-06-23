package com.example.poplify.big_potato.obla;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 6/23/2016.
 */
public class Obla_extra_cards extends Activity
{

    ImageView act,descr,solve;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obla_extra_cards);

        act=(ImageView) findViewById(R.id.imageView16_act);
        descr=(ImageView) findViewById(R.id.imageView15_desc);
        solve=(ImageView) findViewById(R.id.imageView17_solove);

        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        descr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    }
