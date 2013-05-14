package com.example.adapterviews;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PeopleOpenHelper extends SQLiteOpenHelper {
	public static final int DB_VERSION=1;
	public static final String DB_NAME="people";
	
	public static final String CREATE_PEOPLE=
			"CREATE TABLE People (Name text, Age int)";
	public static final String INSERT_PERSON1=
			"INSERT INTO People (Name, Age) VALUES('Orlando',40)";
	public static final String INSERT_PERSON2=
			"INSERT INTO People (Name, Age) VALUES('Lina',39)";
	
	public PeopleOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// this method gets called when your db is created
		db.execSQL(CREATE_PEOPLE);
		db.execSQL(INSERT_PERSON1);
		db.execSQL(INSERT_PERSON2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// eventually, specify how to upgrade from one version to another
	}
	
	public Cursor getAllPeople()
	{
		return getReadableDatabase().
				rawQuery("SELECT name,age,rowid AS _id from People", null);
	}
}
