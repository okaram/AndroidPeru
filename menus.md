#Android Menus

The developer site has a good [introduction to menus](http://developer.android.com/guide/topics/ui/menus.html).

Android supports 3 different kinds of menus:
* Options Menu - This is the global menu. In the new UI, some items can be shown on the action bar, android:showAsAction
* Context Menu - Appear when a user long-clicks on a widget (roughly equivalent to 'left-clicking' on a normal desktop)
* Popup Menu - Can be displayed for a widget

## Menus in xml
You can define all your menus in XML
* Menu - this is the wrapper around your menu (usually automatically defined by eclipse :) an identifier gets created inside R.menu
* Item- These define your menu items.
	* `android:id` needed for recognizing which item was clicked
	* `android:title` specifies the title
	* `android:icon` lets you specify an icon (on action bar, icon is shown instead of text; on 'pulldown' menu, text only, for now
	* `android:onClick` (after 3.0) lets you specify a method of your activity class to execute; the method is like `public void doSomething(MenuItem it)` 
	* can specify keyboard shortcuts (not terribly useful :)
* Group - These allow you to group several items, and then enable/disable all of them.

###Examples
```
    <item
        android:id="@+id/do_something"
        android:orderInCategory="100"
        android:showAsAction="always"
        android:title="do something"
        android:icon="@drawable/ic_launcher"
    />
    
    <item
        android:id="@+id/do_something_else"
        android:orderInCategory="100"
        android:showAsAction="ifRoom"
        android:title="do something else"
        android:onClick="doSomethingElse"
    />
```

## Options Menu
* Inflating
```
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menus_main, menu);
		return true;
	}
```
* Handling
	* After 3.0, can use `android:onClick`
	* If not, `public boolean onOptionsItemSelected(MenuItem item)`, use `item.getItemId`
```
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.do_something:
	    		Log.d("ttt","doing something");
	    		Toast.makeText(this, "Doing something", Toast.LENGTH_LONG).show();	        	
	            return true;
	        /// ... ... ...
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}		
```
* onClick methods: `public void doSomethingElse(MenuItem it)`
	


## Context Menu
See android documentation
## Popup Menu

##Challenges
1. Create an application with a simple layout (your choice); define a (options) menu to change the background color, for at least 3 different colors.
2. To the above application add another menu to open the android developer website
