package com.bigpotato.bigpotatogamesus.big_potato.squirms;

import android.app.Fragment;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesus.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Squirms_how_5 extends Fragment implements View.OnClickListener
{


    Typeface regular,bold;
    Button menu;
    MediaPlayer mp;
    public Squirms_how_5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.squirms_how_5, container, false);

        mp= MediaPlayer.create(getActivity(), R.raw.main_button);
        menu = (Button) rootView.findViewById(R.id.button_mubdd34);
        menu.setOnClickListener(this);
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textchn3__2_mr1s5);
        v.setTypeface(regular);

        TextView v1=(TextView)  rootView.findViewById(R.id.textVssav_2_mr1s5);
        v1.setTypeface(regular);
        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.button_mubdd34:
                mp.start();
                getActivity().finish();
                break;

        }
    }


}

