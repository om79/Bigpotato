package com.bigpotato.bigpotatogamesus.big_potato.chameleon;

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
 * Created by POPLIFY on 6/23/2016.
 */
public class Cham_how_6 extends Fragment implements View.OnClickListener
{


    Button menu;
    Typeface regular,bold;
    MediaPlayer mp;
    public Cham_how_6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.cham_how_6, container, false);




        menu = (Button) rootView.findViewById(R.id.button_menubdd3oka4);
        menu.setOnClickListener(this);
        mp= MediaPlayer.create(getActivity(), R.raw.main_button);
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textVittmm34);
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
                mp.start();
                getActivity().finish();
//                Intent howm=new Intent(getActivity(),Obla_homapage.class);
//                startActivity(howm);
//                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }
    }


}

