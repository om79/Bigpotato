package com.example.poplify.big_potato.rainbow_rage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.recycle_view_adapter.RolodexViewAdapter;
import com.example.poplify.big_potato.view_pager.Startup_activity;
import com.example.poplify.big_potato.viewpager_training.Startup_training_activity;
import com.example.poplify.big_potato.youtube.Youtube_activity;

public class RainbowRage extends Activity {


    UsefullData usefull;
    SaveData save;
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
        setContentView(R.layout.activity_rainbow_rage);
        usefull=new UsefullData(RainbowRage.this);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        save=new SaveData(getApplicationContext());
        TextView v=(TextView)  findViewById(R.id.how_to_play_rainbow);
        v.setTypeface(bold);

        TextView v1=(TextView)  findViewById(R.id.textView2);
        v1.setTypeface(regular);

        TextView v3=(TextView)  findViewById(R.id.textView23);
        v3.setTypeface(regular);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.scrollToPosition(5);
        mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"rainbow");
        mRecyclerView.setAdapter(mAdapter);


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
            case R.id.textView23:
                save.save("show_trng_popup",true);
                Intent how2=new Intent(getApplicationContext(),Startup_training_activity.class);
                startActivity(how2);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.imageView7_back:
                finish();
                break;
        }
    }
}
