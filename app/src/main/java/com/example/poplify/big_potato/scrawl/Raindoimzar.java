package com.example.poplify.big_potato.scrawl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;

import java.util.Random;

/**
 * Created by POPLIFY on 6/22/2016.
 */
public class Raindoimzar extends Activity
{


    int[] picx={R.mipmap.sr1,R.mipmap.sr2,R.mipmap.sr3,R.mipmap.sr4,R.mipmap.sr5,R.mipmap.sr6};
    ImageView main_pic,cross;
    Button new_rule;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomizar);

        main_pic=(ImageView) findViewById(R.id.imageView14_random);
        cross=(ImageView) findViewById(R.id.imageVie_new);
        new_rule=(Button) findViewById(R.id.button3_new);

        main_pic.setImageResource(picx[new Random().nextInt(picx.length)]);
        new_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_pic.setImageResource(picx[new Random().nextInt(picx.length)]);
            }
        });
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent how23=new Intent(getApplicationContext(),Scraml_homepage.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });
    }

}
