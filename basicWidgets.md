#Basic Android Widgets

Android defines many UI widgets, organized in a hierarchy; it helps to look at some of them, and at the basic hierarchy; notice that many attributes can be specified in xml and also in code; usually the mapping is easy.

The most used Android widgets are:
* [`TextView`](http://developer.android.com/reference/android/widget/TextView.html), which represents a label, or any widget with text attached; this is the superclass of buttons and editviews.
* [`EditText`](http://developer.android.com/reference/android/widget/EditText.html), which represents an editable text field. This is a subclass of TextView.
* [`Button`](http://developer.android.com/reference/android/widget/Button.html), which represents a simple button; since this has text, it is a subclass of TextView.
* [`ImageButton`](http://developer.android.com/reference/android/widget/ImageButton.html), button with an image instead of text.
* [`CompoundButton`](http://developer.android.com/reference/android/widget/CompoundButton.html), buttons that can be checked or unchecked. Android provides 4 subclasses,[`Checkbox`](http://developer.android.com/reference/android/widget/CheckBox.html),[`ToggleButton`](http://developer.android.com/reference/android/widget/ToggleButton.html), 
[`Switch`](http://developer.android.com/reference/android/widget/Switch.html), and
[`RadioButton`](http://developer.android.com/reference/android/widget/RadioButton.html) (RadioButtons belong to a [`RadioGroup`](http://developer.android.com/reference/android/widget/RadioGroup.html), and only one is selected at any given time.


##Basic view parameters
* all widgets inherit from `View`
* can set background color (or image) with `android:background`
* Use android:id to give your widget a name (accessed as R.id....)
* need to specify `android:layout_width` and `android:layout_height` (can do other layout paraemeters)
	* `match_parent` (was fill_parent)
	* `wrap_content`
	* or specific widht in pixels, dp, %
* every view has android:onClick

```
    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="29dp"
        android:src="@drawable/all_blue" 
        android:background="#00bb99"
        android:onClick="whacked"
	/>
```
##TextView and EditText
* has android:text, `getText`,`setText`  
	* notice text is NOT a string, but a CharSequence (which is a superclass of string), can use toString to convert to a string.
	* in xml, eclipse will complain if you use an actual string, since it wants you to use a reference (for internalization etc); we'll talk about those values later.
* `EditText` is editable
* `android:inputType` controls which characters get accepted (and which keyboard gets displayed)
* can use styles etc `android:textAppearance="?android:attr/textAppearanceLarge"`
* can make multiline `android:inputType="textMultiLine"`

```

```

##Images
* [`ImageView`](http://developer.android.com/reference/android/widget/ImageView.html), which allows you to display an image 
* [`ImageButton`](http://developer.android.com/reference/android/widget/ImageButton.html), which is a button that displays an image instead of text.
* [`Gallery`](http://developer.android.com/reference/android/widget/Gallery.html), which is now deprecated, but widely used :) it displays a bunch of images and allows you to browse through them

##Other widgets

##Challenges
1. For an application of your choice, create a form, using as many different widgets as it makes sense.
2. Create an app that converts to/from decimal, binary, octal, hex. Java's Integer class has parseInt that takes a radix, and also toOctalString etc
