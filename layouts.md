#Android Layouts

We need ways to combine several widgets on the screen; we do this through `ViewGroup`s, (but we usually call them `Layout`s :). Each layout is actually a widget, but instead of displaying its own info, it lays out and shows the other widgets.

Some of the common layouts include:

* [`LinearLayout`](http://developer.android.com/reference/android/widget/LinearLayout.html), which arranges its children in a line, either horizontally or vertically (depending on `android:orientation`). You can arrange your widgets in many ways by combining several of these, but performance may suffer.
* [`FrameLayout`](http://developer.android.com/reference/android/widget/FrameLayout.html), which contains only one widget (you can add more, but they overlap), can be used for borders etc or use subclasses like:
	* [`ScrollView`](http://developer.android.com/reference/android/widget/ScrollView.html), which lays out a large widget and, if needed, lets you scroll on it VERTICALLY only
	* [`HorizontalScrollView`](http://developer.android.com/reference/android/widget/HorizontalScrollView.html), which lays out a large widget and lets you do horizontal scrolling only
	* [`ViewFlipper`](http://developer.android.com/reference/android/widget/ViewFlipper), which switches among views, and can even be set to flip at regular intervals (there's also ViewAnimator,ViewSwitcher,ImageSwitcher, TextSwitcher)
* [`RelativeLayout`](http://developer.android.com/reference/android/widget/RelativeLayout.html), which allows you to draw its children relative to each other
* [`TableLayout`](http://developer.android.com/reference/android/widget/TableLayout.html), which allows you to define a table, each row being a [`TableRow`](http://developer.android.com/reference/android/widget/TableRow.html)
* [`GridLayout`](http://developer.android.com/reference/android/widget/GridLayout.html), which allows you to define an (infinite-ish) grid; can also use an adapter, which we'll cover later.


##Examples
```
<HorizontalScrollView
	android:layout_width="wrap_content"
	android:layout_height="250dp"
>
	<LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_margin="0dp"
            android:orientation="horizontal" 
            android:background="#00aabb">
            
            ... children go here
```
```
    <ScrollView
                android:layout_width="wrap_content"
                android:layout_height="100dp"
                android:background="#00aa00"
	>
```
```
    <ViewFlipper
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:autoStart="true"
            android:flipInterval="5000"
            android:layout_gravity="center_horizontal"
	>
	   ... children go here
```

##TableLayout

##Challenges
1. Combining LinearLayouts create a layout for a calculator, with a TextView at the top, and the corresponding buttons.
2. Create a similar layout, but now with a TableLayout
3. Look at the form you created previously (for the widgets); can you do it with a RelativeLayout ?
