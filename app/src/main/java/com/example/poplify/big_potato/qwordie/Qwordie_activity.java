package com.example.poplify.big_potato.qwordie;

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
import com.example.poplify.big_potato.recycle_view_adapter.RolodexViewAdapter;
import com.example.poplify.big_potato.view_pager.Startup_activity;
import com.example.poplify.big_potato.youtube.Youtube_activity;


public class Qwordie_activity extends Activity implements View.OnClickListener
{

    TextView extra,how,buy;
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

        extra.setTypeface(regular);
        buy.setTypeface(regular);
        how.setTypeface(bold);

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

            case R.id.exta_cards:

                Intent extra=new Intent(getApplicationContext(),Extra_cards.class);
                startActivity(extra);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play:
                Intent how2=new Intent(getApplicationContext(),Startup_activity.class);
                startActivity(how2);
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
