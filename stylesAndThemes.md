#Android Styles and Themes

Android allows you to define a kind of resource called a `style`; a style can contain many xml properties that could be applied to a widget in xml; instead of specifying these properties one by one, we define them in the style, and apply the style.

Styles are inspired by css, and, as such, also have inheritance; a style can define its parent style, and all the properties from the parent are inherited (and can be redefined by the style).

Styles are applied only to a specific widget, and do NOT apply to their children (unless the child specifies the same style). We can apply a style to an activity as a __Theme__ and then it will be applied to all its widgets.

## Defining Styles

Your style needs to go in an xml file, inside res/vales; the top level is `<resources>`, then you define one or more `<style>` and inside it `<item>` elements. Eclipse creates a `styles.xml` file, to which you can add styles, if you prefer (I do).

A style would look like:

```
    <style name="green">
        <item name="android:background">#55ff55</item>
    </style>
```

And we can also specify a parent for a style, like:
```
    <style name="gharish" parent="green">
        <item name="android:textColor">#ff0033</item>
    </style>
```
And it inherits all properties from its parent (the background color in this case)

## Applying styles

We can apply a style to a widget, with the style property, as follows:

```
    style="@style/gharish"
```

## Applying Themes

We can apply a theme to an application or activity using the `android:theme` property (the application and the activity are defined in the AndroidManifest.xml file).

For more info, see [Android guide for styles and themes](http://developer.android.com/guide/topics/ui/themes.html)
