package com.example.poplify.big_potato.view_pager;

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

/**
 * Created by nirmal on 12/08/15.
 */
public class ImageViewPagerAdapter extends FragmentPagerAdapter {
    private Context _context;
    SaveData save;

    public static int totalPage = 4;

    public ImageViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        _context = context;
        save=new SaveData(_context);
        if(save.getString("current_game").equals("QWORDIE")){
            totalPage = 4;
        }else {
            totalPage = 5;
        }

    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();

        if(save.getString("current_game").equals("QWORDIE")){
        switch (position) {
            case 0:
                f = new How_to_play_1();
                break;
            case 1:
                f = new How_to_play_2();
                break;
            case 2:
                f = new How_to_play_3();
                break;
            case 3:
                f = new How_to_play_4();
                break;
        }}else{
            Bundle bundle = new Bundle();
            switch (position) {

                case 0:

                    f = new How_to_play_rainbow_1();
                    bundle.putString("call","0");
                    f.setArguments(bundle);
                    break;
                case 1:

                    f = new How_to_play_rainbow_1();
                    bundle.putString("call","1");
                    f.setArguments(bundle);
                    break;
                case 2:

                    f = new How_to_play_rainbow_1();
                    bundle.putString("call","2");
                    f.setArguments(bundle);
                    break;
                case 3:

                    f = new How_to_play_rainbow_1();
                    bundle.putString("call","3");
                    f.setArguments(bundle);
                    break;
                case 4:

                    f = new How_to_play_rainbow_1();
                    bundle.putString("call","4");
                    f.setArguments(bundle);
                    break;
            }
        }
        return f;
    }

    @Override
    public int getCount() {
        return totalPage;
    }

}

