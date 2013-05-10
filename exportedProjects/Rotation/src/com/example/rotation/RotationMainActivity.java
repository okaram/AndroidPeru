package com.example.rotation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;

public class RotationMainActivity extends Activity {
	View v;
	SeekBar red,green,blue;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rotation_main);
		v=findViewById(R.id.LinearLayout1);
		
		SeekBar.OnSeekBarChangeListener handler=new SeekBar.OnSeekBarChangeListener() {
			@Override public void onStopTrackingTouch(SeekBar seekBar) {}		
			@Override public void onStartTrackingTouch(SeekBar seekBar) {}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(fromUser) {
					v.setBackgroundColor(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
				}
			}
		};
		
		red=(SeekBar)findViewById(R.id.red);
		red.setOnSeekBarChangeListener(handler);
		green=(SeekBar)findViewById(R.id.green);
		green.setOnSeekBarChangeListener(handler);
		blue=(SeekBar)findViewById(R.id.blue);
		blue.setOnSeekBarChangeListener(handler);
		if(savedInstanceState!=null) {
			v.setBackgroundColor(savedInstanceState.getInt("color"));
		}
		
		Integer c=(Integer)getLastNonConfigurationInstance();
	}

	@Override
	public Object onRetainNonConfigurationInstance()
	{
		return Integer.valueOf(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));
	}
	
	@Override
	public void onSaveInstanceState(Bundle b)
	{
		super.onSaveInstanceState(b);
		Log.d("ttt","onSaveInstanceState called");
		// we can save state like this
		b.putInt("color",Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rotation_main, menu);
		return true;
	}

}
