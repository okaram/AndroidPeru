#Android Layouts

We need ways to combine several widgets on the screen; we do this through `ViewGroup`s, (but we usually call them `Layout`s :). Each layout is actually a widget, but instead of displaying its own info, it lays out and shows the other widgets.

Some of the common layouts include:

* [`LinearLayout`](http://developer.android.com/reference/android/widget/LinearLayout.html), which arranges its children in a line, either horizontally or vertically (depending on `android:orientation`). You can arrange your widgets in many ways by combining several of these, but performance may suffer.
* [`FrameLayout`](http://developer.android.com/reference/android/widget/FrameLayout.html), which contains only one widget (you can add more, but they overlap), can be used for borders etc or use subclasses like:
	* [`ScrollView`](http://developer.android.com/reference/android/widget/ScrollView.html), which lays out a large widget and, if needed, lets you scroll on it
	



##Challenges
1. For an application of your choice, create a form, using as many different widgets as it makes sense.
2. Create an app that converts to/from decimal, binary, octal, hex. Java's Integer class has parseInt that takes a radix, and also toOctalString etc
