package com.example.poplify.big_potato.scrawl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;
import com.example.poplify.big_potato.recycle_view_adapter.RolodexViewAdapter;
import com.example.poplify.big_potato.youtube.Youtube_activity;

/**
 * Created by POPLIFY on 6/22/2016.
 */
public class Scraml_homepage extends Activity implements View.OnClickListener
{

    TextView stopwatch,how,buy,randomizar;
    ImageView back;
    UsefullData usefull;
    Typeface regular,bold;


    String[] cs = new String[] { "bod", "qworide", "scrwal", "rainbow", "mr_lister",
            "obama", "social","ok_play" };
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    int[] c = new int[] { R.mipmap.bod,R.mipmap.qwordie, R.mipmap.scrawl,R.mipmap.rainbow_rage,
            R.mipmap.mr_lister,R.mipmap.obamallama,R.mipmap.social,R.mipmap.ok_play};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrwal_hompage);


        randomizar=(TextView) findViewById(R.id.exta_stopwatch_scrawl);
        randomizar.setOnClickListener(this);
        stopwatch=(TextView) findViewById(R.id.exta_cards_scrawl);
        stopwatch.setOnClickListener(this);
        how=(TextView) findViewById(R.id.how_to_play_scrawl);
        how.setOnClickListener(this);
        buy=(TextView) findViewById(R.id.buy_the_game_scrawl);
        buy.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back_scrawl);
        back.setOnClickListener(this);
        usefull=new UsefullData(Scraml_homepage.this);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        stopwatch.setTypeface(regular);
        buy.setTypeface(regular);
        how.setTypeface(bold);
        randomizar.setTypeface(regular);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.scrollToPosition(0);
        mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"qworide");
        mRecyclerView.setAdapter(mAdapter);



    }




    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards_scrawl:

//                Intent extra=new Intent(getApplicationContext(),Extra_cards.class);
//                startActivity(extra);
//                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play_scrawl:
                Intent how=new Intent(getApplicationContext(),Youtube_activity.class);
                how.putExtra("how","scrawl");
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game_scrawl:


                usefull.showpopup();
                break;
            case R.id.back_scrawl:
                finish();
                break;
            case R.id.exta_stopwatch_scrawl:

                Intent extra=new Intent(getApplicationContext(),Raindoimzar.class);
                startActivity(extra);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;
        }
    }





}
