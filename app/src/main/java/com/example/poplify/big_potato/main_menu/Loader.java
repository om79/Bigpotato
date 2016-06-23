package com.example.poplify.big_potato.main_menu;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.main_menu.Game_menu;

public class Loader extends Activity {


    ProgressBar s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

//            s=(ProgressBar) findViewById(R.id.pb_loading);
//
//            ObjectAnimator animation = ObjectAnimator.ofInt(s, "progress", 0, 100);
//            animation.setDuration(1500);
//            animation.setInterpolator(new DecelerateInterpolator());
//            animation.start();


//        Intent i = new Intent(getApplicationContext(), Game_menu.class);
//        startActivity(i);

        new load().execute();
     }


    class load extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute()
        {

            s=(ProgressBar) findViewById(R.id.pb_loading);

            ObjectAnimator animation = ObjectAnimator.ofInt(s, "progress", 0, 100);
            animation.setDuration(1500);
            animation.setInterpolator(new DecelerateInterpolator());
            animation.start();


        }
        protected Void doInBackground(Void... arg0) {



            Thread background = new Thread() {
                public void run() {

                    try {
                        sleep(1700);

                        Intent i = new Intent(getApplicationContext(), Game_menu.class);
                        startActivity(i);
                        finish();

                    } catch (Exception e) {

                    }
                }


            };


            background.start();



            return null;
        }


        protected void onPostExecute(Void result)
        {

        }

    }





}
