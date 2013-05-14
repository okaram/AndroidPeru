#Handling rotation

* When you rotate the screen, android destroys the activity and recreates it
* You can use onPause etc to save data
* Most widgets actually keep their state, but you need to be careful not to re-initialize, and also to keep your own state
* You can override `onSaveInstanceState` (which takes a Bundle), store data in the bundle, and the bundle gets passed to onCreate
	* this way also works when the activity is destroyed for lack of memory
```
	@Override
	public void onSaveInstanceState(Bundle b)
	{
		super.onSaveInstanceState(b);
		Log.d("ttt","onSaveInstanceState called");
		// we can save state like this
		b.putInt("color",Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));
	}
```
and in your onCreate you can do things like
```
		if(savedInstanceState!=null) {
			v.setBackgroundColor(savedInstanceState.getInt("color"));
		}
```

* You can also override `onRetainNonConfigurationInstance` (which returns an object) and later (in onCreate) call `getLastNonConfigurationInstance` ; this way, the data is not serialized, and you can store non-parcelable objects. This is now deprecated in favor of using fragments
```
	@Override
	public Object onRetainNonConfigurationInstance()
	{
		return Integer.valueOf(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));
	}
```
and in your onCreate you can do like:
```
		Integer c=(Integer)getLastNonConfigurationInstance();
```
* With fragments, you can specify whether they are retained, and they are not destroyed for rotation
* You can specify which  orientations you support in the AndroidManifest.xml, using `android:screenOrientation`
```
            android:screenOrientation="portrait"
```
