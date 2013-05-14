package com.example.adapterviews;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class AdaptersMainActivity extends Activity {
	class Person {
		public String name;
		public Drawable icon;
		public Person(String n, int icon_id){
			name=n;
			icon=getResources().getDrawable(icon_id);
		}
	}
	class MyAdapter extends ArrayAdapter<Person> {
		public MyAdapter(Person[]people) {
			super(getApplicationContext(),0,people);
		}
		
		
		private class Holder {
			public TextView tv;
			public ImageView iv;
			public Holder(View l) {
				tv=(TextView)l.findViewById(R.id.textView1);
				iv=(ImageView)l.findViewById(R.id.imageView1);
			}
		}
		
		public View getView(int position, View convertView, ViewGroup parent)
		{
			Person p=getItem(position);
			if(convertView!=null) {
				Log.d("ttt","not null");
			}
			RelativeLayout l;
			Holder h;
			if(convertView==null) {
				l=(RelativeLayout)getLayoutInflater().inflate(R.layout.list_row_layout, null);
				h=new Holder(l);
				l.setTag(h);
			}
			else {
				l=(RelativeLayout)convertView;
				h=(Holder)l.getTag();
			}
			
			h.tv.setText(p.name);
			h.iv.setImageDrawable(p.icon);
			
			return l;
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		String[] lines=new String[100];
		for(int i=0; i<100;++i)
			lines[i]=Integer.toString(i);
				
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapters_main);
		
		ListView lv=(ListView)findViewById(R.id.theListView);
		ArrayAdapter a=new ArrayAdapter<String>(this,
				R.layout.list_text_view,lines);
		lv.setAdapter(a);
		
		Person[] people={
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star),
					new Person("Orlando",android.R.drawable.btn_plus),
					new Person("Lina",android.R.drawable.btn_star)
				};
		MyAdapter a2=new MyAdapter(people);
		ListView lv2=(ListView)findViewById(R.id.listView2);
		lv2.setAdapter(a2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adapters_main, menu);
		return true;
	}

}
