package com.example.yanli.canvas_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by binbin on 6/4/2016.
 */
public class MyView extends View {
    public MyView(Context context, AttributeSet set) {
        super(context, set);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4.01f);
        int viewWidth = this.getWidth();
        canvas.drawCircle(viewWidth/10+10,viewWidth/10+10, viewWidth/10, p);
        canvas.drawRect(10,viewWidth/5+20,viewWidth/5+10,viewWidth/2+30,p);
        RectF oval=new RectF(10, viewWidth*3/5 + 50, 10+viewWidth/5, viewWidth*7/10+50);
        canvas.drawOval(oval,p);

        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.RED);
        Shader shader = new LinearGradient(0,0,40,60,new int[]{Color.RED, Color.BLACK,Color.YELLOW},null,Shader.TileMode.REPEAT);
        p.setShader(shader);
        p.setShadowLayer(25,20,20,Color.GRAY);
        canvas.drawCircle(viewWidth/2+30, viewWidth/10+10,viewWidth/10,p);
        Path path = new Path();
        path.moveTo(10, viewWidth*9/10+60);
        path.lineTo(viewWidth/5+10,viewWidth*9/10+60);
        path.lineTo(viewWidth/10+10,viewWidth*7/10+60);
        path.close();
        canvas.drawPath(path,p);
        p.setTextSize(48);
        p.setShader(null);
        canvas.drawText("Circle",60+viewWidth*3/5,viewWidth/10+10,p);

    }
}
