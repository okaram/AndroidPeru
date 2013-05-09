package com.example.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;

public class Form1 extends Activity {

	public final String tag="form1";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compound);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form1, menu);
		return true;
	}
	
	public void checkboxClicked(View v)
	{
		boolean checked=((CompoundButton)v).isChecked();
		String action= checked ? "checked" : "unchecked";
		Log.d(tag,"You just "+ action +" the checkbox");
	}

}
