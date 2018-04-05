package com.bigpotato.bigpotatogamesus.big_potato.bucket_of_doom;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesus.big_potato.R;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.ConnectionDetector;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.UsefullData;
import com.bigpotato.bigpotatogamesus.big_potato.view_pager.Startup_activity;
import com.flurry.android.FlurryAgent;

/**
 * Created by POPLIFY on 6/2/2016.
 */
public class Bod_homepage extends Fragment implements View.OnClickListener
{

    TextView extra,how,buy,scenario,tag;
    ImageButton back;
    UsefullData usefull;
    Typeface regular,bold;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    public Bod_homepage(){}
    ImageView blink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.bod_hompage, container, false);

        cd = new ConnectionDetector(getActivity());
        isInternetPresent = cd.isConnectingToInternet();
        extra=(TextView) rootView.findViewById(R.id.exta_cards_bod);
        extra.setOnClickListener(this);
        scenario=(TextView) rootView.findViewById(R.id.exta_cards_scen_bod);
        scenario.setOnClickListener(this);
        how=(TextView) rootView.findViewById(R.id.how_to_play_bod);
        how.setOnClickListener(this);
        buy=(TextView) rootView.findViewById(R.id.buy_the_game_bod);
        buy.setOnClickListener(this);
        back = (ImageButton) rootView.findViewById(R.id.back_bod);
        back.setOnClickListener(this);
        usefull=new UsefullData(getActivity());
        usefull.trimCache(getActivity());
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        how.setTypeface(bold);
        buy.setTypeface(regular);
        extra.setTypeface(regular);
        scenario.setTypeface(regular);
        tag=(TextView) rootView.findViewById(R.id.hashtag);
        tag.setTypeface(regular);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms

                        try {
                            ImageView blink=(ImageView) rootView.findViewById(R.id.imageView6s);
                            blink.setVisibility(View.VISIBLE);

                            Animation move = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                            blink.startAnimation(move);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

            }
        }, 500);

        return rootView;

    }


    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards_bod:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Bucket of Doom");
                }
            Intent extra=new Intent(getActivity(),Bod_extra_cards.class);
            startActivity(extra);
            getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


            break;
            case R.id.exta_cards_scen_bod:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Bucket of Doom");
                }

                Intent s=new Intent(getActivity(),Bod_scenario.class);
                startActivity(s);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play_bod:

                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Bucket of Doom");
                }
                Intent how2=new Intent(getActivity(),Startup_activity.class);
                startActivity(how2);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game_bod:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Bucket of Doom");
                }
                usefull.showpopup();

                break;
            case R.id.back_bod:
                managerOfSound();
                getActivity().finish();

                break;
        }
    }

//    @Override
//    public void onBackPressed() {
//        // your code.
//        managerOfSound();
//        finish();
//        Intent how23=new Intent(getApplicationContext(),Game_menu.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            managerOfSound();
//            finish();
//            Intent how23=new Intent(getApplicationContext(),Game_menu.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
//
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

