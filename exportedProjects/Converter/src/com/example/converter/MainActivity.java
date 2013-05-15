package com.example.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText faren;
	TextView celsius;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		faren=(EditText)findViewById(R.id.faren);
		celsius=(TextView)findViewById(R.id.celsius);
		Button b=(Button)findViewById(R.id.convertBtn);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double f=Double.valueOf(faren.getText().toString());
				double c=(f-32)/1.8;
				celsius.setText(Double.valueOf(c).toString());
			}		
		});
		//setContentView(makeMainView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View arg0) {
		double f=Double.valueOf(faren.getText().toString());
		double c=(f-32)/1.8;
		celsius.setText(Double.valueOf (c).toString());
	}		
	
	
	View makeMainView()
	{
		LinearLayout l=new LinearLayout(this);
		l.setOrientation(LinearLayout.VERTICAL);
		TextView fLabel=new TextView(this);
		fLabel.setText("Farenheit");
		l.addView(fLabel);
		
		faren=new EditText(this);
		l.addView(faren);
		
		Button b=new Button(this);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double f=Double.valueOf(faren.getText().toString());
				double c=(f-32)/1.8;
				celsius.setText(Double.valueOf(c).toString());
			}		
		});
		b.setText("Convert");
		l.addView(b);
		
		celsius=new TextView(this);
		l.addView(celsius);
		return l;
	}

}
