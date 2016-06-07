package com.example.yanli.path_demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextView(this));

    }

    class TextView extends View {
        final String DRAW_STR = "Android practise";
        Path[] paths = new Path[3];
        Paint p;

        public TextView(Context context) {
            super(context);
            paths[0] = new Path();
            paths[0].moveTo(0, 0);
            for (int i = 1; i <= 20; i++) {
                paths[0].lineTo(i * 30, (float) Math.random() * 30);
            }
            paths[1] = new Path();
            RectF recF = new RectF(0, 0, 600, 360);
            paths[1].addOval(recF, Path.Direction.CCW);
            paths[2] = new Path();
            paths[2].addArc(recF, 60, 180);
            p = new Paint();
            p.setAntiAlias(true);
            p.setColor(Color.CYAN);
            p.setStrokeWidth(1);

        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.translate(40, 40);
            p.setTextAlign(Paint.Align.RIGHT);
            p.setTextSize(20);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[0],p);
            p.setTextSize(40);
            p.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STR,paths[0],-8,20,p);

            canvas.translate(0,60);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[1], p );
            p.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STR,paths[1],-20,20,p);

            canvas.translate(0,360);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[2],p);
            p.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STR,paths[2],-10,20,p);


        }
    }
}
