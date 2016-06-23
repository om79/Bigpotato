package com.example.poplify.big_potato.bucket_of_doom;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;

/**
 * Created by POPLIFY on 5/17/2016.
 */
public class How_to_play_bod_4 extends Fragment implements View.OnClickListener
{


    Button menu;
    Typeface regular,bold;

    public How_to_play_bod_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.how_to_play_bod_4, container, false);





        menu = (Button) rootView.findViewById(R.id.button_menubdd);
        menu.setOnClickListener(this);

        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.text_View3bddd);
        v.setTypeface(regular);

        menu.setTypeface(bold);
        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

                       case R.id.button_menubdd:
                Intent howm=new Intent(getActivity(),Bod_homepage.class);
                startActivity(howm);
               getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }
    }


}
