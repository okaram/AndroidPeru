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

In the class, we will need to keep track of two things; the `EditText` where the user will type the temperature in farenheit, and the `TextView` where we will write the corresponding temperature in celsius; the other widgets can (and should :) be variables local to the method. So, we add the following variables to the Activity class:
```java
	EditText faren;
	TextView celsius;
```

Since we're referencing new classes, Eclipse will detect we haven't imported them; we can right click on the error indicator next to each line, and Eclipse will give us options for fixing the errors, which is handy. Even easier, since we know we usually want to import the right class, pressing `Ctrl-Shit-O` will fix all imports :)

Then we can define the following method:
```java
	View makeMainView()
	{
		LinearLayout l=new LinearLayout(this);
		l.setOrientation(LinearLayout.VERTICAL);
		TextView fLabel=new TextView(this);
		fLabel.setText("Farenheit");
		l.addView(fLabel);
		
		faren=new EditText(this);
		l.addView(faren);
		
		Button b=new Button(this);
		b.setText("Convert");
		l.addView(b);
		
		celsius=new TextView(this);
		l.addView(celsius);
		return l;
	}
```

And we need to replace the call to `setContentView` in the `onCreate` method for:
```java
		setContentView(makeMainView());
```

Now, running the app (Ctrl-F11) will show a screen like this one:

![screenshot](converter.png)
