package com.example.poplify.big_potato;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 5/16/2016.
 */
public class Extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;
    PopupWindow pwindo;
    SaveData save_data;
    String[] ques={ "There are seven colours in rainbow.\n Spell one",
            "Aggrefgfdgdfgdgssive",
            "Alonefgfdgdfg gffdgfgfgf",
            "Amazedgfdgdfg",
            "Angrydgdfg",
            "Annoyed",
            "Anxious",
            "Artdgfdgdy",
            "Bitchy",
            "Blah"

    };
    String[] ans={
            " Red\n Orange\n Yellow\n Green\n Blue\n Indigo\n Violet",
            "Alonefgfdgdfg gffdgfgfgf",
            "Amazedgfdgdfg",
            "Angrydgdfg",
            "Annoyed",
            "Anxious",
            "Artdgfdgdy",
            "Bitchy",
            "Annoyed",
            "Blah"

    };
    ArrayList<Image> actorsList=new ArrayList<Image>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.extra_cards);


        save_data=new SaveData(Extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView);
        back = (ImageView) findViewById(R.id.back);



        image_adapter = new ImageAdapter(getApplicationContext(), R.layout.rowhome, actorsList);
        gv.setAdapter(image_adapter);

        for (int i = 0; i < 10; i++) {
            Image actor = new Image();

             if(save_data.isExist(""+i)==true)
            {
                actor.setimage(R.mipmap.card_back);
                actor.settitle(ques[i]);

            }else {
                 actor.setimage(R.mipmap.ques_card);
                 actor.settitle("");
             }
            actorsList.add(actor);
        }

        image_adapter.notifyDataSetChanged();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                save_data.save(""+position,position);
                initiatePopupWindow(position);
            }
        });




    }




    private void initiatePopupWindow(final int position) {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_view,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(false);
            pwindo.setFocusable(true);



            final TextView textView = (TextView) layout.findViewById(R.id.textView_ques);
            textView.setText(ques[position]);
            final Button button = (Button) layout.findViewById(R.id.button_reveal);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (button.getText().toString())
                    {


                        case "Return to question":
                            textView.setText(ques[position]);
                            button.setText("Reveal answers");
                            break;
                        case "Reveal answers":

                            textView.setText(ans[position]);
                            button.setText("Return to question");
                            break;

                    }


                }
            });








            ImageView cross = (ImageView) layout.findViewById(R.id.imageViewcross);
            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                    actorsList.clear();
                    for (int i = 0; i < 10; i++) {
                        Image actor = new Image();
                        if(save_data.isExist(""+i)==true)
                        {
                            actor.setimage(R.mipmap.card_back);
                            actor.settitle(ques[i]);

                        }else {
                            actor.setimage(R.mipmap.ques_card);
                            actor.settitle("");
                        }
                        actorsList.add(actor);
                    }

                    image_adapter.notifyDataSetChanged();
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
