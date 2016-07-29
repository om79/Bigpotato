package com.bigpotato.bigpotatogamesuk.big_potato.view_pager;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

public class Startup_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }



}
