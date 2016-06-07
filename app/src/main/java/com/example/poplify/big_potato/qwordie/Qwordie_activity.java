package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.infinite_scroll.MyCloneableView;
import com.example.poplify.big_potato.infinite_scroll.PSInfiniteScrollView;
import com.example.poplify.big_potato.infinite_scroll.PSSize;
import com.example.poplify.big_potato.view_pager.Startup_activity;


public class Qwordie_activity extends Activity implements View.OnClickListener
{

    TextView extra,how,buy;
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

        LinearLayout container = (LinearLayout) findViewById(R.id.relativeLayout);
        PSInfiniteScrollView scrollView = new PSInfiniteScrollView(this,new PSSize(150,120));
        for (int i = 0; i < 8; i++) {
            MyCloneableView img = new MyCloneableView(Qwordie_activity.this);
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

            case R.id.exta_cards:

                Intent extra=new Intent(getApplicationContext(),Extra_cards.class);
                startActivity(extra);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play:
                Intent how=new Intent(getApplicationContext(),Startup_activity.class);
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
