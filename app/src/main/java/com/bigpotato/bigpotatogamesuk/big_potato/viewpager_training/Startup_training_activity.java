package com.bigpotato.bigpotatogamesuk.big_potato.viewpager_training;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

public class Startup_training_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_traning);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }



}
