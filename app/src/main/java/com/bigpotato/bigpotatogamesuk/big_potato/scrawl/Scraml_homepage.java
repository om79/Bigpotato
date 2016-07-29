package com.bigpotato.bigpotatogamesuk.big_potato.scrawl;

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
 * Created by POPLIFY on 6/22/2016.
 */
public class Scraml_homepage extends Fragment implements View.OnClickListener
{

    TextView stopwatch,how,buy,randomizar;
    ImageButton back;
    UsefullData usefull;
    Typeface regular,bold;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    public Scraml_homepage(){}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.scrwal_hompage, container, false);


        cd = new ConnectionDetector(getActivity());
        isInternetPresent = cd.isConnectingToInternet();
        randomizar=(TextView)  rootView.findViewById(R.id.exta_stopwatch_scrawl);
        randomizar.setOnClickListener(this);
        stopwatch=(TextView)  rootView.findViewById(R.id.exta_cards_scrawl);
        stopwatch.setOnClickListener(this);
        how=(TextView)  rootView.findViewById(R.id.how_to_play_scrawl);
        how.setOnClickListener(this);
        buy=(TextView)  rootView.findViewById(R.id.buy_the_game_scrawl);
        buy.setOnClickListener(this);
        back = (ImageButton)  rootView.findViewById(R.id.back_scrawl);
        back.setOnClickListener(this);
        usefull=new UsefullData(getActivity());
        usefull.trimCache(getActivity());
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        stopwatch.setTypeface(regular);
        buy.setTypeface(regular);
        how.setTypeface(bold);
        randomizar.setTypeface(regular);




        return rootView;
    }




    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards_scrawl:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Scrawl");
                }
                usefull.trimCache(getActivity());
                Intent exsdftra=new Intent(getActivity(),Scrawl_stopwatch.class);
                startActivity(exsdftra);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play_scrawl:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Scrawl");
                }
                usefull.trimCache(getActivity());
                Intent how2=new Intent(getActivity(),Startup_activity.class);
                startActivity(how2);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game_scrawl:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Scrawl");
                }
                usefull.trimCache(getActivity());
                usefull.showpopup();
                break;
            case R.id.back_scrawl:
                usefull.trimCache(getActivity());
                managerOfSound();
                getActivity().finish();
                break;
            case R.id.exta_stopwatch_scrawl:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Scrawl");
                }
                usefull.trimCache(getActivity());

                Intent extra=new Intent(getActivity(),Raindoimzar.class);
                startActivity(extra);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


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

    private void managerOfSound() {

        MediaPlayer mp= MediaPlayer.create(getActivity(), R.raw.back_button);
        if (!mp.isPlaying()) {
            mp.start();
        } else {

            mp.stop();


        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.reset();
                mp.release();


            }
        });
    }

}
