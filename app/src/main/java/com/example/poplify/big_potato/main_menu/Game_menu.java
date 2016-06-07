package com.example.poplify.big_potato.main_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;
import com.example.poplify.big_potato.mr_lister.Mr_homepage;
import com.example.poplify.big_potato.ok_play.Ok_play_homescreen;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by POPLIFY on 5/18/2016.
 */
 public class Game_menu extends Activity {
    private int lastExpandedPosition = -1;
    ExpandableListAdapter listAdapter;
    UsefullData usefull;
    SaveData save;
    AnimatedExpandableListView expListView;
    List<String> listDataHeader;

    HashMap<String, List<String>> listDataChild;
    Typeface regular, bold;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        LinearLayout container = (LinearLayout) findViewById(R.id.menu_container);
         expListView = (AnimatedExpandableListView) findViewById(R.id.expandableListView);
        usefull = new UsefullData(getApplicationContext());
        save = new SaveData(getApplicationContext());
        regular = Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        // preparing list data
        prepareListData();
//        save.save("select",false);

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
                } else {

                    switch (groupPosition){
                        case 6:
                            usefull.showMsgOnUI("Coming soon!");
                            break;
                        case 7:
                            save.save("current_game","OKPLAY");
                            Intent ok=new Intent(getApplicationContext(), Ok_play_homescreen.class);
                            startActivity(ok);
                            break;
                        default:
                            expListView.expandGroupWithAnimation(groupPosition);
                            break;
                    }



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
            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//
//
//
//
//
            }
//
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if (expListView.getLastVisiblePosition() == (listDataHeader.size()-1)) {
//                    listDataHeader = new ArrayList<String>();
//                    listDataChild = new HashMap<String, List<String>>();
//
//                    // Adding child data
//                    listDataHeader.add("BUCKET OF DOOM");
//                    listDataHeader.add("QWORDIE");
//                    listDataHeader.add("SCRAML");
//                    listDataHeader.add("RAINBOW");
//                    listDataHeader.add("MR LISTERS");
//                    listDataHeader.add("OBAMA");
//                    listDataHeader.add("SOCIAL");
//                    listDataHeader.add("OKPLAY");
//
//
//                    // Adding child data
//                    List<String> top250 = new ArrayList<String>();
//                    top250.add("BUCKET OF DOOM|When the s**t hits the fan,\nyou need a plan.|ADULT PARTY GAME • 17+|#E6007E");
//
//                    List<String> nowShowing = new ArrayList<String>();
//                    nowShowing.add("QWORDIE|If Scrabble and Trivial Pursuit \nhad a love child, this would be it.|FAMILY GAME • 14+|#009FE3");
//
//                    List<String> comingSoon = new ArrayList<String>();
//                    comingSoon.add("SCRAML|Disastrous doodles and godawful \nguesses. Most grins wins.|ADULT PARTY GAME • 17+|#00AC13");
//
//                    List<String> comingSoon1 = new ArrayList<String>();
//                    comingSoon1.add("RAINBOW|Think you know the seven colours \nin the rainbow? Not so fast.|SPOT-THE-DIFFERENCE GAME • 8+|#1A1A1A");
//
//                    List<String> comingSoon2 = new ArrayList<String>();
//                    comingSoon2.add("MR LISTERS|Like a Wile West shootout but \nwith brains for guns.|QUIZ PARTY GAME • 14+|#078489");
//
//                    List<String> comingSoon3 = new ArrayList<String>();
//                    comingSoon3.add("OBAMA|The rhyming charades game with \nthe strange sounding name.|PARTY GAME • 14+|#A765FF");
//
//                    List<String> comingSoon4 = new ArrayList<String>();
//                    comingSoon4.add("SOCIAL|The rhyming charades game with \nthe strange sounding name.|PARTY GAME • 14+|#FFE00F");
//
//                    List<String> comingSoon5 = new ArrayList<String>();
//                    comingSoon4.add("OKPLAY|The rhyming charades game with \nthe strange sounding name.|PARTY GAME • 14+|#FFE00F");
//
//
//                    listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//                    listDataChild.put(listDataHeader.get(1), nowShowing);
//                    listDataChild.put(listDataHeader.get(2), comingSoon);
//                    listDataChild.put(listDataHeader.get(3), comingSoon1);
//                    listDataChild.put(listDataHeader.get(4), comingSoon2);
//                    listDataChild.put(listDataHeader.get(5), comingSoon3);
//                    listDataChild.put(listDataHeader.get(6), comingSoon4);
//                    listDataChild.put(listDataHeader.get(7), comingSoon5);
//
//
//                    expListView.setAdapter(listAdapter);
//                    listAdapter.notifyDataSetChanged();

                }

        }


});


    }

    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("BUCKET OF DOOM");
        listDataHeader.add("QWORDIE");
        listDataHeader.add("SCRAML");
        listDataHeader.add("RAINBOW");
        listDataHeader.add("MR LISTERS");
        listDataHeader.add("OBAMA");
        listDataHeader.add("SOCIAL");
        listDataHeader.add("OKPLAY");


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

        List<String> comingSoon4 = new ArrayList<String>();
        comingSoon4.add("SOCIAL|The rhyming charades game with \nthe strange sounding name.|PARTY GAME • 14+|#FFE00F");

        List<String> comingSoon5 = new ArrayList<String>();
        comingSoon4.add("OKPLAY|Have game, will travel.Take it \nanywhere, play it with anyone|Simple Tile Game|#FFE00F");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), comingSoon1);
        listDataChild.put(listDataHeader.get(4), comingSoon2);
        listDataChild.put(listDataHeader.get(5), comingSoon3);
        listDataChild.put(listDataHeader.get(6), comingSoon4);
        listDataChild.put(listDataHeader.get(7), comingSoon5);
    }


    public class ExpandableListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

        private Context _context;
        private List<String> _listDataHeader; // header titles
        // child data in format of header title, child title
        private HashMap<String, List<String>> _listDataChild;




        public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                     HashMap<String, List<String>> listChildData) {
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

            switch (text1) {

                case "BUCKET OF DOOM":
                    headtxt.setImageResource(R.mipmap.bod_head);
                    break;
                case "QWORDIE":
                    headtxt.setImageResource(R.mipmap.quoride_head);
                    break;
                case "SCRAML":
                    headtxt.setImageResource(R.mipmap.scrwal_head);
                    break;
                case "RAINBOW":
                    headtxt.setImageResource(R.mipmap.rainbow_head);
                    break;
                case "MR LISTERS":
                    headtxt.setImageResource(R.mipmap.mr_lister_head);
                    break;
                case "OBAMA":
                    headtxt.setImageResource(R.mipmap.obama_head);
                    break;
                case "SOCIAL":
                    headtxt.setImageResource(R.mipmap.social_head);
                    break;

            }


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    switch (text1) {

                        case "BUCKET OF DOOM":
                            save.save("current_game","BUCKET OF DOOM");
                            Intent b = new Intent(_context, Bod_homepage.class);
                            b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity(b);
                            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;

                        case "QWORDIE":

                            save.save("current_game","QWORDIE");
                            Intent i = new Intent(_context, Qwordie_activity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity(i);
                            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case "RAINBOW":
                            save.save("current_game","RAINBOW");
                            Intent i1 = new Intent(_context, RainbowRage.class);
                            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity(i1);
                            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;

                        case "MR LISTERS":
                            save.save("current_game","MR LISTERS");
                            Intent bm = new Intent(_context, Mr_homepage.class);
                            bm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            bm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity(bm);
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
            String text1 = (String) getGroup(groupPosition);
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

//            StringTokenizer tokens = new StringTokenizer(headerTitle, "|");

//            final String text1 = tokens.nextToken();





            if (isExpanded == false) {
                usefull.trimCache(getApplicationContext());
                cross.setVisibility(View.GONE);
                gif_back.setVisibility(View.GONE);
                lblListHeader.setVisibility(View.VISIBLE);
                switch (text1) {
                    case "BUCKET OF DOOM":
                        lblListHeader.setBackgroundColor(Color.parseColor("#E6007E"));
                        lblListHeader.setImageResource(R.mipmap.bod);
                        break;
                    case "QWORDIE":
                        lblListHeader.setBackgroundColor(Color.parseColor("#009FE3"));
                        lblListHeader.setImageResource(R.mipmap.qwordie);
                        break;
                    case "SCRAML":
                        lblListHeader.setBackgroundColor(Color.parseColor("#00AC13"));
                        lblListHeader.setImageResource(R.mipmap.scrawl);
                        break;
                    case "RAINBOW":
                        lblListHeader.setBackgroundColor(Color.parseColor("#1A1A1A"));
                        lblListHeader.setImageResource(R.mipmap.rainbow_rage);
                        break;
                    case "MR LISTERS":
                        lblListHeader.setBackgroundColor(Color.parseColor("#078489"));
                        lblListHeader.setImageResource(R.mipmap.mr_lister);
                        break;
                    case "OBAMA":
                        lblListHeader.setBackgroundColor(Color.parseColor("#A765FF"));
                        lblListHeader.setImageResource(R.mipmap.obamallama);
                        break;
                    case "SOCIAL":
                        lblListHeader.setBackgroundColor(Color.parseColor("#FFE00F"));
                        lblListHeader.setImageResource(R.mipmap.social);
                        break;
                    case "OKPLAY":
                        lblListHeader.setBackgroundColor(Color.parseColor("#f08a16"));
                        lblListHeader.setImageResource(R.mipmap.ok_play);
                        break;
                    default:
                        break;

                }

            } else {
                usefull.trimCache(getApplicationContext());
                cross.setVisibility(View.VISIBLE);
                lblListHeader.setVisibility(View.GONE);
                gif_back.setVisibility(View.VISIBLE);

                switch (text1) {
                    case "BUCKET OF DOOM":

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
                    case "QWORDIE":

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
                    case "SCRAML":

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
                    case "RAINBOW":

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
                    case "MR LISTERS":
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
                    case "OBAMA":
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
                    default:
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
