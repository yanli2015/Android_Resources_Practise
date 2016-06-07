package com.example.yanli.attributeresourcedemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by binbin on 6/1/2016.
 */
public class AlphaImageView extends ImageView {

    private int alphaDelta = 0;
    private int curAlpha = 0;
    private final int SPEED = 300;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                curAlpha += alphaDelta;
                if (curAlpha > 255) {
                    curAlpha = 255;
                    AlphaImageView.this.setAlpha(curAlpha);
                }
            }
        }
    };

    public AlphaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AlphaView);
        int duration = typedArray.getInt(R.styleable.AlphaView_duration, 0);
        alphaDelta = 255 * SPEED / duration;
    }

    protected void onDraw(Canvas canvas) {
        this.setImageAlpha(curAlpha);
        super.onDraw(canvas);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = 0x123;
                if (curAlpha >= 255) {
                    timer.cancel();
                } else {
                    handler.sendMessage(msg);
                }
            }

        }, 0, SPEED);
    }


}
