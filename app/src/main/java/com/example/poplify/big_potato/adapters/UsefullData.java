package com.example.poplify.big_potato.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.poplify.big_potato.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class UsefullData  {

	private Context _context;
	private ProgressDialog pDialog;
	static boolean SHOW_LOG=true;
	public static int NOTIFYONOFF = 1;
	PopupWindow pwindo;
//	Animation rotation;
	public UsefullData(Context c) {
		_context = c;
	}

	// ================== DEVICE INFORMATION ============//

	public static String getCountryCodeFromDevice() {
		String countryCode = Locale.getDefault().getCountry();
		if (countryCode.equals("")) {
			countryCode = "IN";
		}
		return countryCode;
	}

	// ================== CREATE FILE AND RELATED ACTION ============//

	public File getRootFile() {

		File f = new File(Environment.getExternalStorageDirectory(), _context
				.getString(R.string.app_name).toString());
		if (!f.isDirectory()) {
			f.mkdirs();
		}

		return f;
	}

	public void deleteRootDir(File root) {

		if (root.isDirectory()) {
			String[] children = root.list();
			for (int i = 0; i < children.length; i++) {
				File f = new File(root, children[i]);
				Log("file name:" + f.getName());
				if (f.isDirectory()) {
					deleteRootDir(f);
				} else {
					f.delete();
				}
			}
		}
	}

	// ================ DOWNLOAD ============================//

	public void downloadAndDisplayImage(final String image_url,
			final ImageView v, int type) {

		new Thread() {

			public void run() {
				try {

					InputStream in = new URL(image_url).openConnection()
							.getInputStream();
					Bitmap bm = BitmapFactory.decodeStream(in);
					File fileUri = new File(getRootFile(),
							getNameFromURL(image_url));
					FileOutputStream outStream = null;
					outStream = new FileOutputStream(fileUri);
					bm.compress(Bitmap.CompressFormat.JPEG, 75, outStream);
					outStream.flush();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					File f = new File(getRootFile(), "aa.jpg");
					if (f.exists()) {
						final Bitmap bmp = BitmapFactory
								.decodeFile(f.getPath());

						v.post(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								v.setImageBitmap(bmp);
							}
						});

						Log("download images and showing ,,,,");

					}
				}
			}

		}.start();
	}

	public String getNameFromURL(String url) {

		String fileName = "item_image.jpg";
		if (url != null) {
			fileName = url.substring(url.lastIndexOf('/') + 1, url.length());
		}
		return fileName;
	}

	// ================== LOG AND TOAST====================//

	public static void Log(final String msg) {

		if (SHOW_LOG) {
			Log.e("LOG_TAG", msg);
		}

	}

	public void showMsgOnUI(final String msg) {
		((Activity) _context).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				Toast.makeText(_context, msg, Toast.LENGTH_SHORT).show();

			}
		});

	}

	// =================== INTERNET ===================//
	public boolean isNetworkConnected() {
		ConnectivityManager cm = (ConnectivityManager) _context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			return false;
		} else
			return true;
	}

	// ==================== PROGRESS DIALOG ==================//

	public void showProgress(final String msg, final String title) {
		pDialog = ProgressDialog.show(_context, title, msg, true);

	}

	public void dismissProgress() {
		if (pDialog != null) {
			if (pDialog.isShowing()) {
				pDialog.cancel();
				pDialog = null;
			}
		}

	}

	// ====================SET FONT SIZE==================//
	public Typeface getUsedFont() {
		Typeface raleway_font = Typeface.createFromAsset(_context.getAssets(),
				"fonts/Viro.otf");
		return raleway_font;
	}
	
	public Typeface getTopUsedFont() {
		Typeface raleway_font = Typeface.createFromAsset(_context.getAssets(),
				"fonts/SweetPineapple.otf");
		return raleway_font;
	}

	public Typeface getUsedFontArial() {
		Typeface typeFace = Typeface.createFromAsset(_context.getAssets(),
				"fonts/arial.ttf");
		return typeFace;
	}

	
	public Typeface getUsedFontRobot() {
		Typeface typeFace = Typeface.createFromAsset(_context.getAssets(),
				"fonts/roboto/Roboto-Regular.ttf");
		return typeFace;
	}

	
	public File createFile(String fileName) {
		File f = null;
		try {
			f = new File(getRootFile(), fileName);
			if (f.exists()) {
				f.delete();
			}

			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public static String getLocation(Context context, double latitude,
			double longitude) throws IOException {

		String address;
		String city;
		String country;

		try {
			Geocoder geocoder;
			List<Address> addresses;
			geocoder = new Geocoder(context, Locale.getDefault());
			addresses = geocoder.getFromLocation(latitude, longitude, 1);

			address = addresses.get(0).getAddressLine(0);
			city = addresses.get(0).getAddressLine(1);
			country = addresses.get(0).getAddressLine(2);

		} catch (Exception e) {
			address = "";
			city = "";
			country = "";
		}
		return address + ", " + city;
	}

	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
		// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		// sdf.applyPattern("dd MMM yyyy");
		String strDate = sdf.format(cal.getTime());
		return strDate;
	}

	public void showpopup() {
		((Activity) _context).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				try {
					// We need to get the instance of the LayoutInflater
//					rotation = AnimationUtils.loadAnimation(_context, R.anim.rotate);
					LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					View layout = inflater.inflate(R.layout.popup_view_buy,null,false);
					pwindo = new PopupWindow(layout, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT, true);
					pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
					pwindo.setOutsideTouchable(false);

					pwindo.setFocusable(true);
					final  RelativeLayout anim = (RelativeLayout) layout.findViewById(R.id.buy_layout_popup);
					Button no = (Button) layout.findViewById(R.id.button_no);
					no.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
//							anim.startAnimation(rotation);
							pwindo.dismiss();
						}
					});

					Button yes = (Button) layout.findViewById(R.id.button_yes);
					yes.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
//							anim.startAnimation(rotation);
							Intent i = new Intent(Intent.ACTION_VIEW);
							i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							i.setData(Uri.parse("http://www.google.com"));
							_context.startActivity(i);
							pwindo.dismiss();

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}





	public static void trimCache(Context context) {
		try {
			File dir = context.getCacheDir();
			if (dir != null && dir.isDirectory()) {
				deleteDir(dir);
			}
		} catch (Exception e) {
// TODO: handle exception
		}
	}

	public static boolean deleteDir(File dir) {
		if (dir != null && dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;

				}
			}
		}

// The directory is now empty so delete it
		return dir.delete();
	}


}
