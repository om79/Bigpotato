package com.example.poplify.big_potato;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


public class Qwordie_activity extends Activity implements View.OnClickListener
{

    TextView extra,how,buy;
    ImageView back;
    PopupWindow pwindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qwordie_activity);


        extra=(TextView) findViewById(R.id.exta_cards);
        extra.setOnClickListener(this);
        how=(TextView) findViewById(R.id.how_to_play);
        how.setOnClickListener(this);
        buy=(TextView) findViewById(R.id.buy_the_game);
        buy.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);




    }


    @Override
    public void onClick(View view)
    {


        switch (view.getId())
        {
            //handle multiple view click events

            case R.id.exta_cards:

                Intent extra=new Intent(getApplicationContext(),Extra_cards.class);

                startActivity(extra);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


                break;

            case R.id.how_to_play:
                Intent how=new Intent(getApplicationContext(),How_to_play_1.class);

                startActivity(how);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            case R.id.buy_the_game:


                initiatePopupWindow();
                break;
            case R.id.back:
                finish();
                break;
        }
    }


    private void initiatePopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_view_buy,
                    (ViewGroup) findViewById(R.id.popup_element_buy));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(false);

            pwindo.setFocusable(true);

            Button no = (Button) layout.findViewById(R.id.button_no);
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                }
            });

            Button yes = (Button) layout.findViewById(R.id.button_yes);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
