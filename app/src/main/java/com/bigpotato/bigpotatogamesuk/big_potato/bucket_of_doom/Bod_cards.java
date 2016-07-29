package com.bigpotato.bigpotatogamesuk.big_potato.bucket_of_doom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/2/2016.
 */
public class Bod_cards extends Activity {

    ImageView cross;
    TextView txt;
    Typeface regular,bold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bod_card);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        cross=(ImageView) findViewById(R.id.imageView7_bod_new);
        txt=(TextView) findViewById(R.id.textView4_bod_new);
        txt.setTypeface(regular);

        try {
            Intent intent = getIntent();
            txt.setText(intent.getStringExtra("data"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Bod_extra_cards.class);
//                startActivity(how23);
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

            }
        });


    }

        @Override
    public void onBackPressed() {
        // your code.
            managerOfSound();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Bod_extra_cards.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Bod_extra_cards.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    private void managerOfSound() {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.back_button);
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
