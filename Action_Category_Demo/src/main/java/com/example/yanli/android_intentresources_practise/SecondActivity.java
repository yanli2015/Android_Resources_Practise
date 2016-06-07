package com.example.yanli.android_intentresources_practise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

/**
 * Created by binbin on 5/30/2016.
 */
public class SecondActivity extends Activity {
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        Set<String> categories = intent.getCategories();
        TextView tv  = new TextView(SecondActivity.this);
        tv.setTextSize(22);
        tv.setText("This is second Activity. "+"\n Action is :"+action+"\n Category is "+categories);
        setContentView(tv);
    }
}
