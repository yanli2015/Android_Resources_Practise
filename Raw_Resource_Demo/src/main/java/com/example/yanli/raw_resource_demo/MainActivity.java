package com.example.yanli.raw_resource_demo;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends Activity {
    MediaPlayer mediaPlayer1 = null;
    MediaPlayer mediaPlayer2 = null;
    Button playRaw, playAsset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playAsset = (Button) findViewById(R.id.playAsset);
        playRaw = (Button) findViewById(R.id.playRaw);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bomb);
        playRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });

        AssetManager am = getAssets();
        try {
            AssetFileDescriptor afd = am.openFd("shot.mp3");
            mediaPlayer2 = new MediaPlayer();
            mediaPlayer2.setDataSource(afd.getFileDescriptor());
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        playAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
            }
        });


    }
}
