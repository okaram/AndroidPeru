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





