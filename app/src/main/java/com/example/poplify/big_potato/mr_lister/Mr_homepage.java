package com.example.poplify.big_potato.mr_lister;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_extra_cards;
import com.example.poplify.big_potato.bucket_of_doom.Bod_scenario;
import com.example.poplify.big_potato.infinite_scroll.MyCloneableView;
import com.example.poplify.big_potato.infinite_scroll.PSInfiniteScrollView;
import com.example.poplify.big_potato.infinite_scroll.PSSize;
import com.example.poplify.big_potato.view_pager.Startup_activity;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_homepage extends Activity implements View.OnClickListener
{

    TextView extra,how,buy,scenario;
    ImageView back;
    UsefullData usefull;
    Typeface regular,bold;


    int[] c = new int[] { R.mipmap.bod,R.mipmap.qwordie, R.mipmap.scrawl,R.mipmap.rainbow_rage,
            R.mipmap.mr_lister,R.mipmap.obamallama,R.mipmap.social,R.mipmap.ok_play};

    String[] cs = new String[] { "bod", "qworide", "scrwal", "rainbow", "mr_lister",
            "obama", "social","ok_play" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mr_homepage);


        extra=(TextView) findViewById(R.id.exta_cards_bod_mr);
        extra.setOnClickListener(this);
        scenario=(TextView) findViewById(R.id.exta_cards_scen_bod_mr);
        scenario.setOnClickListener(this);
        how=(TextView) findViewById(R.id.how_to_play_bod_mr);
        how.setOnClickListener(this);
        buy=(TextView) findViewById(R.id.buy_the_game_bod_mr);
        buy.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back_bod_mr);
        back.setOnClickListener(this);
        usefull=new UsefullData(Mr_homepage.this);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        extra.setTypeface(bold);
        buy.setTypeface(regular);
        how.setTypeface(regular);

        LinearLayout container = (LinearLayout) findViewById(R.id.relativeLayout_bod_mr);
        PSInfiniteScrollView scrollView = new PSInfiniteScrollView(this,new PSSize(150,120));
        for (int i = 0; i < 8; i++) {
            MyCloneableView img = new MyCloneableView(Mr_homepage.this);
            img.setId(i + 10);
            img.setImageResource(c[i]);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
//            img.setBackgroundColor(c[i]);
            img.setTag(cs[i]);
            scrollView.addItem(img);
        }

        container.addView(scrollView);


    }




    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards_bod_mr:

                Intent extra=new Intent(getApplicationContext(),Mr_extra_cards.class);
                startActivity(extra);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;
            case R.id.exta_cards_scen_bod_mr:

                Intent s=new Intent(getApplicationContext(),Mr_sound_effect.class);
                startActivity(s);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play_bod_mr:
                Intent how=new Intent(getApplicationContext(),Startup_activity.class);
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game_bod_mr:
                usefull.showpopup();
                break;
            case R.id.back_bod_mr:
                finish();
                break;
        }
    }





}

