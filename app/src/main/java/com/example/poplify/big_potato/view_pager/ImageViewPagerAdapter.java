package com.example.poplify.big_potato.view_pager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.widget.Switch;

import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.bucket_of_doom.How_to_play_bod_1;
import com.example.poplify.big_potato.bucket_of_doom.How_to_play_bod_2;
import com.example.poplify.big_potato.bucket_of_doom.How_to_play_bod_3;
import com.example.poplify.big_potato.bucket_of_doom.How_to_play_bod_4;
import com.example.poplify.big_potato.mr_lister.Mr_how_1;
import com.example.poplify.big_potato.mr_lister.Mr_how_2;
import com.example.poplify.big_potato.mr_lister.Mr_how_3;
import com.example.poplify.big_potato.mr_lister.Mr_how_4;
import com.example.poplify.big_potato.ok_play.Okplay_how_1;
import com.example.poplify.big_potato.ok_play.Okplay_how_2;
import com.example.poplify.big_potato.ok_play.Okplay_how_3;
import com.example.poplify.big_potato.ok_play.Okplay_how_4;
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

        switch (save.getString("current_game"))
        {

            case "RAINBOW":
                totalPage = 5;
                break;
            default:
                totalPage = 4;
                break;

        }



    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();

        switch (save.getString("current_game")) {

            case "QWORDIE":
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
                }
                break;

            case "RAINBOW":

                Bundle bundle = new Bundle();
                switch (position) {

                    case 0:

                        f = new How_to_play_rainbow_1();
                        bundle.putString("call", "0");
                        f.setArguments(bundle);
                        break;
                    case 1:

                        f = new How_to_play_rainbow_1();
                        bundle.putString("call", "1");
                        f.setArguments(bundle);
                        break;
                    case 2:

                        f = new How_to_play_rainbow_1();
                        bundle.putString("call", "2");
                        f.setArguments(bundle);
                        break;
                    case 3:

                        f = new How_to_play_rainbow_1();
                        bundle.putString("call", "3");
                        f.setArguments(bundle);
                        break;
                    case 4:

                        f = new How_to_play_rainbow_1();
                        bundle.putString("call", "4");
                        f.setArguments(bundle);
                        break;
                }
                break;
            case "BUCKET OF DOOM":
                switch (position) {
                    case 0:
                        f = new How_to_play_bod_1();
                        break;
                    case 1:
                        f = new How_to_play_bod_2();
                        break;
                    case 2:
                        f = new How_to_play_bod_3();
                        break;
                    case 3:
                        f = new How_to_play_bod_4();
                        break;
                }
                break;
            case "OKPLAY":
                switch (position) {
                    case 0:
                        f = new Okplay_how_1();
                        break;
                    case 1:
                        f = new Okplay_how_2();
                        break;
                    case 2:
                        f = new Okplay_how_3();
                        break;
                    case 3:
                        f = new Okplay_how_4();
                        break;
                }
                break;
            case "MR LISTERS":
                switch (position) {
                    case 0:
                        f = new Mr_how_1();
                        break;
                    case 1:
                        f = new Mr_how_2();
                        break;
                    case 2:
                        f = new Mr_how_3();
                        break;
                    case 3:
                        f = new Mr_how_4();
                        break;
                }
                break;


        }
        return f;
    }

    @Override
    public int getCount() {
        return totalPage;
    }

}

