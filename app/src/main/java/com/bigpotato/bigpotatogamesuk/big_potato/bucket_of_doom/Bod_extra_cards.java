package com.bigpotato.bigpotatogamesuk.big_potato.bucket_of_doom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.Image;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.ImageAdapter;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.UsefullData;

import java.util.ArrayList;

/**
 * Created by POPLIFY on 6/2/2016.
 */
public class Bod_extra_cards extends Activity
{
    GridView gv;
    ImageView back;
    ImageAdapter image_adapter;
    SaveData save_data;
    UsefullData usefull;
    String[] ques={ "In a feat of extraordinary bad timing, you’ve got your head stuck in the train doors. The train moves off… straight for a tunnel.",
            "Scuba diving, you spot a massive pearl. You go to grab it and the giant clam slams shut, trapping you inside.",
            "Halfway through your much-needed nose job, the anaesthetic wears off. You come round just as the surgeon is firing up the bone saw.",
            "Against advice, you start fracking the land underneath you. Instead of finding gold, you find a sinkhole, which starts to quickly swallow your house.",
            "The sushi-making course you signed up for turned out to be for Sumo wrestling (your Japanese isn't great). You're tossed into the ring where the 360lb champ is waiting.",
            "North Korea. You drunkenly tell your wife how you think Kim Jong-Un's haircut is a bit shit. She immediately reports you to the authorities. ",
            "To avoid jail, you plead insanity. They throw you in the mad house and mark you down for a Monday morning lobotomy.",
            "Off hunting with an Amazonian tribe, you raise the blowpipe to your lips, take a deep breath and… shit! You’ve inhaled the dart laced with frog poison!",
            "You’re a snake charmer, playing ‘Careless Whisper’ on your flute. Unfortunately, this snake absolutely hates George Michael and lunges straight at you.",
            "Filming a documentary on wolves, you're deep undercover. Your wolf disguise is so effective that the alpha male mounts you, barbed penis at the ready.",
            "Running through the jungle, you trip and fall into a giant spider web. An evil-looking spider scuttles towards your face, fangs dripping with venom.",
            "Your Scientology mentor just told you about the alien overlord Xenu. You start to laugh, when the door opens and an angry 12ft alien starts melting your mind.",
            "You've taken a gap year and become an eco-warrior, chaining yourself to the top of a tree in the Amazon jungle. The loggers are sawing it down.",
            "Lost in a putrid swamp, you're knocked unconcious by the terrible smell. When you wake you're covered in blood-sucking leeches that are sucking you dry.",
            "What a bummer, Earth is being sucked into a black hole.",
            "You invent a time machine. You visit your parents when they are courting and inadvertently split them up.",
            "You're a gallant knight at a medieval jousting tournament. As you charge towards Sir FuckYouUp, you drop your lance.",
            "You're jumping the Grand Canyon on a motorbike in a misguided attempt to impress your rebellious kids, when both your wheels fall off in mid-air.",
            "Good news: your parachute didn't open but you survived the fall. Bad news: you've landed in quicksand.",
            "You're hurtling down a water flume in your Speedos when a section of pipe falls off ahead of you."

    };

    ArrayList<Image> actorsList=null;

    Typeface regular,bold;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bod_extra_cards);

        usefull=new UsefullData(getApplicationContext());
        save_data=new SaveData(Bod_extra_cards.this);
        gv = (GridView) findViewById(R.id.gridView_bod_extra);
        back = (ImageView) findViewById(R.id.back_bod_extra);

        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        actorsList=new ArrayList<Image>();
        image_adapter = new ImageAdapter(Bod_extra_cards.this, R.layout.rowhome_bod, actorsList);
        new set_images().execute();
        gv.setAdapter(image_adapter);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerOfSound();
                finish();
//                Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
//                startActivity(how23);
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

//                usefull.trimCache(getApplicationContext());
                save_data.save("bod"+position,position);

                Intent b= new Intent(Bod_extra_cards.this,Bod_cards.class);
                b.putExtra("data",ques[position]);
                startActivity(b);


            }
        });






    }

    @Override
    protected void onResume() {
        new set_images().execute();
        super.onResume();
    }

    @Override
    protected void onPause() {
        new set_images().execute();
        super.onPause();
    }


    @Override
    public void onBackPressed() {
        // your code.
        managerOfSound();
        finish();
//        Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
//        startActivity(how23);
//        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            managerOfSound();
            finish();
//            Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
//            startActivity(how23);
//            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    class set_images extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        protected void onPreExecute()
        {
            actorsList.clear();
            dialog = new ProgressDialog(Bod_extra_cards.this, AlertDialog.THEME_HOLO_DARK);
            dialog.setMessage("Please wait a moment");
            dialog.show();
            dialog.setCancelable(false);

        }
        protected Void doInBackground(Void... arg0) {
            for (int i = 0; i < 20; i++) {
                Image actor = new Image();

                if(save_data.isExist("bod"+i)==true)
                {
                    actor.setimage(R.mipmap.bod_open_card);
                    actor.settitle(ques[i]);

                }else {
                    actor.setimage(R.mipmap.bod_cardface_down);
                    actor.settitle("");
                }
                actorsList.add(actor);
            }


            return null;
        }
        protected void onPostExecute(Void result)
        {
            dialog.cancel();
            image_adapter.notifyDataSetChanged();
        }

    }


    private void managerOfSound() {

        MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.back_button);
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

