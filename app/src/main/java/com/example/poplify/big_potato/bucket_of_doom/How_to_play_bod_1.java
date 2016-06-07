package com.example.poplify.big_potato.bucket_of_doom;

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
import com.example.poplify.big_potato.qwordie.Qwordie_activity;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_bod_1 extends Fragment implements View.OnClickListener {
    ImageView back;
    Typeface regular, bold;


    public How_to_play_bod_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.how_to_play_bod_1, container, false);
        // Inflate the layout for this fragment

        back = (ImageView) rootView.findViewById(R.id.back_play_2_bod2);
        back.setOnClickListener(this);
        regular = Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");


        TextView v = (TextView) rootView.findViewById(R.id.textView3__2_bod);
        v.setTypeface(regular);
        TextView v1 = (TextView) rootView.findViewById(R.id.textView5__2_bod);
        v1.setTypeface(regular);

        return rootView;
    }




    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events
             case R.id.back_play_2_bod2:
                Intent how23=new Intent(getActivity(),Bod_homepage.class);
                startActivity(how23);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }
    }







}
