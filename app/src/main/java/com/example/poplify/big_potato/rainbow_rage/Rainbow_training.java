package com.example.poplify.big_potato.rainbow_rage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;

/**
 * Created by POPLIFY on 6/1/2016.
 */
public class Rainbow_training extends Fragment
{
    PopupWindow pwindo;
    ImageView main_pic;
    SaveData save;
    Integer[] pics=new Integer[]{R.mipmap.r1,R.mipmap.r2,R.mipmap.r3,R.mipmap.r4,R.mipmap.r5,
            R.mipmap.r6,R.mipmap.r7,R.mipmap.r8,R.mipmap.r9,R.mipmap.r10};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.rainbow_training, container, false);

        save=new SaveData(getActivity());


        main_pic=(ImageView) rootView.findViewById(R.id.imageView8_main_pic);
        Bundle bundle = this.getArguments();
        switch (bundle.getString("call","0"))
        {
            case "0":

                if(save.getBoolean("show_trng_popup")==true)
                {
                    initiatePopupWindow_trng();
                }
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


    private void initiatePopupWindow_trng() {
        try {
            // We need to get the instance of the LayoutInflater
            save.save("show_trng_popup",false);
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.training_pop,
                    (ViewGroup) getActivity().findViewById(R.id.popup_element_buy_trng));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(true);
            pwindo.setFocusable(true);

            final Button button = (Button) layout.findViewById(R.id.button_no_trng);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    pwindo.dismiss();


                }



            });



        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    }
