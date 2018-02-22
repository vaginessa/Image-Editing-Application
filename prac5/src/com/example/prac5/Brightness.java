package com.example.prac5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Brightness extends Activity{
    Intent i;
    Bitmap originalbitmap;
    String img;
    int id;
    ImageView imv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brightness);
        imv = (ImageView)findViewById(R.id.imageE);
        id = getIntent().getExtras().getInt("image");
        imv.setImageResource(id);

        SeekBar sbarbrightness = (SeekBar)findViewById(R.id.seekBar1);
        sbarbrightness.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                // TODO Auto-generated method stub
            	int brightness=progress;
                originalbitmap = ((BitmapDrawable)imv.getDrawable()).getBitmap();
                Bitmap bitmap=doBrightness(originalbitmap,brightness);
	            imv.setImageBitmap(bitmap);
            }


            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }


            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            private Bitmap doBrightness(Bitmap src, int valueOfB) {
                // TODO Auto-generated method stub
                int width = src.getWidth();
                int height = src.getHeight();
                // create output bitmap
                Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
                // color information
                int A, R, G, B;
                int pixel;

                // scan through all pixels
                for(int x = 0; x < width; ++x) {
                    for(int y = 0; y < height; ++y) {
                        // get pixel color
                        pixel = src.getPixel(x, y);
                        A = Color.alpha(pixel);
                        R = Color.red(pixel);
                        G = Color.green(pixel);
                        B = Color.blue(pixel);

                        // increase/decrease each channel
                        R += valueOfB;
                        if(R > 255) { R = 255; }
                        else if(R < 0) { R = 0; }

                        G += valueOfB;
                        if(G > 255) { G = 255; }
                        else if(G < 0) { G = 0; }

                        B += valueOfB;
                        if(B > 255) { B = 255; }
                        else if(B < 0) { B = 0; }

                        // apply new pixel color to output bitmap
                        bmOut.setPixel(x, y, Color.argb(A, R, G, B));
                    }
                }

                // return final image
                return bmOut;
            }

        });
    }
}
