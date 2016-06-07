package com.example.poplify.big_potato.rainbow_rage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.infinite_scroll.MyCloneableView;
import com.example.poplify.big_potato.infinite_scroll.PSInfiniteScrollView;
import com.example.poplify.big_potato.infinite_scroll.PSSize;
import com.example.poplify.big_potato.qwordie.Extra_cards;
import com.example.poplify.big_potato.qwordie.How_to_play_1;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.view_pager.Startup_activity;
import com.example.poplify.big_potato.viewpager_training.Startup_training_activity;

public class RainbowRage extends Activity {


    UsefullData usefull;
    Typeface regular,bold;
    int[] c = new int[] { R.mipmap.bod,R.mipmap.qwordie, R.mipmap.scrawl,R.mipmap.rainbow_rage,
            R.mipmap.mr_lister,R.mipmap.obamallama,R.mipmap.social,R.mipmap.ok_play};

    String[] cs = new String[] { "bod", "qworide", "scrwal", "rainbow", "mr_lister",
            "obama", "social","ok_play" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_rage);
        usefull=new UsefullData(RainbowRage.this);
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  findViewById(R.id.how_to_play_rainbow);
        v.setTypeface(bold);

        TextView v1=(TextView)  findViewById(R.id.textView2);
        v1.setTypeface(bold);

        TextView v3=(TextView)  findViewById(R.id.textView23);
        v3.setTypeface(bold);

        LinearLayout container = (LinearLayout) findViewById(R.id.rain_linear);
        PSInfiniteScrollView scrollView = new PSInfiniteScrollView(this,new PSSize(150,120));
        for (int i = 0; i < 8; i++) {
            MyCloneableView img = new MyCloneableView(RainbowRage.this);
            img.setId(i + 10);
            img.setImageResource(c[i]);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
//            img.setBackgroundColor(c[i]);
            img.setTag(cs[i]);
            scrollView.addItem(img);
        }

        container.addView(scrollView);
    }



    public void howtoplay(View view)
    {


        switch (view.getId())
        {


            case R.id.how_to_play_rainbow:
                Intent how=new Intent(getApplicationContext(),Startup_activity.class);
                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.textView2:

               usefull.showpopup();
                break;
            case R.id.textView23:

                Intent how2=new Intent(getApplicationContext(),Startup_training_activity.class);
                startActivity(how2);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.imageView7_back:
                finish();
                break;
        }
    }
}
