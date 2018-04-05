package com.bigpotato.bigpotatogamesus.big_potato.chameleon;

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


public class Chameleon_activity extends Fragment implements View.OnClickListener
{

    TextView extra,how,buy,tag;
    ImageButton back;
    UsefullData usefull;
    Typeface regular,bold;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    public Chameleon_activity(){}
    ImageView blink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.chameleon_activity, container, false);


        cd = new ConnectionDetector(getActivity());
        isInternetPresent = cd.isConnectingToInternet();
        extra=(TextView) rootView.findViewById(R.id.exta_cards);
        extra.setOnClickListener(this);
        how=(TextView) rootView.findViewById(R.id.how_to_play);
        how.setOnClickListener(this);
        buy=(TextView) rootView.findViewById(R.id.buy_the_game);
        buy.setOnClickListener(this);
        back = (ImageButton) rootView.findViewById(R.id.back);
        back.setOnClickListener(this);
        usefull=new UsefullData(getActivity());

        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        extra.setTypeface(regular);
        buy.setTypeface(regular);
        how.setTypeface(bold);
        tag=(TextView) rootView.findViewById(R.id.hashtag1);
        tag.setTypeface(regular);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                try {
                    ImageView blink=(ImageView) rootView.findViewById(R.id.imageView6);
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

            case R.id.exta_cards:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Chameleon");
                }
                Intent extra=new Intent(getActivity(),Cham_extra_cards.class);
                startActivity(extra);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Chameleon");
                }
                Intent how2=new Intent(getActivity(),Startup_activity.class);
                startActivity(how2);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game:
                if(isInternetPresent) {

                    FlurryAgent.logEvent("Chameleon");
                }

                usefull.showpopup();
                break;
            case R.id.back:
                managerOfSound();
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
