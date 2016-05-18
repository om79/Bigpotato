package com.example.poplify.big_potato.adapters;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.main_menu.AnimatedExpandableListView;
import com.example.poplify.big_potato.qwordie.Qwordie_activity;

public class ExpandableListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

	private Context _context;
	private List<Integer> _listDataHeader; // header titles
	// child data in format of header title, child title
	private HashMap<Integer, List<String>> _listDataChild;

	public ExpandableListAdapter(Context context, List<Integer> listDataHeader,
			HashMap<Integer, List<String>> listChildData) {
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getRealChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		final String childText = (String) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_item, null);
		}

		TextView txtListChild = (TextView) convertView
				.findViewById(R.id.lblListItem);
		TextView txtListChild2 = (TextView) convertView
				.findViewById(R.id.textView10);
		LinearLayout layout = (LinearLayout) convertView
				.findViewById(R.id.child_layout);
		Button btn = (Button) convertView
				.findViewById(R.id.button2);

		StringTokenizer tokens = new StringTokenizer(childText, "|");

		final String text1 = tokens.nextToken();
		String text2 = tokens.nextToken();
		String color = tokens.nextToken();

		txtListChild.setText(text1);
		txtListChild2.setText(text2);
		layout.setBackgroundColor(Color.parseColor(color));


		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				switch (text1){

					case "QWORDIE":

						Intent i = new Intent (_context, Qwordie_activity.class);
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						_context.startActivity (i);
						break;
				}

			}
		});
		return convertView;
	}

	@Override
	public int getRealChildrenCount(int groupPosition) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this._listDataHeader.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this._listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		Integer headerTitle = (Integer) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_group, null);
		}

		ImageView lblListHeader = (ImageView) convertView
				.findViewById(R.id.lblListHeader);
//		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setImageResource(headerTitle);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
