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
```
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />
```
* `EditText` is editable
* `android:inputType` controls which characters get accepted (and which keyboard gets displayed)
* can use styles etc `android:textAppearance="?android:attr/textAppearanceLarge"`
* can make multiline `android:inputType="textMultiLine"`

```
    <EditText
        android:id="@+id/editText1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceLarge"         
        android:background="#aa5555"
        android:maxLines="10"
        android:minLines="5"
        android:inputType="textMultiLine" >
        <requestFocus />
    </EditText>
```
## Buttons
* buttons are TextViews, so all of their attributes work for them
* we normally use their onClick (although every view has onclick !)
* buttons can have text and a pic with their `android:drawableLeft` attribute
* we can use their `android:onClick` attribute, or set onClickListener in code
```
    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Full Screen Activity" 
        android:onClick="showFullScreenForm"
        android:drawableLeft="@drawable/whack"/>
```

##Compound Buttons (Checkboxes)
* android supports several kinds of compound buttons.		
	* [`Checkbox`](http://developer.android.com/reference/android/widget/CheckBox.html),
	* [`ToggleButton`](http://developer.android.com/reference/android/widget/ToggleButton.html), 
	* [`Switch`](http://developer.android.com/reference/android/widget/Switch.html), and
	* [`RadioButton`](http://developer.android.com/reference/android/widget/RadioButton.html) (RadioButtons belong to a [`RadioGroup`](http://developer.android.com/reference/android/widget/RadioGroup.html), and only one is selected at any given time).

* they all support isChecked method
```
    <CheckBox
        android:id="@+id/checkBox1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:onClick="checkboxClicked"
        android:text="CheckBox" />

    <ToggleButton
        android:id="@+id/toggleButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:onClick="checkboxClicked"
        android:textOff="No"
        android:textOn="Yes" />
```
* RadioButtons need to be embeded in a radio group; you can later ask if checked, or ask the group for the id of the button which is checked

```
    <RadioGroup
        android:id="@+id/radioGroup1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" 
        android:orientation="horizontal"
        >
        <RadioButton
            android:id="@+id/radio0"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:checked="true"
            android:text="Uno" />
	...
	</RadioGroup>
```

##Images
* [`ImageView`](http://developer.android.com/reference/android/widget/ImageView.html), which allows you to display an image 
* [`ImageButton`](http://developer.android.com/reference/android/widget/ImageButton.html), which is a button that displays an image instead of text.
* [`Gallery`](http://developer.android.com/reference/android/widget/Gallery.html), which is now deprecated, but widely used :) it displays a bunch of images and allows you to browse through them

##Other widgets
* [`DatePicker`](http://developer.android.com/reference/android/widget/DatePicker.html)
* [`TimePicker`](http://developer.android.com/reference/android/widget/TimePicker.html)
* [`Chronometer`](http://developer.android.com/reference/android/widget/Chronometer.html), and [`AnalogClock`](http://developer.android.com/reference/android/widget/AnalogClock.html)
* [`ProgressBar`]((http://developer.android.com/reference/android/widget/ProgressBar.html) can be a bar or a circle
* [`SeekBar`]((http://developer.android.com/reference/android/widget/SeekBar.html) which extends ProgressBar, can use getProgress to read its value


##Challenges
1. Play with the Widgets project; what things can you do ? 
2. Create an app that converts to/from decimal, binary, octal, hex. Java's Integer class has parseInt that takes a radix, and also toOctalString etc. Use radio buttons to decide what to convert from/to
3. For an application of your choice, create a form, using as many different widgets as it makes sense.
