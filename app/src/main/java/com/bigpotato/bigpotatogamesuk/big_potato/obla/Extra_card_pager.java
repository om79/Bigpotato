package com.bigpotato.bigpotatogamesuk.big_potato.obla;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/24/2016.
 */
public class Extra_card_pager extends Activity {

    ViewPager view = null;
    ImageView back,pre,further;

    int act[] = {R.mipmap.act1, R.mipmap.act2,R.mipmap.act3,R.mipmap.act4,R.mipmap.act5};
    int solve[] = {R.mipmap.solve1, R.mipmap.solve2,R.mipmap.solve3,R.mipmap.solve4,R.mipmap.solve5};
    int desc[] = {R.mipmap.desc1, R.mipmap.desc2,R.mipmap.desc3,R.mipmap.desc4,R.mipmap.desc5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_card_pager);
        Intent intent = getIntent();
        switch (intent.getStringExtra("obla")){
                case "desc":
                    for(int i=0;i<5;i++){
                        act[i]=desc[i];
                    }
                    break;
                case "solve":
                    for(int i=0;i<5;i++){
                        act[i]=solve[i];
                    }
                    break;
            }


        view = (ViewPager) findViewById(R.id.viewPager);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        view.setAdapter(new MyAdapter());
        back=(ImageView) findViewById(R.id.imageView17);
        pre=(ImageView) findViewById(R.id.imageView16_pri);
        further=(ImageView) findViewById(R.id.imageView15nxt);


        further.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                       view.setCurrentItem(view.getCurrentItem() + 1);
                switch (view.getCurrentItem())
                {
                    case 0:
                        pre.setVisibility(View.INVISIBLE);
                        further.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        further.setVisibility(View.INVISIBLE);
                        pre.setVisibility(View.VISIBLE);
                        break;
                    default:
                        pre.setVisibility(View.VISIBLE);
                        further.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     view.setCurrentItem(view.getCurrentItem() - 1);
                switch (view.getCurrentItem())
                {
                    case 0:
                        pre.setVisibility(View.INVISIBLE);
                        further.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        further.setVisibility(View.INVISIBLE);
                        pre.setVisibility(View.VISIBLE);
                        break;
                    default:
                        pre.setVisibility(View.VISIBLE);
                        further.setVisibility(View.VISIBLE);
                        break;
                }


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                managerOfSound();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Obla_extra_cards.class);
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
//        Intent how23=new Intent(getApplicationContext(),Obla_extra_cards.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Obla_extra_cards.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {

           return act.length;

        }

        @Override
        public Object instantiateItem(final View container,final int position) {
            final ImageView iv = new ImageView(Extra_card_pager.this);
            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

                    iv.setImageResource(act[position]);
            ((ViewPager) container).addView(iv, 0);


            switch (((ViewPager) container).getCurrentItem())
            {
                case 0:
                    pre.setVisibility(View.INVISIBLE);
                    further.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    further.setVisibility(View.INVISIBLE);
                    pre.setVisibility(View.VISIBLE);
                    break;
                default:
                    pre.setVisibility(View.VISIBLE);
                    further.setVisibility(View.VISIBLE);
                    break;
            }



            return iv;
        }

        @Override
        public void destroyItem(View container, int position, Object obj) {
            ((ViewPager) container).removeView((View) obj);
            switch (view.getCurrentItem())
            {
                case 0:
                    pre.setVisibility(View.INVISIBLE);
                    further.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    further.setVisibility(View.INVISIBLE);
                    pre.setVisibility(View.VISIBLE);
                    break;
                default:
                    pre.setVisibility(View.VISIBLE);
                    further.setVisibility(View.VISIBLE);
                    break;
            }

        }

        @Override
        public boolean isViewFromObject(View container, Object obj) {
            return container == obj;
            // return container == (View) obj;

        }

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
