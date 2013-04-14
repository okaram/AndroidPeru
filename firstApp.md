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

Notice how this class inherits from android.app.Activity ; your application will have at least one Activity; your activity class is defining two methods. For now, we'll focus on its `onCreate` method, which is called when the activity is created (it acts as somewhat of a special constructor).

Each `Activity` usuallt has one `View` ; in the sample code, we call `setContentView` to set it to an XML-defined view (we'll talk about those later). We will change the method to set it to a different view.

Although defining our views in XML is usually easier, I think it is better to do it first with code, to understand the basics, so we will create a simple container view, and add a few widgets.

To keep my code simpler, I usually define a method, called `createMainView`, that creates (and returns) the View. For this simple application, we will use 3 kinds of views:
* `LinearLayout`, which is a container view, which lays out its children either horizontally or vertically.
* `Button`, which, surprisingly, represents a button on the screen.
* `TextView`, which represents a non-editable (by the user) text widget (called a Label in many other GUI frameworks).
* `EditText`, which is an editable text field.


