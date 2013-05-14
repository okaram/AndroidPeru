package com.example.adapterviews;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PersonEditFragment extends Fragment {
	View layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

    	// Inflate the layout for this fragment
        layout= inflater.inflate(R.layout.edit_person_fragment, container, false);
//		MyAdapter a2=new MyAdapter(app.getPeople());
//		theListView.setAdapter(a2);
        setPerson();
        return layout;
    }
    
    void setPerson()
    {
        MyApplication app=(MyApplication)getActivity().getApplicationContext();
        Person p=app.getCurrentPerson();
        TextView name=(TextView)layout.findViewById(R.id.nombre);
        TextView age=(TextView)layout.findViewById(R.id.edad);
        name.setText(p.name);
        age.setText(Integer.toString(p.age));
    }
}
