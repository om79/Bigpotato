package com.bigpotato.bigpotatogamesuk.big_potato.main_menu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.ConnectionDetector;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesuk.big_potato.hompage.Home_page;

import com.flurry.android.FlurryAgent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by POPLIFY on 5/18/2016.
 */
 public class Game_menu extends Activity {

//    UsefullData usefull;
    SaveData save;
    Typeface regular, bold;
    String key="PMQZP7M6VPRVMN9Q6DW8";
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    List<Data> data;
//    MediaPlayer mp;
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
//        usefull = new UsefullData(getApplicationContext());
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

        data.add(new Data(R.mipmap.bod, Color.parseColor("#E6007E")));
        data.add(new Data(R.mipmap.mr_lister, Color.parseColor("#078489")));
        data.add(new Data(R.mipmap.scrawl, Color.parseColor("#AD6DFF")));
        data.add(new Data(R.mipmap.obamallama, Color.parseColor("#8ABE00")));
        data.add(new Data(R.mipmap.qwordie,Color.parseColor("#009FE3")));
        data.add(new Data(R.mipmap.rainbow_rage,Color.parseColor("#1A1A1A")));
        data.add(new Data(R.mipmap.okplay_background,R.mipmap.okplay_background));
        data.add(new Data(R.mipmap.social,Color.parseColor("#FFE00F")));
        data.add(new Data(R.mipmap.umm_back,R.mipmap.umm_back));

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
        private int expand_pos;
        boolean expand_mode=false;
        int i=0;
        public GifDrawable gifFromResource=null;

        boolean expanded_0=false,expanded_1=false,expanded_2=false,expanded_3=false,expanded_4=false,expanded_5=false,expanded_6=false;

        // Provide a reference to the views for each data item.
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        public  class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView menu,headtxt,umm_cross;
            public RelativeLayout card;
            public ImageView cross,umm_app_link;
            public GifImageView gif;
            public LinearLayout gif_back;
            public LinearLayout child_layout;
            public TextView txtListChild2,txtListChild3;
            public Button lets_go;

            public RelativeLayout umm,social,social_cross,facebook,instgram,twitter,snapchat,mail,news;


            public ViewHolder(View v) {
                super(v);
                menu = (ImageView) v.findViewById(R.id.info_text_menu);
                card = (RelativeLayout) v.findViewById(R.id.menu_main_back);
                cross = (ImageView) v.findViewById(R.id.imageView7cross);
                umm_app_link = (ImageView) v.findViewById(R.id.imageView22);
                umm_cross = (ImageView) v.findViewById(R.id.imageView23_umm);

                gif = (GifImageView) v.findViewById(R.id.gifview);
                gif_back = (LinearLayout) v.findViewById(R.id.gif_back);
                child_layout = (LinearLayout) v.findViewById(R.id.child_layout);
                headtxt = (ImageView) v.findViewById(R.id.lblListItem);
                txtListChild2 = (TextView) v.findViewById(R.id.textView10);
                txtListChild3 = (TextView) v.findViewById(R.id.textView11_tag);
                lets_go = (Button) v.findViewById(R.id.button2);
                umm= (RelativeLayout) v.findViewById(R.id.umm_layout);
                social= (RelativeLayout) v.findViewById(R.id.social_layout);
                social_cross= (RelativeLayout) v.findViewById(R.id.social_cross);

                facebook= (RelativeLayout) v.findViewById(R.id.facebook);
                instgram= (RelativeLayout) v.findViewById(R.id.instagram);
                twitter= (RelativeLayout) v.findViewById(R.id.twitter);
                snapchat= (RelativeLayout) v.findViewById(R.id.snapchat);
                mail= (RelativeLayout) v.findViewById(R.id.mail);
                news= (RelativeLayout) v.findViewById(R.id.news);



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

            expanded_0=false;
            expanded_1=false;
            expanded_2=false;
            expanded_3=false;
            expanded_4=false;
            expanded_5=false;
            expanded_6=false;
//            holder.gif.reset();
            Log.i("---","---position--call---"+position % list.size());
            Log.i("---","---expand_mode---"+expand_mode);
            Log.i("---","---i---"+i);
            if(i>8){
                expand_mode=false;
                i=0;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
            holder.umm.setVisibility(View.GONE);
            holder.social.setVisibility(View.GONE);
            holder.child_layout.setVisibility(View.GONE);
            if(!expand_mode) {
                holder.menu.setVisibility(View.VISIBLE);
                holder.gif.setVisibility(View.GONE);
                holder.cross.setVisibility(View.GONE);
                switch (position % list.size()) {
                    case 6:
                        holder.menu.setImageResource(list.get(position % list.size()).header_img);
                        holder.card.setBackgroundResource(list.get(position % list.size()).title_img);
                        break;
                    case 8:
                        holder.menu.setImageResource(list.get(position % list.size()).header_img);
                        holder.card.setBackgroundResource(list.get(position % list.size()).title_img);
                        break;
                    default:
                        holder.menu.setImageResource(list.get(position % list.size()).header_img);
                        holder.card.setBackgroundColor(list.get(position % list.size()).title_img);
                        break;
                }
            }else {
                i++;

                holder.menu.setVisibility(View.GONE);
                holder.card.setBackgroundColor(0);
                if(expand_pos==position % list.size()) {
                    switch (position % list.size()) {
                        case 0:
                            if (!expanded_0) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.bod_background);
                                holder.cross.setVisibility(View.VISIBLE);
                                holder.gif.setVisibility(View.VISIBLE);
                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.bod_anim );

                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                managerOfSound(R.raw.bod_sound);
                                holder.headtxt.setImageResource(R.mipmap.bod_head);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("When the s**t hits the fan,\nyou need a plan.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Adult escape game");
                                holder.txtListChild3.setTypeface(regular);
                                holder.umm.setVisibility(View.GONE);

                            }
                            expanded_0 = true;
                            break;
                        case 4:
                            if (!expanded_4) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.quordio_back);
                                holder.cross.setVisibility(View.VISIBLE);
                                holder.gif.setVisibility(View.VISIBLE);

//                                holder.gif.setMovieResource(R.raw.qwordie_animation);
                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.qwordie_animation );
                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                managerOfSound(R.raw.qworide_sound);
                                holder.headtxt.setImageResource(R.mipmap.quoride_head);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("If Scrabble and Trivial Pursuit \nhad a love child, it would be Qwordie.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Word game meets quiz game");
                                holder.txtListChild3.setTypeface(regular);
                                holder.umm.setVisibility(View.GONE);

                            }
                            expanded_4 = true;
                            break;
                        case 2:

                            if (!expanded_2) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.obama_back);
                                holder.cross.setVisibility(View.VISIBLE);

//                                holder.gif.setMovieResource(R.raw.scraw_animation);
                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.scraw_animation );
                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                managerOfSound(R.raw.scrwal_sound);
                                holder.headtxt.setImageResource(R.mipmap.scrwal_head);
                                holder.gif.setVisibility(View.VISIBLE);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("Disastrous doodles and godawful \nguesses. Most grins wins.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Adult doodling game");
                                holder.txtListChild3.setTypeface(regular);
                                holder.umm.setVisibility(View.GONE);

                            }
                            expanded_2 = true;
                            break;
                        case 5:

                            if (!expanded_5) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.rainbow_background);
                                holder.cross.setVisibility(View.VISIBLE);
                                holder.gif.setVisibility(View.VISIBLE);

//                                holder.gif.setMovieResource(R.raw.rainbow_animation);
                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.rainbow_animation );
                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                managerOfSound(R.raw.rainbow_sound);
                                holder.headtxt.setImageResource(R.mipmap.rainbow_head);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("Think you know the seven colours \nin the rainbow? Not so fast.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Spot-the-difference game");
                                holder.txtListChild3.setTypeface(regular);
                                holder.umm.setVisibility(View.GONE);

                            }
                            expanded_5 = true;
                            break;
                        case 1:

                            if (!expanded_1) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.mr_background);
                                holder.cross.setVisibility(View.VISIBLE);
                                managerOfSound(R.raw.mr_lister_sound);
                                holder.gif.setVisibility(View.VISIBLE);

//                                holder.gif.setMovieResource(R.raw.mr_lister_anim);

                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.mr_lister_anim );
                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                holder.headtxt.setImageResource(R.mipmap.mr_lister_head);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("Like a Wild West shootout but \nwith brains for guns.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Family trivia game");
                                holder.txtListChild3.setTypeface(regular);
                                holder.umm.setVisibility(View.GONE);

                            }
                            expanded_1 = true;

                            break;
                        case 3:

                            if (!expanded_3) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.scrawl_background);
                                holder.cross.setVisibility(View.VISIBLE);
                                holder.gif.setVisibility(View.VISIBLE);

//                                holder.gif.setMovieResource(R.raw.obama_animation);
                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.obama_animation );
                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                managerOfSound(R.raw.obla_sound);
                                holder.headtxt.setImageResource(R.mipmap.obama_head);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("The rhyming charades game with \nthe strange sounding name.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Family rhyming game");
                                holder.txtListChild3.setTypeface(regular);
                                holder.umm.setVisibility(View.GONE);

                            }
                            expanded_3 = true;
                            break;
                        case 7:
                            holder.menu.setVisibility(View.GONE);
                            holder.social.setVisibility(View.VISIBLE);
                            break;
                        case 6:

                            if (!expanded_6) {

                                expand(holder.child_layout);

                                holder.card.setBackgroundResource(R.mipmap.okplay_drop_back);
                                holder.cross.setVisibility(View.VISIBLE);
                                holder.gif.setVisibility(View.VISIBLE);

//                                holder.gif.setMovieResource(R.raw.ok_play);
                                try {
                                     gifFromResource = new GifDrawable( getApplicationContext().getResources(), R.raw.ok_play );
                                    holder.gif.setImageDrawable(gifFromResource);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                managerOfSound(R.raw.okplay_sound);
                                holder.headtxt.setImageResource(R.mipmap.ok_play_head);

                                holder.child_layout.setVisibility(View.VISIBLE);
                                holder.txtListChild2.setText("Have game, will travel. Take it \nanywhere, play it with anyone.");
                                holder.txtListChild2.setTypeface(regular);
                                holder.txtListChild3.setText("Travel tile game");
                                holder.txtListChild3.setTypeface(regular);


                            }
                            expanded_6 = true;
                            break;
                        case 8:
                            holder.menu.setVisibility(View.GONE);
                            holder.umm.setVisibility(View.VISIBLE);
                            break;


                    }
                }else{
                    holder.menu.setVisibility(View.VISIBLE);
                    switch (position % list.size()) {


                        case 6:
                            holder.menu.setImageResource(list.get(position % list.size()).header_img);
                            holder.card.setBackgroundResource(list.get(position % list.size()).title_img);
                            holder.cross.setVisibility(View.GONE);
                            holder.gif.setVisibility(View.GONE);

                            break;
                        case 8:
                            holder.menu.setImageResource(list.get(position % list.size()).header_img);
                            holder.card.setBackgroundResource(list.get(position % list.size()).title_img);
                            holder.cross.setVisibility(View.GONE);
                            holder.gif.setVisibility(View.GONE);

                            break;
                        default:
                            holder.menu.setImageResource(list.get(position % list.size()).header_img);
                            holder.card.setBackgroundColor(list.get(position % list.size()).title_img);
                            holder.cross.setVisibility(View.GONE);
                            holder.gif.setVisibility(View.GONE);

                            break;


                    }
                }

            }
        }
    });

            holder.menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            i=0;
                            Log.i("---","---click--positon---"+position % list.size());
                            expand_mode = true;
                            expand_pos = position % list.size();
//                            holder.gif.reset();
                            if(gifFromResource!=null) {
                                gifFromResource.recycle();
                            }
                            notifyDataSetChanged();

                        }
                    });
                }

            });



            holder.cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    expanded_0=false;
                    expanded_1=false;
                    expanded_2=false;
                    expanded_3=false;
                    expanded_4=false;
                    expanded_5=false;
                    expanded_6=false;
//                    holder.gif.reset();
                    expand_mode = false;
                    notifyDataSetChanged();

                }


            });


            holder.umm_cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.umm.setVisibility(View.GONE);
                    expanded_0=false;
                    expanded_1=false;
                    expanded_2=false;
                    expanded_3=false;
                    expanded_4=false;
                    expanded_5=false;
                    expanded_6=false;
//                    holder.gif.reset();
                    expand_mode = false;
                    notifyDataSetChanged();

                }
            });
            holder.social_cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.social.setVisibility(View.GONE);
                    expanded_0=false;
                    expanded_1=false;
                    expanded_2=false;
                    expanded_3=false;
                    expanded_4=false;
                    expanded_5=false;
                    expanded_6=false;
//                    holder.gif.reset();
                    expand_mode = false;
                    notifyDataSetChanged();

                }
            });
            holder.facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("-----","---click---");
                    if(isInternetPresent) {

                        FlurryAgent.logEvent("Facebook");
                    }
                    Intent facebookIntent = getOpenFacebookIntent(contxt);
                    facebookIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    contxt.startActivity(facebookIntent);
                }
            });
            holder.umm_app_link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("-----","---click---");
                    if(isInternetPresent) {

                        FlurryAgent.logEvent("Umm");
                    }
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.bigpotato.umm&hl=en"));
                    contxt.startActivity(i);
                }
            });

            holder.instgram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("-----","---click---");
                    try {
                        // mediaLink is something like "https://instagram.com/p/6GgFE9JKzm/" or
                        // "https://instagram.com/_u/sembozdemir"
                        if(isInternetPresent) {

                            FlurryAgent.logEvent("Instagram");
                        }
                        Uri uri = Uri.parse("instagram://user?username=bigpotatogames");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setPackage("com.instagram.android");
                        contxt.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e("TAG", e.getMessage());
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.setData(Uri.parse("http://bit.ly/BigPotatoInsta"));
                        contxt.startActivity(i);
                    }
                }
            });
            holder.twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        // mediaLink is something like "https://instagram.com/p/6GgFE9JKzm/" or
                        // "https://instagram.com/_u/sembozdemir"
                        if(isInternetPresent) {

                            FlurryAgent.logEvent("Twitter");
                        }
                        Uri uri = Uri.parse("twitter://user?screen_name=bigpotatogames");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setPackage("com.twitter.android");
                        contxt.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e("TAG", e.getMessage());
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.setData(Uri.parse("http://bit.ly/BigPotatoTw"));
                        contxt.startActivity(i);
                    }
                }
            });
            holder.snapchat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        // mediaLink is something like "https://instagram.com/p/6GgFE9JKzm/" or
                        // "https://instagram.com/_u/sembozdemir"
                        if(isInternetPresent) {

                            FlurryAgent.logEvent("Snapchat");
                        }
                        Uri uri = Uri.parse("snapchat://BigPotatoSnap");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setPackage("com.snapchat.android");
                        contxt.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e("TAG", e.getMessage());
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.setData(Uri.parse("http://bit.ly/BigPotatoSnap"));
                        contxt.startActivity(i);
                    }
                }
            });
            holder.mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    sendEmail();
                }
            });
            holder.news.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.setData(Uri.parse("http://bigpotato.co.uk/newsletter-signup"));
                    contxt.startActivity(i);
                }
            });
            holder.lets_go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    managerOfSound(R.raw.main_button);
                    switch (position% list.size()) {

                        case 0:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("Bucket of Doom");
                            }
                            save.save("current_game","BUCKET OF DOOM");
                            Intent b = new Intent(contxt, Home_page.class);
                            b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(b);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;

                        case 4:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("Qwordie");
                            }
                            save.save("current_game","QWORDIE");
                            Intent i = new Intent(contxt, Home_page.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(i);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case 2:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("Scrawl");
                            }
                            save.save("current_game","SCRAWL");
                            Intent is = new Intent(contxt, Home_page.class);
                            is.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            is.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(is);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case 5:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("Rainbow Rage");
                            }
                            save.save("current_game","RAINBOW");
                            Intent i1 = new Intent(contxt, Home_page.class);
                            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(i1);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;

                        case 1:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("Mr Lister's Quiz shootout");
                            }
                            save.save("current_game","MR LISTERS");
                            Intent bm = new Intent(contxt, Home_page.class);
                            bm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            bm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(bm);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case 3:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("Obama llama");
                            }
                            save.save("current_game","OBLA");
                            Intent oko = new Intent(contxt, Home_page.class);
                            oko.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            oko.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(oko);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                            break;
                        case 6:
                            if(isInternetPresent) {

                                FlurryAgent.logEvent("okplay");
                            }
                            save.save("current_game","OKPLAY");
                            Intent ok = new Intent(contxt, Home_page.class);
                            ok.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            ok.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            contxt.startActivity(ok);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
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




        public  Intent getOpenFacebookIntent(Context context) {

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



        private void sendEmail() {
            Intent intent = new Intent(Intent.ACTION_SENDTO)
                    .setData(new Uri.Builder().scheme("mailto").build())

                    .putExtra(Intent.EXTRA_EMAIL, new String[]{ "BigPotatoGames <hello@bigpotato.co.uk>" })
                    .putExtra(Intent.EXTRA_SUBJECT, "BigPotatoGames")
                    .putExtra(Intent.EXTRA_TEXT, "Talk to the tatos")
                    ;

            ComponentName emailApp = intent.resolveActivity(contxt.getPackageManager());
            ComponentName unsupportedAction = ComponentName.unflattenFromString("com.android.fallback/.Fallback");
            if (emailApp != null && !emailApp.equals(unsupportedAction))
                try {
                    // Needed to customise the chooser dialog title since it might default to "Share with"
                    // Note that the chooser will still be skipped if only one app is matched
                    Intent chooser = Intent.createChooser(intent, "Send email with");
                    chooser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    contxt.startActivity(chooser);
                    return;
                }
                catch (ActivityNotFoundException ignored) {
                }

            Toast
                    .makeText(contxt, "Couldn't find an email app", Toast.LENGTH_LONG)
                    .show();
        }




        public  void expand(final View v) {
            v.measure(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
            final int targetHeight = v.getMeasuredHeight();

            // Older versions of android (pre API 21) cancel animations for views with a height of 0.
            v.getLayoutParams().height = 1;
            v.setVisibility(View.VISIBLE);
            Animation a = new Animation()
            {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    v.getLayoutParams().height = interpolatedTime == 1
                            ? RecyclerView.LayoutParams.WRAP_CONTENT
                            : (int)(targetHeight * interpolatedTime);
                    v.requestLayout();
                }

                @Override
                public boolean willChangeBounds() {
                    return true;
                }
            };

            // 1dp/ms
//            a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
          a.setDuration(400);
            v.startAnimation(a);
        }




        private void managerOfSound(int sound) {

            MediaPlayer mp= MediaPlayer.create(contxt, sound);
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






}
