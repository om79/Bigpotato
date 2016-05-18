package com.example.poplify.big_potato;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.poplify.big_potato.R;

public class ImageAdapter extends ArrayAdapter<Image> {
	ArrayList<Image> actorList;
	
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;

	

	public ImageAdapter(Context context, int resource, ArrayList<Image> objects) {
		super(context, resource, objects);
		vi = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Resource = resource;
		actorList = objects;
		
		
		
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