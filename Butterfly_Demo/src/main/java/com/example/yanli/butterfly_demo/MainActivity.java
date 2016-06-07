package com.example.yanli.butterfly_demo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private float curX = 0;
    private float curY = 0;
    private float nextX = 0;
    private float nextY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView)findViewById(R.id.butterfly);
        final Handler handler = new Handler(){
          public void handleMessage(Message msg){
              if (msg.what == 0x124) {
                  if (nextX > 320) {
                      curX = nextX = 0;
                  }else {
                      curX += 8;
                  }
                  nextY  = curY + (float)(Math.random()*10-5);
                  TranslateAnimation anim = new TranslateAnimation(curX, curY, nextX, nextY);
                  imageView.startAnimation(anim);
              }
          }
        };

        final AnimationDrawable butterfly = (AnimationDrawable)imageView.getBackground();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butterfly.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x124);
                    }
                },0,200);
            }
        });

    }
}
