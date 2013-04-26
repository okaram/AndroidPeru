#Basic Android Widgets

Android defines many U widgets, organized in a hierarchy; it helps to look at some of them, and at the basic hierarchy; notice that many attributes can be specified in xml and also in code; usually the mapping is easy.

The most used Android widgets are:
* [`TextView`](http://developer.android.com/reference/android/widget/TextView.html), which represents a label, or any widget with text attached; this is the superclass of buttons and editviews.
* [`EditText`](http://developer.android.com/reference/android/widget/EditText.html), which represents an editable text field. This is a subclass of TextView.
* [`Button`](http://developer.android.com/reference/android/widget/Button.html), which represents a simple button; since this has text, it is a subclass of TextView.
* [`ImageButton`](http://developer.android.com/reference/android/widget/ImageButton.html), button with an image instead of text.

* [`Checkbox`](http://developer.android.com/reference/android/widget/CheckBox.html), checkbox, on/off.
* [`ToggleButton`](http://developer.android.com/reference/android/widget/ToggleButton.html), same as a checkbox, different image (on/off).
* [`RadioButton`](http://developer.android.com/reference/android/widget/RadioButton.html), button with an image instead of text.


##Basic view parameters

##TextView and EditText
* has android:text, `getText`,`setText`  
	* notice text is NOT a string, but a CharSequence (which is a superclass of string), can use toString to convert to a string.
	* in xml, eclipse will complain if you use an actual string, since it wants you to use a reference (for internalization etc); we'll talk about those values later.
* `EditText` is editable
	* multiline

##Challenges
1. For an application of your choice, create a form, using as many different widgets as it makes sense.
2. See the Calculator Challenge.
