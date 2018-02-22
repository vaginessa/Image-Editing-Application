package com.example.prac5;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
     
public class MainActivity extends Activity{
    Intent i;
    Bitmap b;
    String s = new String();
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery g = (Gallery)findViewById(R.id.gallery);
        final ImageView selectedImage = (ImageView)findViewById(R.id.imageV);
        selectedImage.setOnCreateContextMenuListener(this);
        g.setSpacing(1);
        final GalleryImageAdapter ga = new GalleryImageAdapter(this);
        g.setAdapter(ga);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                selectedImage.setImageResource(ga.imageId[arg2]);
                id = ga.imageId[arg2];
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu,View view, ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuItem mnu0=menu.add(0,0,0,"Rotation");
    	MenuItem mnu1=menu.add(0,1,1,"Contrast");
    	MenuItem mnu2=menu.add(0,2,2,"Brightness");
    }
    
    
    
    
    
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle().equals("Rotation")){
            Toast.makeText(this,"You clicked Rotation",Toast.LENGTH_LONG).show();
            i = new Intent(getApplicationContext(),Rotation.class);
            Bundle b = new Bundle();
            b.putInt("image",id);
            i.putExtras(b);
            startActivity(i);
            return true;
        }
        if(item.getTitle().equals("Contrast")){
            Toast.makeText(this,"You clicked contrast",Toast.LENGTH_LONG).show();
            i = new Intent(getApplicationContext(),Contrast.class);
            Bundle b = new Bundle();
            b.putInt("image",id);
            i.putExtras(b);
            startActivity(i);
            return true;
        }
        if(item.getTitle().equals("Brightness")){
            Toast.makeText(this,"You clicked brightness",Toast.LENGTH_LONG).show();
            i = new Intent(getApplicationContext(),Brightness.class);
            Bundle b = new Bundle();
            b.putInt("image",id);
            i.putExtras(b);
            startActivity(i);
            return true;
        }
        return false;
    }
}
