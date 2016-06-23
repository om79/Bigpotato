package com.example.poplify.big_potato.obla;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.scrawl.Scraml_homepage;

/**
 * Created by POPLIFY on 6/23/2016.
 */
public class Obla_play_5 extends Fragment implements View.OnClickListener
{


    Button menu;
    Typeface regular,bold;

    public Obla_play_5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.obla_play_5, container, false);




        menu = (Button) rootView.findViewById(R.id.button_menubdd3oka4);
        menu.setOnClickListener(this);

        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textVidfsdfews3__2mm34);
        v.setTypeface(regular);


        menu.setTypeface(bold);
        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            case R.id.button_menubdd3oka4:
                Intent howm=new Intent(getActivity(),Obla_homapage.class);
                startActivity(howm);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }
    }


}

