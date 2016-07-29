package com.bigpotato.bigpotatogamesuk.big_potato.mr_lister;

import android.app.Fragment;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_how_4 extends Fragment implements View.OnClickListener
{


    Typeface regular,bold;
    Button menu;
    MediaPlayer mp;
    public Mr_how_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.mr_how_4, container, false);



        menu = (Button) rootView.findViewById(R.id.button_menubdd34);
        menu.setOnClickListener(this);
        mp= MediaPlayer.create(getActivity(), R.raw.main_button);
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");

        TextView v=(TextView)  rootView.findViewById(R.id.textView3__2mm34);
        v.setTypeface(regular);

        TextView v1=(TextView)  rootView.findViewById(R.id.textView5__2_mr34);
        v1.setTypeface(regular);

        menu.setTypeface(bold);


        return rootView;
    }

    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

             case R.id.button_menubdd34:
                 mp.start();
                 getActivity().finish();
//                Intent howm=new Intent(getActivity(),Mr_homepage.class);
//                startActivity(howm);
//                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;

        }
    }


}




