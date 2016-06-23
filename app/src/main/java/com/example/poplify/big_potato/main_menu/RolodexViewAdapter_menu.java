package com.example.poplify.big_potato.main_menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.bucket_of_doom.Bod_homepage;
import com.example.poplify.big_potato.mr_lister.Mr_homepage;
import com.example.poplify.big_potato.obla.Obla_homapage;
import com.example.poplify.big_potato.ok_play.Ok_play_homescreen;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;
import com.example.poplify.big_potato.scrawl.Scraml_homepage;

/** A simple prototype for making an "infinite" scrolling rolodex-like view.
 *
 * It's current limitation is that user can only scroll INT_MAX / 2 in either direction. But, it
 * would take 248+ days of constant scrolling at 100 items per second, which would be very fast. */
public class RolodexViewAdapter_menu extends RecyclerView.Adapter<RolodexViewAdapter_menu.ViewHolder> {

    private int[] mDataset;
    SaveData save;
    Context contxt;
    Typeface regular, bold;
    // Provide a reference to the views for each data item.
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    public static class ViewHolder extends RecyclerView.ViewHolder {
       public ImageView menu,headtxt;
       public RelativeLayout card;
       public ImageView cross,main_pic;
       public GifView gif;
       public LinearLayout child_layout;
       public TextView txtListChild2,txtListChild3;
       public Button lets_go;


        public ViewHolder(View v) {
            super(v);
            menu = (ImageView) v.findViewById(R.id.info_text_menu);
            card = (RelativeLayout) v.findViewById(R.id.menu_main_back);
            cross = (ImageView) v.findViewById(R.id.imageView7cross);
            main_pic = (ImageView) v.findViewById(R.id.info_text_menu);
            gif = (GifView) v.findViewById(R.id.gifview);
            child_layout = (LinearLayout) v.findViewById(R.id.child_layout);
            headtxt = (ImageView) v.findViewById(R.id.lblListItem);
            txtListChild2 = (TextView) v.findViewById(R.id.textView10);
            txtListChild3 = (TextView) v.findViewById(R.id.textView11_tag);
            lets_go = (Button) v.findViewById(R.id.button2);


        }
    }

    // Provide a suitable constructor (depends on the kind of dataset).
    public RolodexViewAdapter_menu(int[] myDataset, Context cntxt) {
        mDataset = myDataset;
        contxt=cntxt;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rolodex_view_card_menu, parent, false);
        // Set the view's size, margins, paddings and layout parameters.
        save = new SaveData(contxt);
        regular = Typeface.createFromAsset(contxt.getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(contxt.getAssets(), "ufonts.com_interstate-bold.ttf");
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - Get element from your dataset at this position.
        // - Replace the contents of the view with that element.
        holder.menu.setImageResource(mDataset[position % mDataset.length]);

        Log.i("----","---"+position % mDataset.length);

        switch (position % mDataset.length)
        {
            case 0:
                holder.card.setBackgroundColor(Color.parseColor("#E6007E"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 1:
                holder.card.setBackgroundColor(Color.parseColor("#009FE3"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 2:
                holder.card.setBackgroundColor(Color.parseColor("#00AC13"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 3:
                holder.card.setBackgroundColor(Color.parseColor("#1A1A1A"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 4:
                holder.card.setBackgroundColor(Color.parseColor("#078489"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 5:
                holder.card.setBackgroundColor(Color.parseColor("#A765FF"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 6:
                holder.card.setBackgroundColor(Color.parseColor("#FFE00F"));
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
            case 7:
                holder.card.setBackgroundResource(R.mipmap.okplay_background);
                holder.cross.setVisibility(View.GONE);
                holder.gif.setVisibility(View.GONE);
                holder.main_pic.setVisibility(View.VISIBLE);
                holder.child_layout.setVisibility(View.GONE);
                break;
        }
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("pos","pos"+position % mDataset.length);

                switch (position % mDataset.length)
                {
                    case 0:

                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.bod_background);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setVisibility(View.VISIBLE);
                        holder.gif.setPaused(false);

                        holder.gif.setMovieResource(R.raw.bod_anim);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();
                        holder.headtxt.setImageResource(R.mipmap.bod_head);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("When the s**t hits the fan,\nyou need a plan.");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("Adult escape game");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 1:
                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.quordio_back);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setVisibility(View.VISIBLE);
                        holder.gif.setPaused(false);
                        holder.gif.setMovieResource(R.raw.qwordie_animation);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();
                        holder.headtxt.setImageResource(R.mipmap.quoride_head);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("If Scrabble and Trivial Pursuit \nhad a love child, this would be it.");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("Word game meets quiz game");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 2:
                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.scrawl_background);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setPaused(false);
                        holder.gif.setMovieResource(R.raw.scraw_animation);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();

                        holder.headtxt.setImageResource(R.mipmap.scrwal_head);
                        holder.gif.setVisibility(View.VISIBLE);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("Disastrous doodles and godawful \nguesses. Most grins wins.");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("Adult doodling game");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 3:
                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.rainbow_background);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setVisibility(View.VISIBLE);

                        holder.gif.setMovieResource(R.raw.rainbow_animation);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();
                        holder.gif.setPaused(false);
                        holder.headtxt.setImageResource(R.mipmap.rainbow_head);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("Think you know the seven colours \nin the rainbow? Not so fast.");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("Spot-the-difference game");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 4:
                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.mr_background);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setVisibility(View.VISIBLE);
                        holder.gif.setPaused(false);
                        holder.gif.setMovieResource(R.raw.mr_lister_anim);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();

                        holder.headtxt.setImageResource(R.mipmap.mr_lister_head);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("Like a Wile West shootout but \nwith brains for guns.");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("QUIZ PARTY GAME • 14+");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 5:
                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.obama_back);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setVisibility(View.VISIBLE);
                        holder.gif.setPaused(false);
                        holder.gif.setMovieResource(R.raw.obama_animation);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();

                        holder.headtxt.setImageResource(R.mipmap.obama_head);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("The rhyming charades game with \nthe strange sounding name.");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("Family rhyming game");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 6:
//                        holder.card.setBackgroundColor(0);
//                        holder.card.setBackgroundResource(R.mipmap.social_back);
//                        holder.cross.setVisibility(View.VISIBLE);
//                        holder.gif.setVisibility(View.VISIBLE);
//
//                        holder.gif.setMovieResource(R.raw.scraw_animation);
//                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
//                            public void onTick(long millisUntilFinished) {
//                            }
//                            public void onFinish() {
//                                holder.gif.setPaused(true);
//                            }
//                        }.start();
//
//                        holder.headtxt.setImageResource(R.mipmap.social_head);
//                        holder.main_pic.setVisibility(View.GONE);
//                        holder.child_layout.setVisibility(View.VISIBLE);
//                        holder.txtListChild2.setText("The rhyming charades game with \nthe strange sounding name.");
//                        holder.txtListChild2.setTypeface(regular);
//                        holder.txtListChild3.setText("PARTY GAME • 14+");
//                        holder.txtListChild3.setTypeface(regular);

                        break;
                    case 7:
                        holder.card.setBackgroundColor(0);
                        holder.card.setBackgroundResource(R.mipmap.okplay_drop_back);
                        holder.cross.setVisibility(View.VISIBLE);
                        holder.gif.setVisibility(View.VISIBLE);
                        holder.gif.setPaused(false);
                        holder.gif.setMovieResource(R.raw.ok_play);
                        new CountDownTimer(holder.gif.getMovie_duration(), holder.gif.getMovie_duration()) {
                            public void onTick(long millisUntilFinished) {
                            }
                            public void onFinish() {
                                holder.gif.setPaused(true);
                            }
                        }.start();

                        holder.headtxt.setImageResource(R.mipmap.scrwal_head);
                        holder.main_pic.setVisibility(View.GONE);
                        holder.child_layout.setVisibility(View.VISIBLE);
                        holder.txtListChild2.setText("Have game, will travel.Take it \nanywhere, play it with anyone");
                        holder.txtListChild2.setTypeface(regular);
                        holder.txtListChild3.setText("Travel tile game");
                        holder.txtListChild3.setTypeface(regular);

                        break;
                }

            }
        });

        holder.cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                switch (position % mDataset.length)
                {
                    case 0:
                        holder.card.setBackgroundColor(Color.parseColor("#E6007E"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 1:
                        holder.card.setBackgroundColor(Color.parseColor("#009FE3"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 2:
                        holder.card.setBackgroundColor(Color.parseColor("#00AC13"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 3:
                        holder.card.setBackgroundColor(Color.parseColor("#1A1A1A"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 4:
                        holder.card.setBackgroundColor(Color.parseColor("#078489"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 5:
                        holder.card.setBackgroundColor(Color.parseColor("#A765FF"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 6:
                        holder.card.setBackgroundColor(Color.parseColor("#FFE00F"));
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                    case 7:
                        holder.card.setBackgroundResource(R.mipmap.okplay_background);
                        holder.cross.setVisibility(View.GONE);
                        holder.gif.setVisibility(View.GONE);
                        holder.main_pic.setVisibility(View.VISIBLE);
                        holder.child_layout.setVisibility(View.GONE);
                        break;
                }

            }
        });


        holder.lets_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (position % mDataset.length) {

                    case 0:
                        save.save("current_game","BUCKET OF DOOM");
                        Intent b = new Intent(contxt, Bod_homepage.class);
                        b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        contxt.startActivity(b);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;

                    case 1:

                        save.save("current_game","QWORDIE");
                        Intent i = new Intent(contxt, Qwordie_activity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        contxt.startActivity(i);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 2:

                        save.save("current_game","SCRAWL");
                        Intent is = new Intent(contxt, Scraml_homepage.class);
                        is.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        is.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        contxt.startActivity(is);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 3:
                        save.save("current_game","RAINBOW");
                        Intent i1 = new Intent(contxt, RainbowRage.class);
                        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        contxt.startActivity(i1);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;

                    case 4:
                        save.save("current_game","MR LISTERS");
                        Intent bm = new Intent(contxt, Mr_homepage.class);
                        bm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        bm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        contxt.startActivity(bm);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 5:
                        save.save("current_game","OBLA");
                        Intent oko = new Intent(contxt, Obla_homapage.class);
                        oko.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        oko.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        contxt.startActivity(oko);
//                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                        break;
                    case 7:
                        save.save("current_game","OKPLAY");
                        Intent ok = new Intent(contxt, Ok_play_homescreen.class);
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

}
