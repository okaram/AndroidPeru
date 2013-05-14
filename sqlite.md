#Databases and SQLite

Android contains the libraries for an embedded database, [sqlite](http://sqlite.org/). SQLite is not a replacement for a full-fledged DBMS (it's a replacement for fopen, not for PostgreSQL), but gives you something like a relational DBMS, but it does NOT enforce typing (you can write a string in an integer field) or FOREIGN KEY constraints, and supports most of the basic SQL (SQL-92) with a few limitations that depend on the version.

SQLite has now become almost the standard for embedded databases, given that both Android and iOS include it; you could include other DBMS libraries if you wanted (just include the jar file if they're pure java), but having it included with the OS saves space and hassle.

Android provides a few classes that make it easier to use sqlite.

## SQLiteOpenHelper

Every SQLite db is backed by a file; we would normally open the file (the class is a SQLiteDatabase); however, what happens if the file does not exist ? also, how do we keep track of versions if we change the file ? Android provides [`SQLiteOpenHelper`](http://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html), which has an onCreate and onUpgrade methods, where we can execute SQL statements to create or upgrade our db.We normally extend this class, and override onCreate (and later onUpgrade). For example:

```
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
}
```

## Geting a database
We can call getReadableDatase() and getWritableDatabase() on a SQLiteOpenHelper to obtain a [`SQLiteDatabase`](http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html), and after that call query or rawQuery to obtain a [`SQLiteCursor`](http://developer.android.com/reference/android/database/sqlite/SQLiteCursor.html)
