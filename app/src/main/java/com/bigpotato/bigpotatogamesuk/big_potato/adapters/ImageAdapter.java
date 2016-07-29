package com.bigpotato.bigpotatogamesuk.big_potato.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigpotato.bigpotatogamesuk.big_potato.R;

public class ImageAdapter extends ArrayAdapter<Image> {
	ArrayList<Image> actorList;
	Typeface regular,bold;
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;
	Context c;

	

	public ImageAdapter(Context context, int resource, ArrayList<Image> objects) {
		super(context, resource, objects);
		vi = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Resource = resource;
		actorList = objects;
		c=context;

		
		
	}
 
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// convert view = design
		View v = convertView;
		if (v == null) {
			holder = new ViewHolder();
			v = vi.inflate(Resource, null);
			holder.imageview = (ImageView) v.findViewById(R.id.imgcross);
			holder.textView = (TextView) v.findViewById(R.id.textView_question);
			regular= Typeface.createFromAsset(c.getAssets(), "Interstate-Regular.ttf");
			bold = Typeface.createFromAsset(c.getAssets(), "ufonts.com_interstate-bold.ttf");

			holder.textView.setTypeface(regular);
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}
		holder.imageview.setImageResource(actorList.get(position).getimage());
		holder.textView.setText(actorList.get(position).gettitle());
		
		
		return v;

	}

	static class ViewHolder {
		public ImageView imageview;
		public TextView textView;


	}



	
}