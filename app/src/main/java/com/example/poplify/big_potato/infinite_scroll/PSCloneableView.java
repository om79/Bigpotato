package com.example.poplify.big_potato.infinite_scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


public abstract class PSCloneableView extends ImageView{

	public PSCloneableView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public PSCloneableView(Context context,AttributeSet attrs) {
		super(context,attrs);
		
		// TODO Auto-generated constructor stub
	}
	public abstract PSCloneableView clone();
}
