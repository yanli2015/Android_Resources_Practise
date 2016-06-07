package com.example.yanli.handdraw_demo;



import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class MainActivity extends Activity
{
    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    DrawView drawView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout line = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay()
                .getRealMetrics(displayMetrics);

        drawView = new DrawView(this, displayMetrics.widthPixels
                , displayMetrics.heightPixels);
        line.addView(drawView);
        setContentView(line);
        emboss = new EmbossMaskFilter(new float[]
                { 1.5f, 1.5f, 1.5f }, 0.6f,	6, 4.2f);
        blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflator = new MenuInflater(this);

        inflator.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override

    public boolean onOptionsItemSelected(MenuItem mi)
    {

        switch (mi.getItemId())
        {
            case R.id.red:
                drawView.p.setColor(Color.RED);
                mi.setChecked(true);
                break;
            case R.id.green:
                drawView.p.setColor(Color.GREEN);
                mi.setChecked(true);
                break;
            case R.id.blue:
                drawView.p.setColor(Color.BLUE);
                mi.setChecked(true);
                break;
            case R.id.width_1:
                drawView.p.setStrokeWidth(1);
                break;
            case R.id.width_3:
                drawView.p.setStrokeWidth(3);
                break;
            case R.id.width_5:
                drawView.p.setStrokeWidth(5);
                break;
            case R.id.blur:
                drawView.p.setMaskFilter(blur);
                break;
            case R.id.emboss:
                drawView.p.setMaskFilter(emboss);
                break;
        }
        return true;
    }
}

