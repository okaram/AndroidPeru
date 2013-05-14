package com.example.adapterviews;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class AdaptersMainActivity extends Activity {
	Cursor allPeople;
	SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {						
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapters_sql_main);
		ListView lv1=(ListView)findViewById(R.id.listView1);
		Cursor c=new PeopleOpenHelper(this).getAllPeople();
		startManagingCursor(c);
		String[] fieldNames={"_id","Name","Age"};
		int[] layoutFields={R.id._id,R.id.name, R.id.age};

		adapter=new SimpleCursorAdapter(this,
				R.layout.list_row_layout,
				c,
				fieldNames,
				layoutFields);
		lv1.setAdapter(adapter);
		
/*	
		MyAdapter a2=new MyAdapter(people);
		ListView lv2=(ListView)findViewById(R.id.listView2);
		lv2.setAdapter(a2);
*/
	}

	class CountUpdater implements Runnable {
		int count;
		public CountUpdater(int c)
		{
			 count=c;
		}
		@Override
		public void run() {
			TextView tv=(TextView) findViewById(R.id.textView1);
			tv.setText("There are "+Integer.toString(count) +" people");					
		}
		
	}
	class PeopleCounter implements Runnable {

		@Override
		public void run() {
			SQLiteDatabase db=new PeopleOpenHelper(getApplicationContext()).getReadableDatabase();
			Cursor c=db.rawQuery("SELECT name,age,rowid _id from People", null);
			int numPeople=c.getCount();
			Log.d("ttt", "cursor has "+Integer.toString(c.getColumnCount()));
			for(int i=0; i<c.getColumnCount(); ++i)
				Log.d("ttt", "column "+c.getColumnName(i));
			c.moveToFirst();
			do {
				Log.d("ttt","row:"+c.getString(0)+" "+c.getString(1));
			} while(c.moveToNext());
			c.close();
			runOnUiThread(new CountUpdater(numPeople));
		}	
	}
	public void countPeople(View v)
	{
		new Thread(new PeopleCounter()).run();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adapters_main, menu);
		return true;
	}
	
	public void addPerson(View v)
	{
		TextView tv_name=(TextView)findViewById(R.id.edit_name);
		TextView tv_age=(TextView)findViewById(R.id.edit_age);
		String query="INSERT INTO People(name,age) VALUES(?,?)";
		PeopleOpenHelper poh=new PeopleOpenHelper(this);
		SQLiteDatabase db=poh.getWritableDatabase();
		String[] values={tv_name.getText().toString(), tv_age.getText().toString()};
		db.execSQL(query, values);
		Cursor c=poh.getAllPeople();
		adapter.swapCursor(c);
		db.close();
	}

}
