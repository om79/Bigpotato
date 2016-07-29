package com.bigpotato.bigpotatogamesuk.big_potato.ok_play;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.ConnectionDetector;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.UsefullData;
import com.bigpotato.bigpotatogamesuk.big_potato.view_pager.Startup_activity;
import com.flurry.android.FlurryAgent;

/**
 * Created by POPLIFY on 6/4/2016.
 */
public class Ok_play_homescreen extends Fragment implements View.OnClickListener
{

    TextView extra,how,buy;
    ImageButton back;
    UsefullData usefull;
    Typeface regular,bold;
    MediaPlayer mp;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    public Ok_play_homescreen(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ok_play_homescreen, container, false);


        cd = new ConnectionDetector(getActivity());
        isInternetPresent = cd.isConnectingToInternet();
        extra=(TextView) rootView.findViewById(R.id.exta_cards_bod_okplay);
        extra.setOnClickListener(this);
        mp = MediaPlayer.create(getActivity(), R.raw.back_button);
        how=(TextView) rootView.findViewById(R.id.how_to_play_bod_okplay);
        how.setOnClickListener(this);
        buy=(TextView) rootView.findViewById(R.id.buy_the_game_bod_okplay);
        buy.setOnClickListener(this);
        back = (ImageButton) rootView.findViewById(R.id.back_bod_okplay);
        back.setOnClickListener(this);
        usefull=new UsefullData(getActivity());

        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        extra.setTypeface(bold);
        buy.setTypeface(regular);
        how.setTypeface(regular);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.scrollToPosition(7);
////        mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"ok_play");
//        mRecyclerView.setAdapter(mAdapter);

        return rootView;

    }




    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards_bod_okplay:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("OK Play");
                }
                Intent how2=new Intent(getActivity(),Startup_activity.class);
                startActivity(how2);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;


            case R.id.how_to_play_bod_okplay:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("OK Play");
                }
                Intent how=new Intent(getActivity(),Okplay_timer.class);
                startActivity(how);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game_bod_okplay:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("OK Play");
                }
                usefull.showpopup();
                break;
            case R.id.back_bod_okplay:
                mp.start();
                getActivity().finish();
                break;
        }
    }



//    @Override
//    public void onBackPressed() {
//        // your code.
//        mp.start();
//        finish();
//        Intent how23=new Intent(getApplicationContext(),Game_menu.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            mp.start();
//            finish();
//            Intent how23=new Intent(getApplicationContext(),Game_menu.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

}


