package com.example.poplify.big_potato.mr_lister;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_how_3 extends Fragment
{


    Typeface regular,bold;

    public Mr_how_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.mr_how_3, container, false);



        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textView3__2mm3);
        v.setTypeface(regular);

        TextView v1=(TextView)  rootView.findViewById(R.id.textView5__2_mr3);
        v1.setTypeface(regular);


        return rootView;
    }




}



