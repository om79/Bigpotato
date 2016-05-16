package com.poplify.bigpotato;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class How_to_play_rainbow_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play_rainbow_1);

    }

    public void how_to_play_screens(View view)
    {
        switch (view.getId()) {
            case R.id.main_menu: // doStuff
                Intent menuIntent = new Intent(this, RainbowRage.class);
                startActivity(menuIntent);
                break;
            case R.id.zero_play: // doStuff

                setContentView(R.layout.content_how_to_play_rainbow_1);
                break;
            case R.id.first_play: // doStuff

                setContentView(R.layout.how_to_play_rainbow_2);
                break;
            case R.id.two_play: // doStuff

                setContentView(R.layout.how_to_play_rainbow_3);
                break;
            case R.id.third_play: // doStuff

                setContentView(R.layout.how_to_play_rainbow_4);
                break;
            case R.id.fourth_play: // doStuff

                setContentView(R.layout.how_to_play_rainbow_5);
                break;
        }

    }

}
