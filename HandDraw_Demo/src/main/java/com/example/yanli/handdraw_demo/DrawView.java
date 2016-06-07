package com.example.yanli.handdraw_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by binbin on 6/6/2016.
 */
public class DrawView extends View {
    float preX;
    float preY;
    private Path path;
    public Paint p = null;
    Bitmap cacheBitmap = null;
    Canvas cacheCanvas = null;

    public DrawView(Context context, int width, int height) {
        super(context);
        cacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        path = new Path();
        cacheCanvas.setBitmap(cacheBitmap);
        p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(1);
        p.setAntiAlias(true);
        p.setDither(true);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                preX = x;
                preY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX, preY, x, y);
                preX = x;
                preY = y;
                break;

            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path, p);
                path.reset();
                break;
        }

        invalidate();
        return true;
    }

    public void onDraw(Canvas canvas) {
        Paint p2 = new Paint();
        canvas.drawBitmap(cacheBitmap,0,0,p2);
        canvas.drawPath(path,p);
    }
}
