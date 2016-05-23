package com.example.poplify.big_potato.main_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.UsefullData;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by POPLIFY on 5/18/2016.
 */
public class Game_menu extends Activity
{
    private int lastExpandedPosition = -1;
    ExpandableListAdapter listAdapter;
    UsefullData usefull;
    AnimatedExpandableListView expListView;
    List<Integer> listDataHeader;
    HashMap<Integer, List<String>> listDataChild;
    Typeface regular,bold;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_menu);
        expListView = (AnimatedExpandableListView) findViewById(R.id.expandableListView);
        usefull=new UsefullData(getApplicationContext());
        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
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

            TextView txtListChild = (TextView) convertView
                    .findViewById(R.id.lblListItem);
            TextView txtListChild2 = (TextView) convertView
                    .findViewById(R.id.textView10);
            TextView txtListChild3 = (TextView) convertView
                    .findViewById(R.id.textView11_tag);
            LinearLayout layout = (LinearLayout) convertView
                    .findViewById(R.id.child_layout);
            Button btn = (Button) convertView
                    .findViewById(R.id.button2);
            View up = (View) convertView
                    .findViewById(R.id.button2);
            View down = (View) convertView
                    .findViewById(R.id.button2);



            StringTokenizer tokens = new StringTokenizer(childText, "|");

            final String text1 = tokens.nextToken();
            final String text2 = tokens.nextToken();
            final String text3 = tokens.nextToken();
            final String color = tokens.nextToken();

            txtListChild.setText(text1);
            txtListChild.setTypeface(bold);
            txtListChild2.setText(text2);
            txtListChild2.setTypeface(regular);
            txtListChild3.setText(text3);
            txtListChild3.setTypeface(regular);

            layout.setBackgroundColor(Color.parseColor(color));
            btn.setTypeface(bold);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usefull.trimCache(getApplicationContext());
                    switch (text1){

                        case "QWORDIE":

                            Intent i = new Intent (_context, Qwordie_activity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity (i);
                            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case "RAINBOW":

                            Intent i1 = new Intent (_context, RainbowRage.class);
                            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            _context.startActivity (i1);
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
            lblListHeader.setImageResource(headerTitle);

            switch (groupPosition){
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


//906078331
//        7240

//909092797
//        9102
            if(isExpanded==false){
                usefull.trimCache(getApplicationContext());
                cross.setVisibility(View.GONE);
                lblListHeader.setImageResource(headerTitle);
            }else{
                usefull.trimCache(getApplicationContext());
                cross.setVisibility(View.VISIBLE);

                switch (groupPosition){
                    case 0:
                        lblListHeader.setBackgroundColor(Color.parseColor("#E6007E"));
                        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(lblListHeader);
                        Glide.with(_context).load(R.raw.bod_anim).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewTarget);
                        break;
                    case 1:
                        lblListHeader.setBackgroundColor(Color.parseColor("#009FE3"));
                        GlideDrawableImageViewTarget imageViewTarget1 = new GlideDrawableImageViewTarget(lblListHeader);
                        Glide.with(_context).load(R.raw.qwordie_animation).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewTarget1);
                        break;
                    case 2:
                        lblListHeader.setBackgroundColor(Color.parseColor("#00AC13"));
                        GlideDrawableImageViewTarget imageViewTarget2 = new GlideDrawableImageViewTarget(lblListHeader);
                        Glide.with(_context).load(R.raw.scraw_animation).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewTarget2);
                        break;
                    case 3:
                        lblListHeader.setBackgroundColor(Color.parseColor("#1A1A1A"));
                        GlideDrawableImageViewTarget imageViewTarget3 = new GlideDrawableImageViewTarget(lblListHeader);
                        Glide.with(_context).load(R.raw.rainbow_animation).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewTarget3);
                        break;
                    case 4:
                        lblListHeader.setBackgroundColor(Color.parseColor("#078489"));
                        GlideDrawableImageViewTarget imageViewTarget4 = new GlideDrawableImageViewTarget(lblListHeader);
                        Glide.with(_context).load(R.raw.mr_lister_anim).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewTarget4);
                        break;
                    case 5:
                        lblListHeader.setBackgroundColor(Color.parseColor("#A765FF"));
                        GlideDrawableImageViewTarget imageViewTarget5 = new GlideDrawableImageViewTarget(lblListHeader);
                        Glide.with(_context).load(R.raw.obama_animation).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewTarget5);
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
