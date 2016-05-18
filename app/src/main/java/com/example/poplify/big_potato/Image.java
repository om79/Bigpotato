package com.example.poplify.big_potato;

public class Image {

	
	public int image;
	public String title;

	public Image() {}

	public Image(int image,String title) {
		super();
		
		this.image = image;
		this.title = title;

		
		
	}
	
	
	
	
	public int getimage() {
		return image;
	}

	public void setimage(int image) {
		this.image = image;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}
	


}
