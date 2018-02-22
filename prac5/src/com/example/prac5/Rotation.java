package com.example.prac5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Button;

public class Rotation extends Activity  {
	Bitmap originalbitmap;
    String img;
    int id;
    ImageView imv;
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotation);
        imv = (ImageView)findViewById(R.id.imageR);
        id = getIntent().getExtras().getInt("image");
        imv.setImageResource(id);
        originalbitmap = ((BitmapDrawable)imv.getDrawable()).getBitmap();
        b = (Button)findViewById(R.id.rotate);
        b.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Matrix matrix = new Matrix();
	    		matrix.postRotate(90);
	    		Bitmap rotated = Bitmap.createBitmap(originalbitmap, 0, 0, originalbitmap.getWidth(), originalbitmap.getHeight(), matrix, false);
	    		imv.setImageBitmap(rotated);
			}
        });
    }
}
