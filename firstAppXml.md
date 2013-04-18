#A simple Android Application

In [Our First Application](firstApp.md "Notes for First android app") We've just developped a very simple android application, as illustrated below:
![screenshot](converter.png)

You have one text field, where you write a temperature in Farenheit, and a button for converting it; when pressing the button, the temperature in celsius degrees will be displayed.

We created the UI (the main view) by writing code that creates all the widgets in the right places; this is perfectly fine, and we can create complicated interfaces this way; however, Android also allows us to define our UI in XML, which is usually easier and more flexible (unfortunately, we cannot wire most events using XML, so we still need to write code for our UI).

If you look at the activity_main.xml file (inside res/layouts), you'll notice eclipse lets you edit it in graphical or raw-xml views (I switch among those constantly :)

The XML looks like this:
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />

</RelativeLayout>
```
We have a `RelativeLayout` (layouts are widgets that contain and lay-out other widgets), which contains one `TextView`






##Extra Challenges:
1. Change the layout, so the label for the Farenheit temperature (at the very top) is to the left of the corresponding `EditText` (you need to create a horizontal layout). Add a label (TextView) displaying 'celsius' and put it to the left of the celsius label.
2. Convert the `TextView` that displays the temperature in celsius into an `EditText` so it is now editable, and add another button that converts from celsius into farenheit (may want to change the label of the first button also, since 'convert' is now not so meaningful :)
