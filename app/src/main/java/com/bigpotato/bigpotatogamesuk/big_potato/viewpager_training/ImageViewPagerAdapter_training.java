package com.bigpotato.bigpotatogamesuk.big_potato.viewpager_training;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_1;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_2;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_3;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_4;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_5;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_6;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_7;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_8;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.Rainbow_training_9;

/**
 * Created by nirmal on 12/08/15.
 */
public class ImageViewPagerAdapter_training extends FragmentPagerAdapter {
    private Context _context;


    public static int totalPage = 12;

    public ImageViewPagerAdapter_training(Context context, FragmentManager fm) {
        super(fm);
        _context = context;



    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();




            switch (position) {


                case 1:

                    f = new Rainbow_training();

                    break;
                case 2:

                    f = new Rainbow_training_1();

                    break;
                case 3:

                    f = new Rainbow_training_2();

                    break;
                case 4:

                    f = new Rainbow_training_3();

                    break;
                case 5:

                    f = new Rainbow_training_4();

                    break;
                case 6:

                    f = new Rainbow_training_5();

                    break;
                case 7:

                    f = new Rainbow_training_6();

                    break;
                case 8:

                    f = new Rainbow_training_7();

                    break;
                case 9:

                    f = new Rainbow_training_8();

                    break;
                case 10:

                    f = new Rainbow_training_9();

                    break;
//                case 10:
//
//                    f = new Rainbow_training();
//
//                    break;

        }
        return f;
    }

    @Override
    public int getCount() {
        return totalPage;
//        return Integer.MAX_VALUE;
    }

}

