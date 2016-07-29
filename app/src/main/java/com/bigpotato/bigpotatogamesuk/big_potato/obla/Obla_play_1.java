package com.bigpotato.bigpotatogamesuk.big_potato.obla;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/23/2016.
 */
public class Obla_play_1 extends Fragment {

    Typeface regular, bold;


    public Obla_play_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.obla_play_1, container, false);
        // Inflate the layout for this fragment

        regular = Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");


        TextView v = (TextView) rootView.findViewById(R.id.te3__2);
        v.setTypeface(regular);

        TextView v1 = (TextView) rootView.findViewById(R.id.tobaextView5__2_fafasf);
        v1.setTypeface(regular);


        return rootView;
    }
}