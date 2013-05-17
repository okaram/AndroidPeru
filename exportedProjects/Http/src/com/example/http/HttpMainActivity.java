package com.example.http;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HttpMainActivity extends Activity {

	class UpdateTextView implements Runnable {
		String val;
		int id;
		UpdateTextView(int i, String v)
		{
			val=v;
			id=i;
		}
		@Override
		public void run() {
			TextView tv=(TextView)findViewById(id);
			tv.setText(val);
		}		
	}
	class DownloadRunnable implements Runnable {
		CharSequence id;
		DownloadRunnable(CharSequence id)
		{
			this.id=id;
		}
		@Override
		public void run() {
			HttpClient cli=new DefaultHttpClient();
			HttpUriRequest req=new HttpGet("http://10.0.2.2:8080/person/"+id);
			try {
				HttpResponse r=cli.execute(req);
				ByteArrayOutputStream out=new ByteArrayOutputStream();
				r.getEntity().writeTo(out);
				String payload=out.toString();
				Log.d("ttt",payload);
				runOnUiThread(new UpdateTextView(R.id.textView1,payload));
				
				JSONObject obj=new JSONObject(payload);
				Log.d("ttt","name="+obj.getString("name"));
				Log.d("ttt","age="+obj.getString("age"));
				runOnUiThread(new UpdateTextView(R.id.name,obj.getString("name")));
				runOnUiThread(new UpdateTextView(R.id.age,obj.getString("age")));
				
			} catch (Exception e){
				Log.e("ttt","Exception "+e.toString());
			}
		}		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.http_main, menu);
		return true;
	}

	public void verPersona(View v)
	{
		TextView tv=(TextView)findViewById(R.id.personId);
		new Thread(new DownloadRunnable(tv.getText())).start();		
	}

	class AddPersonRunnable implements Runnable {
		CharSequence id,name,age;
		AddPersonRunnable(CharSequence id, CharSequence name, CharSequence age)
		{
			this.id=id;
			this.age=age;
			this.name=name;
		}
		@Override
		public void run() {
			HttpClient cli=new DefaultHttpClient();
			HttpUriRequest req=new HttpPost("http://10.0.2.2:8080/person/"+id+"/"+name+"/"+age);
			try {
				HttpResponse r=cli.execute(req);				
			} catch (Exception e){
				Log.e("ttt","Exception "+e.toString());
			}
		}		
	}
	
	public void addPerson(View v)
	{
		TextView name_v=(TextView)findViewById(R.id.editName);
		TextView id_v=(TextView)findViewById(R.id.editId);
		TextView age_v=(TextView)findViewById(R.id.editAge);
		new Thread(new AddPersonRunnable(id_v.getText(),name_v.getText(),age_v.getText())).start();
		NotificationCompat.Builder b=new NotificationCompat.Builder(this);
		b.setSmallIcon(R.drawable.ic_launcher);
		b.setContentText("Creamos persona");
		b.setContentTitle("yay!");
		NotificationManager mNotificationManager =
			    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(0, b.build());
		Log.d("ttt","notified");
	}
	
}
