package com.example.poplify.big_potato.scrawl;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 6/22/2016.
 */
public class Scrawl_play_2 extends Fragment {

    Typeface regular, bold;


    public Scrawl_play_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.scrawl_play_2, container, false);
        // Inflate the layout for this fragment

        regular = Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");


        TextView v = (TextView) rootView.findViewById(R.id.tfgdfgdextView3__2);
        v.setTypeface(regular);

        TextView v1=(TextView)  rootView.findViewById(R.id.teweretrwegdxtView5__2);
        v1.setTypeface(regular);


        return rootView;
    }






}

