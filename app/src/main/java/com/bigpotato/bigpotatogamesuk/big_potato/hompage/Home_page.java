package com.bigpotato.bigpotatogamesuk.big_potato.hompage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesuk.big_potato.bucket_of_doom.Bod_homepage;
import com.bigpotato.bigpotatogamesuk.big_potato.mr_lister.Mr_homepage;
import com.bigpotato.bigpotatogamesuk.big_potato.obla.Obla_homapage;
import com.bigpotato.bigpotatogamesuk.big_potato.ok_play.Ok_play_homescreen;
import com.bigpotato.bigpotatogamesuk.big_potato.qwordie.Qwordie_activity;
import com.bigpotato.bigpotatogamesuk.big_potato.rainbow_rage.RainbowRage;
import com.bigpotato.bigpotatogamesuk.big_potato.scrawl.Scraml_homepage;

/**
 * Created by POPLIFY on 7/11/2016.
 */
public class Home_page extends Activity {

    String[] cs = new String[] { "bod", "mr_lister", "scrwal",
            "obama","qworide",  "rainbow","ok_play" };
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    SaveData save;

    int[] c = new int[] { R.mipmap.bod,R.mipmap.mr_lister, R.mipmap.scrawl,R.mipmap.obamallama,R.mipmap.qwordie,R.mipmap.rainbow_rage,
           R.mipmap.okplay_background};
    Fragment f = new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        save= new SaveData(getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);




        switch (save.getString("current_game"))
        {
            case "BUCKET OF DOOM":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Bod_homepage()).commit();

                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"bod");
                mRecyclerView.setAdapter(mAdapter);


                break;
            case "MR LISTERS":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Mr_homepage()).commit();
                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"mr_lister");
                mRecyclerView.setAdapter(mAdapter);

                break;
            case "QWORDIE":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Qwordie_activity()).commit();
                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"qworide");
                mRecyclerView.setAdapter(mAdapter);

                break;
            case "SCRAWL":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Scraml_homepage()).commit();
                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"scrwal");
                mRecyclerView.setAdapter(mAdapter);
                break;
            case "RAINBOW":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new RainbowRage()).commit();
                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"rainbow");
                mRecyclerView.setAdapter(mAdapter);
                break;
            case "OBLA":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Obla_homapage()).commit();
                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"obama");
                mRecyclerView.setAdapter(mAdapter);
                break;
            case "OKPLAY":
                if (savedInstanceState == null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Ok_play_homescreen()).commit();
                }
                mAdapter = new RolodexViewAdapter(c,cs,getApplicationContext(),"ok_play");
                mRecyclerView.setAdapter(mAdapter);
                break;

        }



    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {

        super.onPause();
    }

    /** Called before the activity is destroyed. */
    @Override
    public void onDestroy() {
        // Destroy the AdView.

        super.onDestroy();
    }

    public class RolodexViewAdapter extends RecyclerView.Adapter<RolodexViewAdapter.ViewHolder> {

        private int[] mDataset;
        private String[] value;
        Context cntxt;
        String game;
        SaveData save;
        // Provide a reference to the views for each data item.
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        public  class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView mimgView;
            public ViewHolder(View v) {
                super(v);
                mimgView = (ImageView) v.findViewById(R.id.info_img);


            }
        }

        // Provide a suitable constructor (depends on the kind of dataset).
        public RolodexViewAdapter(int[] myDataset,String[] data,Context c,String g) {
            mDataset = myDataset;
            value=data;
            cntxt=c;
            game=g;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rolodex_view_card, parent, false);
            // Set the view's size, margins, paddings and layout parameters.
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            // - Get element from your dataset at this position.
            // - Replace the contents of the view with that element.
            holder.mimgView.setImageResource(mDataset[position % mDataset.length]);
            save = new SaveData(cntxt);

            if(game.equals(value[position% mDataset.length]))
            {
                holder.mimgView.setPadding(10,10,10,10);
            }else {
                holder.mimgView.setPadding(0,0,0,0);
            }
//            switch (value[position% mDataset.length])
//            {
//                case "bod":
//                    holder.mimgView.setImageResource(R.mipmap.bod);
//
//                    break;
//                case "qworide":
//                    holder.mimgView.setImageResource(R.mipmap.qwordie);
//                    break;
//                case "scrwal":
//
//                    holder.mimgView.setImageResource(R.mipmap.scrawl);
//
//                    break;
//                case "rainbow":
//                    holder.mimgView.setImageResource(R.mipmap.rainbow_rage);
//
//                    break;
//                case "mr_lister":
//
//                    holder.mimgView.setImageResource(R.mipmap.mr_lister);
//                    break;
//                case "obama":
//
//                    holder.mimgView.setImageResource(R.mipmap.obamallama);
//
//                    break;
//                case "ok_play":
//
//                    holder.mimgView.setImageResource(R.mipmap.ok_play);
//                    break;
//
//            }


            holder.mimgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    holder.mimgView.setPadding(0,0,0,0);
                    switch (value[position% mDataset.length])
                    {
                        case "bod":
                            save.save("current_game","BUCKET OF DOOM");
                            FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.frame_container, new Bod_homepage()).commit();
                            game="bod";
                            mAdapter.notifyDataSetChanged();

                            break;
                        case "qworide":
                            save.save("current_game","QWORDIE");
                            FragmentManager fragmentManager1 = getFragmentManager();
                            fragmentManager1.beginTransaction()
                                    .replace(R.id.frame_container, new Qwordie_activity()).commit();
                            game="qworide";
                            mAdapter.notifyDataSetChanged();
                            break;
                        case "scrwal":
                            save.save("current_game","SCRAWL");
                            FragmentManager fragmentManager3 = getFragmentManager();
                            fragmentManager3.beginTransaction()
                                    .replace(R.id.frame_container, new Scraml_homepage()).commit();
                            game="scrwal";
                            mAdapter.notifyDataSetChanged();

                            break;
                        case "rainbow":
                            save.save("current_game","RAINBOW");
                            FragmentManager fragmentManager4 = getFragmentManager();
                            fragmentManager4.beginTransaction()
                                    .replace(R.id.frame_container, new RainbowRage()).commit();
                            game="rainbow";
                            mAdapter.notifyDataSetChanged();

                            break;
                        case "mr_lister":
                            save.save("current_game","MR LISTERS");
                            FragmentManager fragmentManager2 = getFragmentManager();
                            fragmentManager2.beginTransaction()
                                    .replace(R.id.frame_container, new Mr_homepage()).commit();
                            game="mr_lister";
                            mAdapter.notifyDataSetChanged();
                            break;
                        case "obama":

                            save.save("current_game","OBLA");
                            FragmentManager fragmentManager5= getFragmentManager();
                            fragmentManager5.beginTransaction()
                                    .replace(R.id.frame_container, new Obla_homapage()).commit();
                            game="obama";
                            mAdapter.notifyDataSetChanged();
                            break;
                        case "ok_play":
                            save.save("current_game","OKPLAY");
                            FragmentManager fragmentManager6 = getFragmentManager();
                            fragmentManager6.beginTransaction()
                                    .replace(R.id.frame_container, new Ok_play_homescreen()).commit();
                            game="ok_play";
                            mAdapter.notifyDataSetChanged();

                            break;

                    }


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

