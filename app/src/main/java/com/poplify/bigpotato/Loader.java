package com.poplify.bigpotato;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Loader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
//        setContentView(R.layout.activity_loader);
        final int[] imageArray = { R.mipmap.blue_bar };

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            ImageView view  = (ImageView) findViewById(R.id.loader_progress);
            public void run() {
                view.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {

                    Intent intent = new Intent(Loader.this, all_games.class);
                    startActivity(intent);
                    finish();
                }
//                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }
}
