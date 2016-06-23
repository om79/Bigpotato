package com.example.poplify.big_potato.rainbow_rage;

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
import com.example.poplify.big_potato.adapters.UsefullData;

public class How_to_play_rainbow_1 extends Fragment implements View.OnClickListener{

    UsefullData usefull;
    Typeface regular,bold;
    Button menu;

    View rootView;
    public How_to_play_rainbow_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        usefull=new UsefullData(getActivity());
        usefull.trimCache(getActivity());
        Bundle bundle = this.getArguments();
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");
        switch (bundle.getString("call","0"))
        {

            case "0":
                rootView = inflater.inflate(R.layout.content_how_to_play_rainbow_1, container, false);

                TextView v=(TextView)  rootView.findViewById(R.id.textView);
                v.setTypeface(regular);

                TextView v1=(TextView)  rootView.findViewById(R.id.textView3);
                v1.setTypeface(regular);


                break;
            case "1":
                rootView = inflater.inflate(R.layout.how_to_play_rainbow_2, container, false);
                 TextView v3=(TextView)  rootView.findViewById(R.id.textView);
                v3.setTypeface(regular);

                TextView v4=(TextView)  rootView.findViewById(R.id.textView3);
                v4.setTypeface(regular);

                break;
            case "2":
                rootView = inflater.inflate(R.layout.how_to_play_rainbow_3, container, false);
                 TextView v45=(TextView)  rootView.findViewById(R.id.textView);
                v45.setTypeface(regular);

                TextView v54=(TextView)  rootView.findViewById(R.id.textView3);
                v54.setTypeface(regular);

                break;
            case "3":
                rootView = inflater.inflate(R.layout.how_to_play_rainbow_4, container, false);
                 TextView v425=(TextView)  rootView.findViewById(R.id.textView64);
                v425.setTypeface(regular);

                TextView v524=(TextView)  rootView.findViewById(R.id.textView354);
                v524.setTypeface(regular);

                break;
            case "4":
                rootView = inflater.inflate(R.layout.how_to_play_rainbow_5, container, false);
                menu = (Button) rootView.findViewById(R.id.main_menu);
                menu.setOnClickListener(this);
                TextView v415=(TextView)  rootView.findViewById(R.id.textView54);
                v415.setTypeface(regular);

                break;


        }



        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.main_menu:
                Intent menuIntent = new Intent(getActivity(), RainbowRage.class);
                startActivity(menuIntent);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;

        }
    }






}
