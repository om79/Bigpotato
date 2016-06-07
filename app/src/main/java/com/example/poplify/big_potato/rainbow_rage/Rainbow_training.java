package com.example.poplify.big_potato.rainbow_rage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 6/1/2016.
 */
public class Rainbow_training extends Fragment
{

    ImageView main_pic;
    Integer[] pics=new Integer[]{R.mipmap.r1,R.mipmap.r2,R.mipmap.r3,R.mipmap.r4,R.mipmap.r5,
            R.mipmap.r6,R.mipmap.r7,R.mipmap.r8,R.mipmap.r9,R.mipmap.r10};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.rainbow_training, container, false);

        main_pic=(ImageView) rootView.findViewById(R.id.imageView8_main_pic);
        Bundle bundle = this.getArguments();
        switch (bundle.getString("call","0"))
        {
            case "0":

                main_pic.setImageResource(pics[0]);
                break;
            case "1":

                main_pic.setImageResource(pics[1]);
                break;
            case "2":

                main_pic.setImageResource(pics[2]);
                break;
            case "3":

                main_pic.setImageResource(pics[3]);
                break;
            case "4":

                main_pic.setImageResource(pics[4]);
                break;
            case "5":

                main_pic.setImageResource(pics[5]);
                break;
            case "6":

                main_pic.setImageResource(pics[6]);
                break;
            case "7":

                main_pic.setImageResource(pics[7]);
                break;
            case "8":

                main_pic.setImageResource(pics[8]);
                break;
            case "9":

                main_pic.setImageResource(pics[9]);
                break;


        }


        return  rootView;

    }

    }
