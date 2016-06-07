package com.example.poplify.big_potato.mr_lister;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.Image;
import com.example.poplify.big_potato.adapters.ImageAdapter;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_cards;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 6/6/2016.
 */
public class Mr_extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;
    PopupWindow pwindo;
    SaveData save_data;
    UsefullData usefull;

    ArrayList<Image> actorsList=new ArrayList<Image>();
   int[] qpic=new int[]{R.mipmap.mr1,R.mipmap.mr2,R.mipmap.mr3,R.mipmap.mr4,R.mipmap.mr5,R.mipmap.mr6,
           R.mipmap.mr1,R.mipmap.mr2,R.mipmap.mr3,R.mipmap.mr4,R.mipmap.mr5,R.mipmap.mr6};

    int[] anspic=new int[]{R.mipmap.ans1,R.mipmap.ans2,R.mipmap.ans3,R.mipmap.ans4,R.mipmap.ans5,R.mipmap.ans6,
            R.mipmap.ans7,R.mipmap.ans8,R.mipmap.ans9,R.mipmap.ans10,R.mipmap.ans11,R.mipmap.ans12};


    Typeface regular,bold;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mr_extra_cards);

        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Mr_extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView_bod_extra_mr);
        back = (ImageView) findViewById(R.id.back_bod_extra_mr);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");



        image_adapter = new ImageAdapter(getApplicationContext(), R.layout.rowhome, actorsList);
        gv.setAdapter(image_adapter);

        new set_images().execute();




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usefull.trimCache(getApplicationContext());
                Intent how23=new Intent(getApplicationContext(),Mr_homepage.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                usefull.trimCache(getApplicationContext());
                save_data.save("mr"+position,position);
                initiatePopupWindow();
            }
        });







    }





    private void initiatePopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.full_pic_popup,
                    (ViewGroup) findViewById(R.id.popup_element_pic));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(false);
            pwindo.setFocusable(true);


            final ImageView cross = (ImageView) layout.findViewById(R.id.imageViewcross);


            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    pwindo.dismiss();

                    new set_images().execute();
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    class set_images extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        protected void onPreExecute()
        {
            actorsList.clear();
            dialog = new ProgressDialog(Mr_extra_cards.this, AlertDialog.THEME_HOLO_DARK);
            dialog.setMessage("Please wait a moment");
            dialog.show();
            dialog.setCancelable(false);

        }
      protected Void doInBackground(Void... arg0) {
            for (int i = 0; i < 12; i++) {
                Image actor = new Image();

                if(save_data.isExist("mr"+i)==true)
                {
                    actor.setimage(anspic[i]);
                    actor.settitle("");

                }else {
                    actor.setimage(qpic[i]);
                    actor.settitle("");
                }
                actorsList.add(actor);
            }
            return null;
        }
        protected void onPostExecute(Void result)
        {
            dialog.cancel();
            image_adapter.notifyDataSetChanged();
        }

    }




}

