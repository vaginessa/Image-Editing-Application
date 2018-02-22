package com.example.prac5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class GalleryImageAdapter extends BaseAdapter {
	Context mContext;
	public Integer [] imageId = {R.drawable.i1 , R.drawable.i2 , R.drawable.i3 , R.drawable.i4};
	
	GalleryImageAdapter(Context context){
		mContext = context;
	}
	public View getView(int index,View view,ViewGroup viewgroup){
		ImageView i = new ImageView(mContext);
		i.setImageResource(imageId[index]);
		i.setLayoutParams(new Gallery.LayoutParams(200,200));
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		return i;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageId.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	
}
