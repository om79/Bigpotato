package com.example.poplify.big_potato.recycle_view_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

/** A simple prototype for making an "infinite" scrolling rolodex-like view.
 *
 * It's current limitation is that user can only scroll INT_MAX / 2 in either direction. But, it
 * would take 248+ days of constant scrolling at 100 items per second, which would be very fast. */
public class RolodexViewAdapter extends RecyclerView.Adapter<RolodexViewAdapter.ViewHolder> {

    private int[] mDataset;
    private String[] value;
    Context cntxt;
    String game;
    SaveData save;
    // Provide a reference to the views for each data item.
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    public static class ViewHolder extends RecyclerView.ViewHolder {
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
        holder.mimgView.setPadding(0,0,0,0);
        if(game.equals(value[position% mDataset.length]))
        {
            holder.mimgView.setPadding(5,5,5,5);
        }


        holder.mimgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (value[position% mDataset.length])
                {
                    case "bod":
                        save.save("current_game","BUCKET OF DOOM");
                        Intent ib = new Intent(cntxt, Bod_homepage.class);
                        ib.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ib.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(ib);

                        break;
                    case "qworide":
                        save.save("current_game","QWORDIE");
                        Intent i = new Intent(cntxt, Qwordie_activity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(i);
                        break;
                    case "scrwal":

                        save.save("current_game","SCRAWL");
                        Intent ios = new Intent(cntxt, Scraml_homepage.class);
                        ios.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ios.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(ios);

                        break;
                    case "rainbow":
                        save.save("current_game","RAINBOW");
                        Intent ir = new Intent(cntxt, RainbowRage.class);
                        ir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ir.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(ir);

                        break;
                    case "mr_lister":

                        save.save("current_game","MR LISTERS");
                        Intent im = new Intent(cntxt, Mr_homepage.class);
                        im.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        im.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(im);
                        break;
                    case "obama":

                        save.save("current_game","OBLA");
                        Intent iob = new Intent(cntxt, Obla_homapage.class);
                        iob.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        iob.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(iob);

                       break;
                    case "social":

                        Toast.makeText(cntxt,"Coming soon !",Toast.LENGTH_SHORT).show();
                        break;
                    case "ok_play":
                        save.save("current_game","OKPLAY");
                        Intent io = new Intent(cntxt, Ok_play_homescreen.class);
                        io.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        io.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        cntxt.startActivity(io);

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
