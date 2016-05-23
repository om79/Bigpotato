package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;


public class Qwordie_activity extends Activity implements View.OnClickListener
{

    TextView extra,how,buy;
    ImageView back;
    UsefullData usefull;
    Typeface regular,bold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qwordie_activity);


        extra=(TextView) findViewById(R.id.exta_cards);
        extra.setOnClickListener(this);
        how=(TextView) findViewById(R.id.how_to_play);
        how.setOnClickListener(this);
        buy=(TextView) findViewById(R.id.buy_the_game);
        buy.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        usefull=new UsefullData(Qwordie_activity.this);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        extra.setTypeface(bold);
        buy.setTypeface(regular);
        how.setTypeface(regular);



    }


    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards:

                Intent extra=new Intent(getApplicationContext(),Extra_cards.class);
                startActivity(extra);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play:
                Intent how=new Intent(getApplicationContext(),How_to_play_1.class);

                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game:


                usefull.showpopup();
                break;
            case R.id.back:
                finish();
                break;
        }
    }





}
