package com.bigpotato.bigpotatogamesus.big_potato.main_menu;

import android.app.Application;

import com.flurry.android.FlurryAgent;

/**
 * Created by POPLIFY on 7/22/2016.
 */
public class App extends Application {
    String key="PMQZP7M6VPRVMN9Q6DW8";
    @Override
    public void onCreate() {
        super.onCreate();

        FlurryAgent.setLogEnabled(true);
        FlurryAgent.init(this, key);
    }


}