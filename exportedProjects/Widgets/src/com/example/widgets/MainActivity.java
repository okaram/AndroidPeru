package com.example.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Gallery;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void showForm1(View v)
	{
		Intent i=new Intent(this,Form1.class);
		startActivity(i);
	}

	public void showTextForm(View v)
	{
		Intent i=new Intent(this,TextFormActivity.class);
		startActivity(i);
	}

	public void showFullScreenForm(View v)
	{
		Intent i=new Intent(this,FullscreenActivity.class);
		startActivity(i);
	}

	public void showClocksForm(View v)
	{
		Intent i=new Intent(this,ClocksActivity.class);
		startActivity(i);
	}

}
