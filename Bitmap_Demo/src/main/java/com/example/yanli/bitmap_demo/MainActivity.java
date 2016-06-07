package com.example.yanli.bitmap_demo;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    String[] images = null;
    AssetManager assets = null;
    int currentImg = 0;
    ImageView image;
    Button next;
    InputStream assetFile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        assets = getAssets();
        try {
            images = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentImg >= images.length) {
                    currentImg = 0;
                }
                while (! images[currentImg].endsWith(".png") && ! images[currentImg].endsWith(".jpg") && ! images[currentImg].endsWith(".gif") ){
                    currentImg ++;
                    if(currentImg >= images.length) {
                        currentImg = 0;
                    }

                }

                try {
                    assetFile =  assets.open(images[currentImg ++]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable)image.getDrawable();
                if(bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()){
                    bitmapDrawable.getBitmap().recycle();
                }
                image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
            }
        });

    }
}
