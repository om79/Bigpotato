package com.bigpotato.bigpotatogamesuk.big_potato.mr_lister;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_how_2 extends Fragment
{


    Typeface regular,bold;

    public Mr_how_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.mr_how_2, container, false);



        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textView3__2mm2);
        v.setTypeface(regular);


        return rootView;
    }



}


