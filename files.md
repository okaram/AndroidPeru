#Accessing files

* We have several places to store data in an Android application, and several ways to get to those files; we normally want to get to a plain java InputStream or such. You can store files in 3 possible places:

* __inside your apk__ your application eventually becomes a zip file (named apk, but it is basically a zip :). You can store files here in resources (usually res/raw) or in the assets folder; you can then get read-only access to these files.
* __in your app's local storage__ Android provides application local storage that belongs to your application only; you can get access to it with openFileInput and openFileOutput (which take only a file name, not a namespace) and with openFilesDir, which gives you a File object.
* __in the 'external' storage__ which is shared with all apps (many times this is an SD or microSD card). You can use getExternalFilesDir(), getExternalStoragePublicDirectory, or getExternalStorageDirectory

## Files inside your apk

* `res/raw` we can store files in the res/raw folder; we can then use getResources().openRawResource and pass it a number (usually from R.raw....). Notice we can only get an InputStream, so this files are read-only.

For example, if we have a file called the\_raw\_file inside res/raw, we can get access to it with
```
		InputStream in=getResources().openRawResource(R.raw.the_raw_file);
```

* __assets__ getAssets().open()
```
			InputStream in=getAssets().open("text.txt");
```

## local app storage

## external
