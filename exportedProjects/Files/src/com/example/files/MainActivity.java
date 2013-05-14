package com.example.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

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
	
	String readFile(InputStream in)
	{
		BufferedReader inr=new BufferedReader(new InputStreamReader(in));
		StringBuffer b=new StringBuffer();
		String line;
		try {
			while((line=inr.readLine())!=null) { 
				b.append(line);
				b.append("\n");
			}
		} catch (IOException e) {
		
		}
		return b.toString();
	}
	
	void writeToFile(String s, OutputStream o1)
	{
		Log.d("ttt","writing "+s);
		Writer o2= new BufferedWriter(new OutputStreamWriter(o1));
		try {
			o2.write(s,0,s.length());
			o2.close();
		} catch (IOException e){
			Log.e("ttt","Error writing");
		} finally {
		}
		
	}
	
	public void readRaw(View v)
	{
		InputStream in=getResources().openRawResource(R.raw.the_raw_file);
		TextView tv=(TextView)findViewById(R.id.textView1);
		tv.setText(readFile(in));
	}

	public void readAsset(View v)
	{
		try {
			InputStream in=getAssets().open("text.txt");
			TextView tv=(TextView)findViewById(R.id.textView1);
			tv.setText(readFile(in));
		} catch (IOException e) {
			Log.e("ttt","Couldn't find the file");
		}
	}

	public void readLocal(View v)
	{
		try {
			InputStream in=openFileInput("test.txt");
			TextView tv=(TextView)findViewById(R.id.textView1);
			tv.setText(readFile(in));
		} catch (IOException e) {
			Log.e("ttt","Couldn't find the file");
		}
	}
	
	public void writeLocal(View v)
	{
		try {
			OutputStream out=openFileOutput("test.txt", 0);
			TextView tv=(TextView)findViewById(R.id.textView1);
			writeToFile(tv.getText().toString(), out);
		} catch (Exception e) {
			Log.e("ttt","Couldn't write local test.txt");
		}
	}
	
	public void readLocalFolder(View v)
	{
		try {
			File in1=new File(getFilesDir(),"test.txt");
			TextView tv=(TextView)findViewById(R.id.textView1);
			tv.setText(readFile(new FileInputStream(in1)));
		} catch (Exception e) {
			Log.e("ttt","couldn't find it");
		}
	}
	
}
