package com.example.poplify.big_potato.main_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.ExpandableListAdapter;
import com.example.poplify.big_potato.adapters.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by POPLIFY on 5/18/2016.
 */
public class Game_menu extends Activity
{
    private int lastExpandedPosition = -1;
    ExpandableListAdapter listAdapter;
//    ExpandableListView expListView;
    AnimatedExpandableListView expListView;
    List<Integer> listDataHeader;
    HashMap<Integer, List<String>> listDataChild;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_menu);
        expListView = (AnimatedExpandableListView) findViewById(R.id.expandableListView);


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
                if (expListView.isGroupExpanded(groupPosition)) {
                    expListView.collapseGroupWithAnimation(groupPosition);
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

        // Listview Group click listener
//        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v,
//                                        int groupPosition, long id) {
//
//
//                if (expListView.isGroupExpanded(groupPosition)) {
//                    expListView.collapseGroupWithAnimation(groupPosition);
//
//                } else {
//                    expListView.expandGroupWithAnimation(groupPosition);
//                }
//
//                 Toast.makeText(getApplicationContext(),
//                 "Group Clicked " + listDataHeader.get(groupPosition),
//                 Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//
////                expListView.expandGroupWithAnimation(groupPosition);
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//                if (lastExpandedPosition != -1
//                        && groupPosition != lastExpandedPosition) {
//                    expListView.collapseGroupWithAnimation(lastExpandedPosition);
//
//                }
//                lastExpandedPosition = groupPosition;
//            }
//        });
//
//        // Listview Group collasped listener
//        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//
//                expListView.collapseGroupWithAnimation(groupPosition);
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        // Listview on child click listener
//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                return false;
//            }
//        });
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
        top250.add("Shawshank |fdghfhgfhgfhfgh|#E6007E");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("QWORDIE|ghgfhgfhgfhgfhgfh|#0094DA");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Two Guns|gfhgfhgfhgfhgf|#3AAA35");

        List<String> comingSoon1 = new ArrayList<String>();
        comingSoon1.add("Two Guns|gfhgfhgfhgfhgf|#000000");

        List<String> comingSoon2 = new ArrayList<String>();
        comingSoon2.add("Two Guns|gfhgfhgfhgfhgf|#07858A");

        List<String> comingSoon3 = new ArrayList<String>();
        comingSoon3.add("Two Guns|gfhgfhgfhgfhgf|#A765FF");



        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), comingSoon1);
        listDataChild.put(listDataHeader.get(4), comingSoon2);
        listDataChild.put(listDataHeader.get(5), comingSoon3);
    }




}
