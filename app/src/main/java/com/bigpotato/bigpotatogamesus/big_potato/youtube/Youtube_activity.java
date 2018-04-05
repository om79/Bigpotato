package com.bigpotato.bigpotatogamesus.big_potato.youtube;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesus.big_potato.R;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.ConnectionDetector;
import com.bigpotato.bigpotatogamesus.big_potato.adapters.SaveData;
import com.flurry.android.FlurryAgent;

/**
 * Created by POPLIFY on 6/8/2016.
 */
public class Youtube_activity extends Fragment
{

    TextView main_txt,watch,swipe;
    ImageView main_pic,back,swipe_arrow;
    LinearLayout swipe_layout;
    SaveData save;
    View line;
    Typeface regular,bold;
    Button you_tube;
    String url;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
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
        line=(View) rootView.findViewById(R.id.viewStub3);
        main_pic=(ImageView) rootView.findViewById(R.id.imageView3_main);
        back=(ImageView) rootView.findViewById(R.id.back_youtube);
        you_tube=(Button) rootView.findViewById(R.id.button);
        swipe_layout=(LinearLayout) rootView.findViewById(R.id.swipe_layout);
        regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");
        main_txt.setTypeface(bold);
        watch.setTypeface(regular);
        swipe.setTypeface(regular);
        save= new SaveData(getActivity());
        cd = new ConnectionDetector(getActivity());
        isInternetPresent = cd.isConnectingToInternet();
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.setMargins(0, 10, 0, 0);
        swipe_arrow=(ImageView) rootView.findViewById(R.id.imageView11);
        main_txt.setTypeface(regular);




        switch (save.getString("current_game"))
        {
            case "BUCKET OF DOOM":
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Bucket of Doom");
                }
                final SpannableStringBuilder str1 = new SpannableStringBuilder("Bucket of Doom is the death-dodging party game where you escape from tons of seriously bad situations with the help of hundreds of useless objects.");
                str1.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.bod_background);
                main_txt.setText(str1);
                main_pic.setImageResource(R.mipmap.bod_youtube);

                main_pic.setLayoutParams(lp);
                url="http://bit.ly/29Oz1E3";
                break;

            case "MR LISTERS":
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Mr Lister");
                }
                final SpannableStringBuilder str5 = new SpannableStringBuilder("Mr Lister is like an old-style Western shootout but with brains for guns. Hit the answers and survive the 'Last Chance Saloon' to win. Yeehaw!");
                str5.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.mr_back);
                main_txt.setText(str5);
                main_pic.setImageResource(R.mipmap.mr_youtube);
                url="http://bit.ly/29OyQc9\n";

                main_pic.setLayoutParams(lp);
                break;
            case "SCRAWL":
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Scrawl");
                }
                final SpannableStringBuilder str5s = new SpannableStringBuilder("Scrawl is a disastrous doodling and guessing game for adults. Sketch a phrase, pass it on and watch how things go horribly wrong. Most grins wins.");
                str5s.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.scrawl_how_back);
                main_txt.setText(str5s);

                main_txt.setTextColor(getResources().getColor(R.color.black));
                line.setBackground(getResources().getDrawable(R.mipmap.squirms_line));
                swipe.setTextColor(getResources().getColor(R.color.black));
                watch.setTextColor(getResources().getColor(R.color.black));
                main_pic.setImageResource(R.mipmap.scrawl_youtube);
                swipe_arrow.setImageResource(R.mipmap.forward_black);
                url="https://www.youtube.com/watch?v=28a8C14jM9Y&t=7s";

                main_pic.setLayoutParams(lp);
                break;
            case "OBLA":
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Obama Llama");
                }
                final SpannableStringBuilder stor5s = new SpannableStringBuilder("Obama Llama is a very silly rhyming charades game. Yell out weird and wonderful rhymes like, \"Piglet eating a twiglet!\" to win the game");
                stor5s.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.obla_play_back);
                main_txt.setText(stor5s);
                main_pic.setImageResource(R.mipmap.obla_youtube);
                url="https://www.youtube.com/watch?v=wEGtxpfcnGo";
//                cham_main_pic.setScaleType(ImageView.ScaleType.FIT_XY);

                break;

            case "CHAMELEON":
                if(isInternetPresent) {

                    FlurryAgent.logEvent("USA -> Chameleon");
                }
                final SpannableStringBuilder stor5sc = new SpannableStringBuilder("The Chameleon is a social-deduction game where players must join together to track down the elusive Chameleon. Can you catch the mystery player before it\'s too late?");
                stor5sc.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.blur_back);
                main_txt.setText(stor5sc);
                main_pic.setImageResource(R.mipmap.cham_youtube);
                url="https://www.youtube.com/watch?v=3IEEUcG0nSo";
//                cham_main_pic.setScaleType(ImageView.ScaleType.FIT_XY);

                break;
            case "OKPLAY":
                if(isInternetPresent) {

                    FlurryAgent.logEvent("OK Play");
                }
                final SpannableStringBuilder str4 = new SpannableStringBuilder("OK Play is a simple 5-in-a-row tile game. It's so easy to learn you can take it anywhere and play with anyone. Over 7 billion people want a game, so don't leave it behind.");
                str4.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.okplay_back);
                main_txt.setText(str4);
                main_pic.setImageResource(R.mipmap.okplay_youtube);
                url="https://www.youtube.com/watch?v=j9fFzBQ2qjQ";
                break;
            case "SQUIRMS":
                if(isInternetPresent)
                {
                    FlurryAgent.logEvent("SQUIRMS");
                }
                final SpannableStringBuilder str4s = new SpannableStringBuilder("Can of Squirms is a slightly awkward and very adult party game where teams of two are forced to look at each other in a way they've never done before.");
                str4s.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0,14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                swipe_layout.setBackgroundResource(R.mipmap.squirms_back);
                main_txt.setText(str4s);
                main_pic.setImageResource(R.mipmap.squirms_youtube_new);
                main_txt.setTextColor(getResources().getColor(R.color.black));
                line.setBackground(getResources().getDrawable(R.mipmap.squirms_line));
                swipe.setTextColor(getResources().getColor(R.color.black));
                watch.setTextColor(getResources().getColor(R.color.black));
                swipe_arrow.setImageResource(R.mipmap.forward_black);
                url="https://www.youtube.com/watch?v=qSvMbjOkLZ0";
                break;

        }


        you_tube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return rootView;



    }









    }
