package com.example.poplify.big_potato.youtube;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;
import com.example.poplify.big_potato.mr_lister.Mr_homepage;
import com.example.poplify.big_potato.obla.Obla_homapage;
import com.example.poplify.big_potato.ok_play.Ok_play_homescreen;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;
import com.example.poplify.big_potato.scrawl.Scraml_homepage;
import com.example.poplify.big_potato.view_pager.Startup_activity;

/**
 * Created by POPLIFY on 6/8/2016.
 */
public class Youtube_activity extends Fragment
{

    TextView main_txt,watch,swipe;
    ImageView main_pic,back;
    LinearLayout swipe_layout;
    SaveData save;
    RelativeLayout main;
    Typeface regular,bold;

    public Youtube_activity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.you_tube_layout, container, false);

        main_txt=(TextView) rootView.findViewById(R.id.you_raintxt);
        watch=(TextView) rootView.findViewById(R.id.how_to_play_bod_watch);
        swipe=(TextView) rootView.findViewById(R.id.the_game_bod_swipe);
        main=(RelativeLayout) rootView.findViewById(R.id.main_layout);
        main_pic=(ImageView) rootView.findViewById(R.id.imageView3_main);
        back=(ImageView) rootView.findViewById(R.id.back_youtube);
        swipe_layout=(LinearLayout) rootView.findViewById(R.id.swipe_layout);
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");
        main_txt.setTypeface(bold);
        watch.setTypeface(regular);
        swipe.setTypeface(regular);
        save= new SaveData(getActivity());



//        swipe_layout.setOnTouchListener(new OnSwipeTouchListener(Youtube_activity.this) {
//        public void onSwipeTop() {
//         }
//        public void onSwipeRight() {
//          }
//        public void onSwipeLeft() {
//
//        }
//        public void onSwipeBottom() {
//            Toast.makeText(Youtube_activity.this, "bottom", Toast.LENGTH_SHORT).show();
//        }
//
//    });



        main_txt.setTypeface(regular);




        switch (save.getString("current_game"))
        {
            case "BUCKET OF DOOM":

                final SpannableStringBuilder str1 = new SpannableStringBuilder("Bucket of Doom is the death-dodging party game where you escape from tons of seriously bad situations with the help of hundreds of useless objects.");
                str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.bod_background);
                main_txt.setText(str1);
                main_pic.setImageResource(R.mipmap.bod_youtube);
                break;
            case "RAINBOW":

                final SpannableStringBuilder str2 = new SpannableStringBuilder("Rainbow Rage is a charmingly infuriating spot-the-difference game. Be the first person to grab the colours that have swapped places and build your own rainbow to victory.");
                str2.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.background);
                main_txt.setText(str2);
                main_pic.setImageResource(R.mipmap.rainbow_youtube);
                break;
            case "QWORDIE":
                final SpannableStringBuilder str12 = new SpannableStringBuilder("Qwordie  is an unlikely mix of a quiz and word game. Build the answers to quiz questions by collecting and stealing tiles. The biggest stacks wins.");
                str12.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.blur_back);
                main_txt.setText(str12);
                main_pic.setImageResource(R.mipmap.qwordie_youtube);
                break;
            case "OKPLAY":

                final SpannableStringBuilder str4 = new SpannableStringBuilder("OK Play is a simple 5-in-a-row tile game. It's so easy to learn you can take it anywhere and play with anyone. Over 7 billion people want a game, so don't leave it behind.");
                str4.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.okplay_back);
                main_txt.setText(str4);
                main_pic.setImageResource(R.mipmap.okplay_youtube);
                break;
            case "MR LISTERS":
                final SpannableStringBuilder str5 = new SpannableStringBuilder("Mr Lister is like an old-style Western shootout but with brains for guns. Hit the answers and survive the 'Last Chance Saloon' to win. Yeehaw!");
                str5.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.mr_back);
                main_txt.setText(str5);
                main_pic.setImageResource(R.mipmap.mr_youtube);
                break;
            case "SCRAWL":
                final SpannableStringBuilder str5s = new SpannableStringBuilder("Scrawl is a disastrous doodling and guessing game for adults. Sketch a phrase, pass it on and watch how things go horribly wrong. Most grins wins.");
                str5s.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.scrawl_how_back);
                main_txt.setText(str5s);
                main_pic.setImageResource(R.mipmap.scrawl_youtube);
                break;
            case "OBLA":
                final SpannableStringBuilder stor5s = new SpannableStringBuilder("Obama Llama is a very silly rhyming charades game. Yell out weird and wonderful rhymes like,\"Piglet eating a twiglet!\" to win the game");
                stor5s.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                main.setBackgroundResource(R.mipmap.obla_play_back);
                main_txt.setText(stor5s);
                main_pic.setImageResource(R.mipmap.obla_youtube);
                break;

        }


        return rootView;



    }









    }
