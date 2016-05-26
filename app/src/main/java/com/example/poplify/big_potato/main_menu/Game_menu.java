package com.example.poplify.big_potato.main_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Handler;

/**
 * Created by POPLIFY on 5/18/2016.
 */
public class Game_menu extends Activity  {
    private int lastExpandedPosition = -1;
    ExpandableListAdapter listAdapter;
    UsefullData usefull;
    AnimatedExpandableListView expListView;
    List<Integer> listDataHeader;
    HashMap<Integer, List<String>> listDataChild;
    Typeface regular, bold;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_menu);
        RelativeLayout progress = new RelativeLayout(this);
        progress.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 100));
        progress.setGravity(Gravity.CENTER);
        progress.addView(new ProgressBar(this));
        expListView = (AnimatedExpandableListView) findViewById(R.id.expandableListView);
        usefull = new UsefullData(getApplicationContext());
        regular = Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        // preparing list data
        prepareListData();


        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                usefull.trimCache(getApplicationContext());
                if (expListView.isGroupExpanded(groupPosition)) {
//                    expListView.collapseGroupWithAnimation(groupPosition);

                } else {

                    expListView.expandGroupWithAnimation(groupPosition);

                }


                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroupWithAnimation(lastExpandedPosition);

                }
                lastExpandedPosition = groupPosition;
                return true;
            }

        });

//        expListView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                expListView.setSelection(0);
//            }
//        }, 500);


        expListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount)
            {

                int lastItem = firstVisibleItem + visibleItemCount;

                if (lastItem==totalItemCount)
                {
                    prepareListData();
                    expListView.setAdapter(listAdapter);
                    listAdapter.notifyDataSetChanged();
                }

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    private void prepareListData() {
        listDataHeader = new ArrayList<Integer>();
        listDataChild = new HashMap<Integer, List<String>>();

        // Adding child data
        listDataHeader.add(R.mipmap.bod);
        listDataHeader.add(R.mipmap.qwordie);
        listDataHeader.add(R.mipmap.scrawl);
        listDataHeader.add(R.mipmap.rainbow_rage);
        listDataHeader.add(R.mipmap.mr_lister);
        listDataHeader.add(R.mipmap.obamallama);


        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("BUCKET OF DOOM|When the s**t hits the fan,\nyou need a plan.|ADULT PARTY GAME • 17+|#E6007E");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("QWORDIE|If Scrabble and Trivial Pursuit \nhad a love child, this would be it.|FAMILY GAME • 14+|#009FE3");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("SCRAML|Disastrous doodles and godawful \nguesses. Most grins wins.|ADULT PARTY GAME • 17+|#00AC13");

        List<String> comingSoon1 = new ArrayList<String>();
        comingSoon1.add("RAINBOW|Think you know the seven colours \nin the rainbow? Not so fast.|SPOT-THE-DIFFERENCE GAME • 8+|#1A1A1A");

        List<String> comingSoon2 = new ArrayList<String>();
        comingSoon2.add("MR LISTERS|Like a Wile West shootout but \nwith brains for guns.|QUIZ PARTY GAME • 14+|#078489");

        List<String> comingSoon3 = new ArrayList<String>();
        comingSoon3.add("OBAMA|The rhyming charades game with \nthe strange sounding name.|PARTY GAME • 14+|#A765FF");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), comingSoon1);
        listDataChild.put(listDataHeader.get(4), comingSoon2);
        listDataChild.put(listDataHeader.get(5), comingSoon3);
    }


    public class ExpandableListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

        private Context _context;
        private List<Integer> _listDataHeader; // header titles
        // child data in format of header title, child title
        private HashMap<Integer, List<String>> _listDataChild;

        public ExpandableListAdapter(Context context, List<Integer> listDataHeader,
                                     HashMap<Integer, List<String>> listChildData) {
            this._context = context;
            this._listDataHeader = listDataHeader;
            this._listDataChild = listChildData;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .get(childPosititon);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, final int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {

            final String childText = (String) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_item, null);
            }


            ImageView headtxt = (ImageView) convertView
                    .findViewById(R.id.lblListItem);
            TextView txtListChild2 = (TextView) convertView
                    .findViewById(R.id.textView10);
            TextView txtListChild3 = (TextView) convertView
                    .findViewById(R.id.textView11_tag);
            LinearLayout layout = (LinearLayout) convertView
                    .findViewById(R.id.child_layout);
            Button btn = (Button) convertView
                    .findViewById(R.id.button2);


            StringTokenizer tokens = new StringTokenizer(childText, "|");

            final String text1 = tokens.nextToken();
            final String text2 = tokens.nextToken();
            final String text3 = tokens.nextToken();
            final String color = tokens.nextToken();


            txtListChild2.setText(text2);
            txtListChild2.setTypeface(regular);
            txtListChild3.setText(text3);
            txtListChild3.setTypeface(regular);


            layout.setBackgroundColor(Color.parseColor(color));
            btn.setTypeface(bold);

            switch (groupPosition) {

                case 0:
                    headtxt.setImageResource(R.mipmap.bod_head);
                    break;
                case 1:
                    headtxt.setImageResource(R.mipmap.quoride_head);
                    break;
                case 2:
                    headtxt.setImageResource(R.mipmap.scrwal_head);
                    break;
                case 3:
                    headtxt.setImageResource(R.mipmap.rainbow_head);
                    break;
                case 4:
                    headtxt.setImageResource(R.mipmap.mr_lister_head);
                    break;
                case 5:
                    headtxt.setImageResource(R.mipmap.obama_head);
                    break;

            }


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    switch (text1) {

                        case "QWORDIE":

                            Intent i = new Intent(_context, Qwordie_activity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity(i);
                            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case "RAINBOW":

                            Intent i1 = new Intent(_context, RainbowRage.class);
                            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity(i1);
                            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                    }

                }
            });
            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this._listDataHeader.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            Integer headerTitle = (Integer) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_group, null);
            }

            ImageView lblListHeader = (ImageView) convertView
                    .findViewById(R.id.lblListHeader);

            ImageView cross = (ImageView) convertView
                    .findViewById(R.id.imageView7cross);
            final GifView gif = (GifView) convertView.findViewById(R.id.gifview);
            LinearLayout gif_back = (LinearLayout) convertView
                    .findViewById(R.id.gif_back);

            lblListHeader.setImageResource(headerTitle);

            switch (groupPosition) {
                case 0:
                    lblListHeader.setBackgroundColor(Color.parseColor("#E6007E"));
                    break;
                case 1:
                    lblListHeader.setBackgroundColor(Color.parseColor("#009FE3"));
                    break;
                case 2:
                    lblListHeader.setBackgroundColor(Color.parseColor("#00AC13"));
                    break;
                case 3:
                    lblListHeader.setBackgroundColor(Color.parseColor("#1A1A1A"));
                    break;
                case 4:
                    lblListHeader.setBackgroundColor(Color.parseColor("#078489"));
                    break;
                case 5:
                    lblListHeader.setBackgroundColor(Color.parseColor("#A765FF"));
                    break;

            }
            if (isExpanded == false) {
                usefull.trimCache(getApplicationContext());
                cross.setVisibility(View.GONE);
                lblListHeader.setImageResource(headerTitle);
                gif_back.setVisibility(View.GONE);

                lblListHeader.setVisibility(View.VISIBLE);
            } else {
                usefull.trimCache(getApplicationContext());
                cross.setVisibility(View.VISIBLE);
                gif_back.setVisibility(View.VISIBLE);
                lblListHeader.setVisibility(View.GONE);
                switch (groupPosition) {
                    case 0:

                        gif.setPaused(false);
                        gif_back.setBackgroundColor(Color.parseColor("#E6007E"));
                        gif.setMovieResource(R.raw.bod_anim);
                        new CountDownTimer(gif.getMovie_duration(), gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                gif.setPaused(true);
                            }
                        }.start();

                        break;
                    case 1:

                        gif.setPaused(false);
                        gif_back.setBackgroundColor(Color.parseColor("#009FE3"));
                        gif.setMovieResource(R.raw.qwordie_animation);
                        new CountDownTimer(gif.getMovie_duration(), gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                gif.setPaused(true);
                            }
                        }.start();

                        break;
                    case 2:

                        gif.setPaused(false);
                        gif_back.setBackgroundColor(Color.parseColor("#00AC13"));
                        gif.setMovieResource(R.raw.scraw_animation);

                        new CountDownTimer(gif.getMovie_duration(), gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                gif.setPaused(true);
                            }
                        }.start();
                        break;
                    case 3:

                        gif.setPaused(false);
                        gif_back.setBackgroundColor(Color.parseColor("#1A1A1A"));
                        gif.setMovieResource(R.raw.rainbow_animation);

                        new CountDownTimer(gif.getMovie_duration(), gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                gif.setPaused(true);
                            }
                        }.start();

                        break;
                    case 4:
                        gif.setPaused(false);

                        gif_back.setBackgroundColor(Color.parseColor("#078489"));
                        gif.setMovieResource(R.raw.mr_lister_anim);

                        new CountDownTimer(gif.getMovie_duration(), gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                gif.setPaused(true);
                            }
                        }.start();
                        break;
                    case 5:
                        gif.setPaused(false);

                        gif_back.setBackgroundColor(Color.parseColor("#A765FF"));
                        gif.setMovieResource(R.raw.obama_animation);

                        new CountDownTimer(gif.getMovie_duration(), gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                gif.setPaused(true);
                            }
                        }.start();
                        break;

                }

            }

            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    usefull.trimCache(getApplicationContext());
                    if (expListView.isGroupExpanded(groupPosition)) {
                        expListView.collapseGroupWithAnimation(groupPosition);


                    } else {
                        expListView.expandGroupWithAnimation(groupPosition);

                    }


                }
            });


            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }





}
