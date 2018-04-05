package com.bigpotato.bigpotatogamesus.big_potato.mr_lister;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.bigpotato.bigpotatogamesus.big_potato.R;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.Image;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.ImageAdapter;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.UsefullData;

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
           R.mipmap.mr1,R.mipmap.mr2,R.mipmap.mr3,R.mipmap.mr4,R.mipmap.mr5,R.mipmap.mr6,
           R.mipmap.mr1,R.mipmap.mr2,R.mipmap.mr3,R.mipmap.mr4,R.mipmap.mr5,R.mipmap.mr6,R.mipmap.mr1,R.mipmap.mr2};

    int[] anspic=new int[]{R.mipmap.ans1,R.mipmap.ans2,R.mipmap.ans3,R.mipmap.ans4,R.mipmap.ans5,R.mipmap.ans6,
            R.mipmap.ans7,R.mipmap.ans8,R.mipmap.ans9,R.mipmap.ans10,R.mipmap.ans11,R.mipmap.ans12,
            R.mipmap.ans13,R.mipmap.ans14,R.mipmap.ans15,R.mipmap.ans16,R.mipmap.ans17,R.mipmap.ans18,R.mipmap.ans19,R.mipmap.ans20};


    Typeface regular,bold;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mr_extra_cards);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
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
                managerOfSound();
                finish();
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                usefull.trimCache(getApplicationContext());
                save_data.save("mr"+position,position);
                initiatePopupWindow(position);
            }
        });







    }



    @Override
    public void onBackPressed() {
        // your code.
        managerOfSound();
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void initiatePopupWindow(int pos) {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.full_pic_popup,
                    (ViewGroup) findViewById(R.id.popup_element_pic));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(false);
            pwindo.setFocusable(true);

            new set_images().execute();
            final ImageView cross = (ImageView) layout.findViewById(R.id.imageViewcross);
            final ImageView main = (ImageView) layout.findViewById(R.id.imageView10_ans);
            main.setImageResource(anspic[pos]);

            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    pwindo.dismiss();


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
            for (int i = 0; i < 20; i++) {
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


    private void managerOfSound() {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.back_button);
        if (!mp.isPlaying()) {
            mp.start();
        } else {

            mp.stop();


        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.reset();
                mp.release();


            }
        });
    }

}

