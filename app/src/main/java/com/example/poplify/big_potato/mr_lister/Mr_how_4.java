package com.example.poplify.big_potato.mr_lister;

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
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_how_4 extends Fragment implements View.OnClickListener
{

    ImageView back;
    Typeface regular,bold;
    Button menu;

    public Mr_how_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.mr_how_4, container, false);


        back = (ImageView) rootView.findViewById(R.id.back_play_2_mr34);
        back.setOnClickListener(this);

        menu = (Button) rootView.findViewById(R.id.button_menubdd34);
        menu.setOnClickListener(this);

        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textView3__2mm34);
        v.setTypeface(regular);

        TextView v1=(TextView)  rootView.findViewById(R.id.textView5__2_mr34);
        v1.setTypeface(regular);


        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.back_play_2_mr34:
                Intent how23=new Intent(getActivity(),Mr_homepage.class);
                startActivity(how23);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.button_menubdd34:
                Intent howm=new Intent(getActivity(),Mr_homepage.class);
                startActivity(howm);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;

        }
    }


}




