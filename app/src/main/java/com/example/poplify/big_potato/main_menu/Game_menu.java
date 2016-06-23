package com.example.poplify.big_potato.main_menu;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.recycle_view_adapter.RolodexViewAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by POPLIFY on 5/18/2016.
 */
 public class Game_menu extends Activity {

    UsefullData usefull;
    SaveData save;

    Typeface regular, bold;


    int[] pic = new int[] { R.mipmap.bod,R.mipmap.qwordie, R.mipmap.scrawl,R.mipmap.rainbow_rage,
            R.mipmap.mr_lister,R.mipmap.obamallama,R.mipmap.social,R.mipmap.okplay_background};
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        LinearLayout container = (LinearLayout) findViewById(R.id.menu_container);

        usefull = new UsefullData(getApplicationContext());
        save = new SaveData(getApplicationContext());
        regular = Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_menu);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RolodexViewAdapter_menu(pic,getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);




    }





}
