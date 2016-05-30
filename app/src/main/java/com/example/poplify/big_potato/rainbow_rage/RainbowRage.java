package com.example.poplify.big_potato.rainbow_rage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.Extra_cards;
import com.example.poplify.big_potato.qwordie.How_to_play_1;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.view_pager.Startup_activity;

public class RainbowRage extends Activity {


    UsefullData usefull;
    Typeface regular,bold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_rage);
        usefull=new UsefullData(RainbowRage.this);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  findViewById(R.id.how_to_play_rainbow);
        v.setTypeface(bold);

        TextView v1=(TextView)  findViewById(R.id.textView2);
        v1.setTypeface(bold);
    }



    public void howtoplay(View view)
    {


        switch (view.getId())
        {


            case R.id.how_to_play_rainbow:
                Intent how=new Intent(getApplicationContext(),Startup_activity.class);
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.textView2:

               usefull.showpopup();
                break;
            case R.id.imageView7_back:
                finish();
                break;
        }
    }
}
