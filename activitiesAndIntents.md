#Activities and Intents

Your Android application is composed of one or more [`Activities`](http://developer.android.com/reference/android/app/Activity.html).

Activities are created and destroyed by the OS, and you may want to know when your activity is about to be destroyed, so you can save data. An Android activity goes through several states, which we call its *Lifecycle*


![Activity lifecycle](http://developer.android.com/images/activity_lifecycle.png)

The following code has handlers for all the events in the lifecycle. The code just logs whether the event happened (and displays a message with a Toast).

```
public class MainActivity extends Activity {
	static final String tag="ok";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(tag,"OnCreate happened");
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show(); 
		setContentView(R.layout.activity_main);
	}
	
	@Override public void onStart() 
	{
		super.onStart();
		Log.d(tag,"OnStart happened");
		Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show(); 
	}
	
	@Override public void onRestart() 
	{
		super.onRestart();
		Log.d(tag,"OnRestart happened");
		Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show(); 
	}
	
	@Override public void onResume() 
	{
		super.onResume();
		Log.d(tag,"OnResume happened");
		Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show(); 
	}
	
	@Override public void onPause() 
	{
		super.onPause();
		Log.d(tag,"OnPause happened");
		Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show(); 
	}

	@Override public void onStop() 
	{
		super.onStop();
		Log.d(tag,"OnStop happened");
		Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show(); 
	}

	@Override public void onDestroy() 
	{
		super.onStop();
		Log.d(tag,"OnDestroy happened");
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show(); 
	}
``` 

## Using intents to start activities
Android uses [`Intents`](http://developer.android.com/reference/android/content/Intent.html) to start activities, but 
decouplinh the intent from a specific activity; your Application's manifest file specifies which intents it responds to, and which activity to use; also, other applications decide which intents to respond to.

We can create intents for starting specific activities, and then use `startActivity` to start an activity for that intent; for example, we can use the following code, to start a browser, to google.com

```
	Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://google.com"));
	startActivity(i);
```

## Declaring intents for your activities

When you create an activity in your application, you can define one or more intent filters for it; the activity would respond to intents that match any of its filters.

For example, if you look at your project manifest file, for a simple project, you'll see something like this:
```
        <activity
            android:name="com.example.activitylifecycle.MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```
It declares your activity (the name is the class name), specifies its label (which will be its title), and one intent filter; the LAUNCHER category specifies it should appear in the Android Launcher.

You can create more than one activity in your application, and specifies intents for it; For example, if you create an activity (mine is called SecondActivity), it will be added to the manifest; and then you can add an intent filter, as follows:
```
	<activity
        android:name="com.example.activitylifecycle.SecondActivity"
        android:label="@string/title_activity_second"
        <intent-filter>
            <action android:name="com.example.ACTIVITY2" />
            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>
``` 

Now, given that intent filter, you can then create an intent and launch the activity with:
```
	Intent i=new Intent("com.example.ACTIVITY2"); // look at the intent filter
	startActivity(i);
```

Notice even if you don't declare an intent filter, you can always start an activity by speficying the class directly, as in the following example

```
	Intent i=new Intent(this,SecondActivity.class);
	startActivity(i);
```

## Sending and Receiving values
You can send values to an activity when starting it, by passing an extra `Bundle` to the startActivity method
## Challenges
1. Open the ActivityLifecycle project, run it, and look at the logs for all the events; what happens when you press the buttons ?
2. Add another button, to open the dialer and call a phone number of your choice.
3. Add another activity, and a button to open it.




