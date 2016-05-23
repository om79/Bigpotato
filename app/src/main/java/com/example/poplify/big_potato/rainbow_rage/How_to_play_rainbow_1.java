package com.example.poplify.big_potato.rainbow_rage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.How_to_play_2;

public class How_to_play_rainbow_1 extends AppCompatActivity {

    UsefullData usefull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usefull=new UsefullData(getApplicationContext());
        usefull.trimCache(getApplicationContext());
        switch (getIntent().getExtras().getString("call","0"))
        {

            case "0":

                setContentView(R.layout.content_how_to_play_rainbow_1);
                break;
            case "1":
                setContentView(R.layout.how_to_play_rainbow_2);
                break;
            case "2":
                setContentView(R.layout.how_to_play_rainbow_3);
                break;
            case "3":
                setContentView(R.layout.how_to_play_rainbow_4);
                break;
            case "4":
                setContentView(R.layout.how_to_play_rainbow_5);
                break;


        }


    }

    public void how_to_play_screens(View view)
    {
        usefull.trimCache(getApplicationContext());
        switch (view.getId()) {
            case R.id.main_menu: // doStuff
                Intent menuIntent = new Intent(this, RainbowRage.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.first_play: // doStuff

                Intent how1=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how1.putExtra("call","1");
                startActivity(how1);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.two_play: // doStuff

                Intent how2=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how2.putExtra("call","2");
                startActivity(how2);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.third_play: // doStuff

                Intent how3=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how3.putExtra("call","3");
                startActivity(how3);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.fourth_play: // doStuff

                Intent how4=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how4.putExtra("call","4");
                startActivity(how4);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.zero_play_2: // doStuff

                Intent how_2=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_2.putExtra("call","0");
                startActivity(how_2);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.first_play_3: // doStuff

                Intent how_3=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_3.putExtra("call","1");
                startActivity(how_3);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.two_play_4: // doStuff

                Intent how_4=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_4.putExtra("call","2");
                startActivity(how_4);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.third_play_5: // doStuff

                Intent how_5=new Intent(getApplicationContext(),How_to_play_rainbow_1.class);
                how_5.putExtra("call","3");
                startActivity(how_5);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }

    }

}
