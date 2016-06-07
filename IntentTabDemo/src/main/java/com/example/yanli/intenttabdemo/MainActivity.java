package com.example.yanli.intenttabdemo;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends TabActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost
			.newTabSpec("tab1")
			.setIndicator("BeCalled",
				getResources().getDrawable(R.mipmap.ic_launcher))
			.setContent(new Intent(this, BeCalledActivity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("Called")
			.setContent(new Intent(this, CalledActivity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("NoCall")
			.setContent(new Intent(this, NoCallActivity.class)));
	}
}

