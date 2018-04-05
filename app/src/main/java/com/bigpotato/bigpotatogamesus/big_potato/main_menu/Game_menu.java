package com.bigpotato.bigpotatogamesus.big_potato.main_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bigpotato.bigpotatogamesus.big_potato.R;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.ConnectionDetector;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesus.big_potato.hompage.Home_page;
import com.bigpotato.bigpotatogamesus.big_potato.social.Social_activity;
import com.flurry.android.FlurryAgent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by POPLIFY on 5/18/2016.
 */
 public class Game_menu extends Activity {

    SaveData save;
    Typeface regular, bold;
    String key="PMQZP7M6VPRVMN9Q6DW8";
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    List<Data> data;
    static  RecyclerView mRecyclerView;
    static  RecyclerView.Adapter mAdapter;
    static  RecyclerView.LayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

         initialize();
    }

    private void initialize() {

        data = fill_with_data();
        save = new SaveData(getApplicationContext());
        regular = Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_menu);
        mRecyclerView.setHasFixedSize(true);
        cd = new ConnectionDetector(getApplicationContext());
        isInternetPresent = cd.isConnectingToInternet();
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RolodexViewAdapter_menu(data,getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();



        data.add(new Data(R.mipmap.mr_lister,1));
        data.add(new Data(R.mipmap.scrawl, 2));
        data.add(new Data(R.mipmap.obamallama, 3));
        data.add(new Data(R.mipmap.squirms,4));
        data.add(new Data(R.mipmap.okplay_background,5));
        data.add(new Data(R.mipmap.cham_back,6));
        data.add(new Data(R.mipmap.social_menu,7));
        data.add(new Data(R.mipmap.bod, 0));

        return data;
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        try {
            isInternetPresent = cd.isConnectingToInternet();
            FlurryAgent.onStartSession(this, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        isInternetPresent = cd.isConnectingToInternet();
        FlurryAgent.onEndSession(this);
    }




    public class RolodexViewAdapter_menu extends RecyclerView.Adapter<RolodexViewAdapter_menu.ViewHolder> {


        List<Data> list = Collections.emptyList();

        Context contxt;
        Typeface regular, bold;

        // Provide a reference to the views for each data item.
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        public  class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView menu;
            public RelativeLayout card;





            public ViewHolder(View v) {
                super(v);
                menu = (ImageView) v.findViewById(R.id.info_text_menu);
                card = (RelativeLayout) v.findViewById(R.id.menu_main_back);






            }
        }

        // Provide a suitable constructor (depends on the kind of dataset).
        public RolodexViewAdapter_menu(List<Data> list , Context cntxt) {
            this.list = list;
            this.contxt = cntxt;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rolodex_view_card_menu, parent, false);
            // Set the view's size, margins, paddings and layout parameters.


            regular = Typeface.createFromAsset(contxt.getAssets(), "Interstate-Regular.ttf");
            bold = Typeface.createFromAsset(contxt.getAssets(), "ufonts.com_interstate-bold.ttf");

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            // - Get element from your dataset at this position.
            // - Replace the contents of the view with that element.

            runOnUiThread(new Runnable() {
                @Override
                public void run() {




                holder.menu.setImageResource(list.get(position % list.size()).header_img);

        }
    });

            holder.menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            switch (position% list.size()) {

                                case 7 :
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("USA -> Bucket of Doom");
                                    }
                                    save.save("current_game","BUCKET OF DOOM");
                                    Intent b = new Intent(contxt, Home_page.class);
                                    b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(b);

                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;


                                case 1:
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("USA -> Scrawl");
                                    }
                                    save.save("current_game","SCRAWL");
                                    Intent is = new Intent(contxt, Home_page.class);
                                    is.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    is.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(is);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;


                                case 0:
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("USA -> Mr Lister's Quiz shootout");
                                    }
                                    save.save("current_game","MR LISTERS");
                                    Intent bm = new Intent(contxt, Home_page.class);
                                    bm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    bm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(bm);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;
                                case 2:
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("USA -> Obama llama");
                                    }
                                    save.save("current_game","OBLA");
                                    Intent oko = new Intent(contxt, Home_page.class);
                                    oko.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    oko.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(oko);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;
                                case 4:
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("okplay");
                                    }
                                    save.save("current_game","OKPLAY");
                                    Intent ok = new Intent(contxt, Home_page.class);
                                    ok.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    ok.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(ok);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;
                                case 5:
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("Chameleon");
                                    }
                                    save.save("current_game","CHAMELEON");
                                    Intent ch = new Intent(contxt, Home_page.class);
                                    ch.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    ch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(ch);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;
                                case 3:
                                    if(isInternetPresent) {

                                        FlurryAgent.logEvent("Squirms");
                                    }
                                    save.save("current_game","SQUIRMS");
                                    Intent chs = new Intent(contxt, Home_page.class);
                                    chs.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    chs.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(chs);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;
                                case 6:
                                    if(isInternetPresent) {
                                        FlurryAgent.logEvent("Social");
                                    }
                                    save.save("current_game","SOCIAL");

                                    Intent sss = new Intent(contxt, Home_page.class);
                                    sss.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    sss.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    contxt.startActivity(sss);
                                    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                                    break;



                            }
                        }
                    });
                }

            });

        }


        @Override
        public int getItemCount() {
            // Hackish: This is set to INT_MAX so that user has a lot of free space to move around to
            // make the view appear as infinite. This should be improved.
            return Integer.MAX_VALUE;
//        return mDataset.length;
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);

            // Hackish: Set to the middle position so that user can scroll in either direction for a
            // long time. This eventually needs to be improved to wrap better.
            recyclerView.scrollToPosition(Integer.MAX_VALUE / 2);
        }





    }
}
