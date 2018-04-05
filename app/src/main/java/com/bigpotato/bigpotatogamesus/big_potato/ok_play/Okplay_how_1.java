package com.bigpotato.bigpotatogamesus.big_potato.ok_play;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesus.big_potato.R;

/**
 * Created by POPLIFY on 6/4/2016.
 */
public class Okplay_how_1 extends Fragment
{


    Typeface regular,bold;

    public Okplay_how_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.okplay_how_1, container, false);



        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");



        TextView v1=(TextView)  rootView.findViewById(R.id.textView5__2_ok);
        v1.setTypeface(regular);
        return rootView;
    }




}
