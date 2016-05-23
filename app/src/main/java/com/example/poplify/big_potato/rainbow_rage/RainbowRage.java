package com.example.poplify.big_potato.rainbow_rage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.Extra_cards;
import com.example.poplify.big_potato.qwordie.How_to_play_1;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;

public class RainbowRage extends AppCompatActivity {


    UsefullData usefull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_rage);
        usefull=new UsefullData(RainbowRage.this);
    }



    public void howtoplay(View view)
    {


        switch (view.getId())
        {


            case R.id.how_to_play_rainbow:
                Intent intent = new Intent(RainbowRage.this, How_to_play_rainbow_1.class);
                intent.putExtra("call","0");
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.textView2:

               usefull.showpopup();
                break;
            case R.id.imageView7_back:
                finish();
                break;
        }
    }
}
