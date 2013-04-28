package com.example.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final String tag="ok";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(tag,"OnCreate happened");
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show(); 
		setContentView(R.layout.activity_main);
	}

	
	@Override public void onStart() 
	{
		super.onStart();
		Log.d(tag,"OnStart happened");
		Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show(); 
	}
	
	@Override public void onRestart() 
	{
		super.onRestart();
		Log.d(tag,"OnRestart happened");
		Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show(); 
	}
	
	@Override public void onResume() 
	{
		super.onResume();
		Log.d(tag,"OnResume happened");
		Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show(); 
	}
	
	@Override public void onPause() 
	{
		super.onPause();
		Log.d(tag,"OnPause happened");
		Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show(); 
	}

	@Override public void onStop() 
	{
		super.onStop();
		Log.d(tag,"OnStop happened");
		Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show(); 
	}

	@Override public void onDestroy() 
	{
		super.onStop();
		Log.d(tag,"OnDestroy happened");
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show(); 
	}
	
	public void openUrl(View v)
	{
		Log.d(tag,"opening url");
		Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://google.com"));
		startActivity(i);
	}
	
	public void startSecondActivity(View v)
	{
		Log.d(tag,"starting second activity");
		//Intent i=new Intent("com.example.ACTIVITY2"); // look at the intent filter
		Intent i=new Intent(this,SecondActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
