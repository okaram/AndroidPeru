#A simple Android Application

* open the eclipse/android adt, do create new project, select android application project
* provide an application name, say _Converter_ , a project name, (notice it is autofilled) _Converter_ and package name (you can leave com.example, or use your name or domain name)
* keep clicking next, finish at the end (we'll talk about the options later)
* on the package explorer, select src, then your package, and your MainActivity.java class


This is the default code generated
```java
package com.example.converter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }    
}
```

Notice how this class inherits from android.app.Activity ; your application will have at least one Activity; your activity class is defining two methods; for now, we'll focus on its `onCreate` method, which is called when the activity is created (it acts as somewhat of a special constructor).

Each `Activity` usuallt has one `View` ; in the sample code, we call `setContentView` to set it to an XML-defined view (we'll talk about those later). 

