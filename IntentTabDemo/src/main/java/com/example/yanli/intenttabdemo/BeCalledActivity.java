package com.example.yanli.intenttabdemo;

import android.app.Activity;
import android.os.Bundle;

public class BeCalledActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.be_called);
	}
}