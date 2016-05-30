package com.example.poplify.big_potato.qwordie;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_2 extends Fragment implements View.OnClickListener
{

    ImageView back;
    Typeface regular,bold;

    public How_to_play_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.how_to_play_2, container, false);


        back = (ImageView) rootView.findViewById(R.id.back_play_2);
        back.setOnClickListener(this);

        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textView3__2);
        v.setTypeface(regular);

        TextView v1=(TextView)  rootView.findViewById(R.id.textView5__2);
        v1.setTypeface(regular);
        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.back_play_2:
                Intent how23=new Intent(getActivity(),Qwordie_activity.class);
                startActivity(how23);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;

        }
    }


}
