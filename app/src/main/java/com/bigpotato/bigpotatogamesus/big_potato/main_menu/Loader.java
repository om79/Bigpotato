package com.bigpotato.bigpotatogamesus.big_potato.main_menu;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.bigpotato.bigpotatogamesus.big_potato.R;

public class Loader extends AppCompatActivity  {


    ProgressBar s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        new load().execute();

     }


    class load extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute()
        {

            s=(ProgressBar) findViewById(R.id.pb_loading);

            ObjectAnimator animation = ObjectAnimator.ofInt(s, "progress", 0, 100);
            animation.setDuration(1400);
            animation.setInterpolator(new DecelerateInterpolator());
            animation.start();


        }
        protected Void doInBackground(Void... arg0) {



            Thread background = new Thread() {
                public void run() {

               try {
                        sleep(1500);

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
