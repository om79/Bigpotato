package com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/1/2016.
 */
public class Rainbow_training_3 extends Fragment
{

    ImageView main_pic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.rainbow_training, container, false);



        main_pic=(ImageView) rootView.findViewById(R.id.imageView8_main_pic);

                main_pic.setImageResource(R.mipmap.r4);



        return  rootView;

    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("---","---onDestroy--");
        main_pic.setImageDrawable(null);
    }

    @Override
    public void onStop() {
        super.onDestroy();
        Log.i("---","---onStop--");
        main_pic.setImageDrawable(null);
    }





}
