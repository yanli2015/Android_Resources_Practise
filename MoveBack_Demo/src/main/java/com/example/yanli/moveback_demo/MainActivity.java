package com.example.yanli.moveback_demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

    }

    class MyView extends View{
        private Bitmap back, plane;
        final int BACK_HEIGHT = 1700;
        final int WIDTH = 640;
        final int HEIGHT  = 1400;
        final Matrix matrix = new Matrix();
        private int startY = BACK_HEIGHT - HEIGHT;

        public MyView (Context context) {
            super(context);
            back = BitmapFactory.decodeResource(context.getResources(),R.drawable.back_img);
            plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
            WindowManager wm = getWindowManager();
           Display display =  wm.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
           display.getMetrics(metrics);
            float screenWidth = metrics.widthPixels;
            float scale = screenWidth / WIDTH;
            matrix.setScale(scale,scale);
            final Handler handler = new Handler(){
                public void handleMessage(Message msg) {
                if(msg.what== 0x12){
                    if (startY <= 3) {
                        startY = BACK_HEIGHT - HEIGHT;
                    } else {
                        startY -= 3;
                    }
                }

                invalidate();
            }
            };

            new Timer().schedule(new TimerTask(){
                public void run() {
                    handler.sendEmptyMessage(0x12);
                }

            },0,100);
        }

        public void onDraw(Canvas canvas) {
            Bitmap bitmap2 = Bitmap.createBitmap(back, 0, startY,WIDTH,HEIGHT,matrix,false);
            canvas.drawBitmap(bitmap2,0,0,null);
            canvas.drawBitmap(plane,320,12,null);

        }


    }
}
