package com.example.styles;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class StylesMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_styles_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.styles_main, menu);
		return true;
	}

}
