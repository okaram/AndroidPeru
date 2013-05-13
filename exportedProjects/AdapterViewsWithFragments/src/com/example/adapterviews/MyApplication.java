package com.example.adapterviews;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {
	Person[] people;
	@Override 
	public void onCreate()
	{
		super.onCreate();
		Person[]people2={
				new Person("Orlando",40),
				new Person("Lina",40),
				new Person("Eveling",25),
				new Person("Alfredo",26),
				new Person("Carlo",25),
				new Person("Otro",40),
				new Person("Otra",40),
				new Person("Otro mas",25),
				new Person("Alguien",26),
				new Person("Otro Alguien",25),
			};
		people=people2;
		Log.d("ttt","people initialized");
	}
	
	public Person[] getPeople()
	{
		Log.d("ttt","returning people"+people.toString());
		return people;
	}
	
	public Person getCurrentPerson()
	{
		Log.d("ttt","returning person"+people[0].toString());
		return people[0];
	}
	
}
