package com.example.poplify.big_potato.viewpager_training;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.qwordie.How_to_play_1;
import com.example.poplify.big_potato.qwordie.How_to_play_2;
import com.example.poplify.big_potato.qwordie.How_to_play_3;
import com.example.poplify.big_potato.qwordie.How_to_play_4;
import com.example.poplify.big_potato.rainbow_rage.How_to_play_rainbow_1;
import com.example.poplify.big_potato.rainbow_rage.Rainbow_training;

/**
 * Created by nirmal on 12/08/15.
 */
public class ImageViewPagerAdapter_training extends FragmentPagerAdapter {
    private Context _context;
    SaveData save;

    public static int totalPage = 10;

    public ImageViewPagerAdapter_training(Context context, FragmentManager fm) {
        super(fm);
        _context = context;
        save=new SaveData(_context);


    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();



            Bundle bundle = new Bundle();
            switch (position) {

                case 0:

                    f = new Rainbow_training();
                    bundle.putString("call","0");
                    f.setArguments(bundle);
                    break;
                case 1:

                    f = new Rainbow_training();
                    bundle.putString("call","1");
                    f.setArguments(bundle);
                    break;
                case 2:

                    f = new Rainbow_training();
                    bundle.putString("call","2");
                    f.setArguments(bundle);
                    break;
                case 3:

                    f = new Rainbow_training();
                    bundle.putString("call","3");
                    f.setArguments(bundle);
                    break;
                case 4:

                    f = new Rainbow_training();
                    bundle.putString("call","4");
                    f.setArguments(bundle);
                    break;
                case 5:

                    f = new Rainbow_training();
                    bundle.putString("call","5");
                    f.setArguments(bundle);
                    break;
                case 6:

                    f = new Rainbow_training();
                    bundle.putString("call","6");
                    f.setArguments(bundle);
                    break;
                case 7:

                    f = new Rainbow_training();
                    bundle.putString("call","7");
                    f.setArguments(bundle);
                    break;
                case 8:

                    f = new Rainbow_training();
                    bundle.putString("call","8");
                    f.setArguments(bundle);
                    break;
                case 9:

                    f = new Rainbow_training();
                    bundle.putString("call","9");
                    f.setArguments(bundle);
                    break;

        }
        return f;
    }

    @Override
    public int getCount() {
        return totalPage;
    }

}

