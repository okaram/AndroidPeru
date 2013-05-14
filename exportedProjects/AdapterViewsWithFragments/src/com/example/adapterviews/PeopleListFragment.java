package com.example.adapterviews;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PeopleListFragment extends Fragment {
	class MyAdapter extends ArrayAdapter<Person> {
		public MyAdapter(Person[]people) {
			super(getActivity().getApplicationContext(),0,people);
		}
		
		
		private class Holder {
			public TextView name_v, age_v;
			public Holder(View l) {
				name_v=(TextView)l.findViewById(R.id.nombre);
				age_v=(TextView)l.findViewById(R.id.age);
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
				l=(RelativeLayout)getActivity().getLayoutInflater().inflate(R.layout.list_row_layout, null);
				h=new Holder(l);
				l.setTag(h);
			}
			else {
				l=(RelativeLayout)convertView;
				h=(Holder)l.getTag();
			}
			
			h.name_v.setText(p.name);
			h.age_v.setText(Integer.toString(p.age));
			
			return l;
		}
	}
	
	ListView theListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        theListView = (ListView)inflater.inflate(R.layout.people_list_fragment, container, false);
        MyApplication app=(MyApplication)getActivity().getApplicationContext();
		MyAdapter a2=new MyAdapter(app.getPeople());
		theListView.setAdapter(a2);
        
        return theListView;
    }
}
