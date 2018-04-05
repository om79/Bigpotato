package com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage;

import android.app.Fragment;
import android.content.Intent;
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

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.ConnectionDetector;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.UsefullData;
import com.bigpotato.bigpotatogamesuk.big_potato.view_pager.Startup_activity;
import com.bigpotato.bigpotatogamesuk.big_potato.viewpager_training.Startup_training_activity;
import com.flurry.android.FlurryAgent;

public class RainbowRage extends Fragment implements View.OnClickListener{

    UsefullData usefull;
    SaveData save;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    Typeface regular,bold;
    TextView tag;
    public RainbowRage(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_rainbow_rage, container, false);
        cd = new ConnectionDetector(getActivity());
        isInternetPresent = cd.isConnectingToInternet();
        usefull=new UsefullData(getActivity());
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");
        save=new SaveData(getActivity());
        TextView v=(TextView)  rootView.findViewById(R.id.how_to_play_rainbow);
        v.setTypeface(bold);

        TextView v1=(TextView)  rootView.findViewById(R.id.textView2);
        v1.setTypeface(regular);

        TextView v3=(TextView)  rootView.findViewById(R.id.textView23);
        v3.setTypeface(regular);

        TextView v11=(TextView)  rootView.findViewById(R.id.how_to_play_rainbow);
        v11.setOnClickListener(this);
        TextView v12=(TextView)  rootView.findViewById(R.id.textView2);
        v12.setOnClickListener(this);
        TextView v13=(TextView)  rootView.findViewById(R.id.textView23);
        v13.setOnClickListener(this);
        ImageButton v14=(ImageButton)  rootView.findViewById(R.id.imageView7_back);
        v14.setOnClickListener(this);

        tag=(TextView) rootView.findViewById(R.id.hashtag_r);
        tag.setTypeface(regular);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                try {
                    ImageView blink=(ImageView) rootView.findViewById(R.id.imageViewssb9);
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
            case R.id.how_to_play_rainbow:
                if(isInternetPresent) {
                    FlurryAgent.logEvent("Rainbow Rage");
                }
                Intent how=new Intent(getActivity(),Startup_activity.class);
                startActivity(how);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.textView2:
                if(isInternetPresent) {
                    FlurryAgent.logEvent("Rainbow Rage");
                }
               usefull.showpopup();
                break;
            case R.id.textView23:
                if(isInternetPresent) {
                    FlurryAgent.logEvent("Rainbow Rage");
                }
                save.save("show_trng_popup",true);
                Intent how2=new Intent(getActivity(),Startup_training_activity.class);
                startActivity(how2);
                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.imageView7_back:
                managerOfSound();
                getActivity().finish();
                break;
        }
    }
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
