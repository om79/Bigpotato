package com.example.poplify.big_potato.bucket_of_doom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.Image;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by POPLIFY on 6/3/2016.
 */
public class Bod_scenario extends Activity
{

    EditText scenario,name,email;
    Button submit;
    ImageView back;
    Typeface regular,bold;
    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static final String URL="https://docs.google.com/forms/d/1r3aEsOUgJr44mTBx39FaMXimPvruGHk7LYdeFjj64aQ/formResponse";
    public static final String NAME_KEY="entry.499524383";
    public static final String SECINARIO_KEY="entry.243902145";
    public static final String EMAIL_KEY="entry.1153849184";
    PopupWindow pwindo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bod_scenario);

        scenario=(EditText) findViewById(R.id.editText3_scenario);
        name=(EditText) findViewById(R.id.editText_fullname);
        email=(EditText) findViewById(R.id.editText2emai);
        submit=(Button) findViewById(R.id.button_sbmit);
        back=(ImageView) findViewById(R.id.back_play_2_bos2);

        scenario.setTypeface(regular);
        name.setTypeface(regular);
        email.setTypeface(regular);
        submit.setTypeface(regular);


        regular= Typeface.createFromAsset(getAssets(), "Interstate-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(), "ufonts.com_interstate-bold.ttf");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
                startActivity(how23);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString()) ||
                        TextUtils.isEmpty(name.getText().toString()) ||
                        TextUtils.isEmpty(scenario.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"All fields are mandatory.",Toast.LENGTH_LONG).show();
                    return;
                }
                //Check if a valid email is entered
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                {
                    Toast.makeText(getApplicationContext(),"Please enter a valid email.",Toast.LENGTH_LONG).show();
                    return;
                }

                //Create an object for PostDataTask AsyncTask
                PostDataTask postDataTask = new PostDataTask();

                //execute asynctask
                postDataTask.execute(URL,name.getText().toString(),
                        email.getText().toString(),
                        scenario.getText().toString());
            }
        });

    }


    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Bod_scenario.this, AlertDialog.THEME_HOLO_DARK);
            dialog.setMessage("Please wait a moment");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String email = contactData[1];
            String subject = contactData[2];
            String message = contactData[3];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = NAME_KEY+"=" + URLEncoder.encode(email,"UTF-8") +
                        "&" + EMAIL_KEY + "=" + URLEncoder.encode(subject,"UTF-8") +
                        "&" + SECINARIO_KEY + "=" + URLEncoder.encode(message,"UTF-8");
            } catch (UnsupportedEncodingException ex) {
                result=false;
            }

            /*
            //If you want to use HttpRequest class from http://stackoverflow.com/a/2253280/1261816
            try {
			HttpRequest httpRequest = new HttpRequest();
			httpRequest.sendPost(url, postBody);
		}catch (Exception exception){
			result = false;
		}
            */

            try{
                //Create OkHttpClient for sending request
                OkHttpClient client = new OkHttpClient();
                //Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                //Send the request
                Response response = client.newCall(request).execute();
            }catch (IOException exception){
                result=false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
            //Print Success or failure message accordingly
            dialog.cancel();
            Toast.makeText(getApplicationContext(),result?"Message successfully sent!":"There was some error in sending message. Please try again after some time.", Toast.LENGTH_LONG).show();
            initiatePopupWindow();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
            startActivity(how23);
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    private void initiatePopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.thankyou_popup,
                    (ViewGroup) findViewById(R.id.popup_element_thnx));
            pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setOutsideTouchable(true);
            pwindo.setFocusable(true);

            final Button button = (Button) layout.findViewById(R.id.button_thnx);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    pwindo.dismiss();
                    Intent how23=new Intent(getApplicationContext(),Bod_homepage.class);
                    startActivity(how23);
                    overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

                    }



            });



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
