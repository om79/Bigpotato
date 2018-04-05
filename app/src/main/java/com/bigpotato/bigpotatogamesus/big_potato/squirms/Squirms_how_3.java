package com.bigpotato.bigpotatogamesus.big_potato.squirms;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesus.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Squirms_how_3 extends Fragment
{


    Typeface regular,bold;

    public Squirms_how_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.squirms_how_3, container, false);



        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textchn3__2_mr1s);
        v.setTypeface(regular);


        return rootView;
    }




}

