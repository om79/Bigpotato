package com.bigpotato.bigpotatogamesuk.big_potato.social;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.UsefullData;
import com.flurry.android.FlurryAgent;

/**
 * Created by POPLIFY on 7/31/2017.
 */

public class Social_activity extends Fragment
{
    RelativeLayout back;
    TextView txt,tag;
    RelativeLayout facebook,instgram,twitter,youtube;
    UsefullData usefull;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.social_activity, container, false);



        usefull = new UsefullData(getActivity());
        back=(RelativeLayout) rootView.findViewById(R.id.social_cross);
        txt=(TextView) rootView.findViewById(R.id.textView);
        tag=(TextView) rootView.findViewById(R.id.title_tag);
        Typeface regular= Typeface.createFromAsset(getActivity().getAssets(), "Interstate-Regular.ttf");
        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "ufonts.com_interstate-bold.ttf");
        txt.setTypeface(regular);
        tag.setTypeface(regular);

        facebook= (RelativeLayout) rootView.findViewById(R.id.instagram);
        instgram= (RelativeLayout) rootView.findViewById(R.id.snapchat);
        twitter= (RelativeLayout) rootView.findViewById(R.id.twitter);
        youtube= (RelativeLayout) rootView.findViewById(R.id.mail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(usefull.isNetworkConnected()) {


                    FlurryAgent.logEvent("Facebook");
                    Intent facebookIntent = getOpenFacebookIntent(getActivity());
                    facebookIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(facebookIntent);
                }else {
                    usefull.showMsgOnUI("Please check your internet connection!");
                }

            }
        });

        instgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    // mediaLink is something like "https://instagram.com/p/6GgFE9JKzm/" or
                    // "https://instagram.com/_u/sembozdemir"
                    if(usefull.isNetworkConnected()) {

                        FlurryAgent.logEvent("Instagram");
                        try {
                            Uri uri = Uri.parse("instagram://user?username=bigpotatogames");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setPackage("com.instagram.android");
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            Log.e("TAG", e.getMessage());
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.setData(Uri.parse("http://bit.ly/BigPotatoInsta"));
                            startActivity(i);
                        }

                    }else {
                        usefull.showMsgOnUI("Please check your internet connection!");
                    }

            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // mediaLink is something like "https://instagram.com/p/6GgFE9JKzm/" or
                    // "https://instagram.com/_u/sembozdemir"
                    if(usefull.isNetworkConnected()) {

                        FlurryAgent.logEvent("Twitter");
                        try {
                            Uri uri = Uri.parse("twitter://user?screen_name=bigpotatogames");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setPackage("com.twitter.android");
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            Log.e("TAG", e.getMessage());
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.setData(Uri.parse("http://bit.ly/BigPotatoTw"));
                            startActivity(i);
                        }
                        }else {
                        usefull.showMsgOnUI("Please check your internet connection!");
                    }

            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(usefull.isNetworkConnected()) {

                    FlurryAgent.logEvent("Youtube");

                        try {
                            Uri uri = Uri.parse("youtube://www.youtube.com/channel/UCZZABV07W87eC4XN8S9I7Ww");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setPackage("com.google.android.youtube");
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            Log.e("TAG", e.getMessage());
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.setData(Uri.parse("https://www.youtube.com/channel/UCZZABV07W87eC4XN8S9I7Ww"));
                            startActivity(i);
                        }



                }else {
                    usefull.showMsgOnUI("Please check your internet connection!");
                }

            }
        });

        return rootView;

    }

    public Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/101458133519671")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://bit.ly/BigPotatoFB")); //catches and opens a url to the desired page
        }
    }


}
