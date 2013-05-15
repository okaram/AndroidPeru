#Permissions

* Android applications need to specify they use permissions to use certain features 
* We do this inside the AndroidManifest.xml , inside the `<manifest>` tag (top-level)
* We use the `<uses-permission>` tag, as follows:
```
    <uses-permission android:name="android.permission.INTERNET"></uses-permission>
```
