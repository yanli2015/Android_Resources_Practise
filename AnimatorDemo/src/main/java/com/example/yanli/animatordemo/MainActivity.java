package com.example.yanli.animatordemo;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = (LinearLayout)findViewById(R.id.container);
        container.addView(new MyAnimationView(MainActivity.this));

    }

    public class MyAnimationView extends View{
        public MyAnimationView(Context context){
            super(context);
           ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.color_anim);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.setTarget(this);
            colorAnim.start();


        }
    }
}
