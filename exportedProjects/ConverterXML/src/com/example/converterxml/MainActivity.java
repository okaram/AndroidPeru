package com.example.converterxml;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView faren,celsius;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		faren=(TextView) findViewById(R.id.faren);
		celsius=(TextView) findViewById(R.id.celsius);
		Button b=(Button)findViewById(R.id.convertBtn);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double f=Double.valueOf(faren.getText().toString());
				double c=(f-32)/1.8;
				celsius.setText(Double.valueOf(c).toString());
				Log.d("clicks","You clicked the convert button");
				Toast.makeText(getApplicationContext(), "button was clicked", Toast.LENGTH_LONG).show();
			}		
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
