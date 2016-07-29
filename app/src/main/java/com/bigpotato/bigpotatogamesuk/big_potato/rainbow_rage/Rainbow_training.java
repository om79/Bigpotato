package com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;

/**
 * Created by POPLIFY on 6/1/2016.
 */
public class Rainbow_training extends Fragment
{
    PopupWindow pwindo;
    ImageView main_pic;
    SaveData save;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.rainbow_training, container, false);

        save=new SaveData(getActivity());

        main_pic=(ImageView) rootView.findViewById(R.id.imageView8_main_pic);

                if(save.getBoolean("show_trng_popup")==true)
                {
                    initiatePopupWindow_trng();
                }

                main_pic.setImageResource(R.mipmap.r1);


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
