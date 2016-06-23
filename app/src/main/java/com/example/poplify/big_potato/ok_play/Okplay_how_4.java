package com.example.poplify.big_potato.ok_play;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.mr_lister.Mr_homepage;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;

/**
 * Created by POPLIFY on 6/4/2016.
 */
public class Okplay_how_4 extends Fragment implements View.OnClickListener
{


    Typeface regular,bold;
    Button menu;
    public Okplay_how_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.okplay_how_4, container, false);


       regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v1=(TextView)  rootView.findViewById(R.id.textView5__2_ok4);
        v1.setTypeface(regular);

        menu = (Button) rootView.findViewById(R.id.button_menubdd34_okplay);
        menu.setOnClickListener(this);

        menu.setTypeface(bold);
        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

                       case R.id.button_menubdd34_okplay:
                Intent howm=new Intent(getActivity(),Ok_play_homescreen.class);
                startActivity(howm);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;

        }
    }


}

