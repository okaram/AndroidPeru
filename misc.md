#Other Android features

##Tags
Android's `View` class has a very useful feature; the ability to store an arbitray object (actually more than one :) with the setTag and getTag method.

### basic tags
You can use the `setTag` object, on any view, to store an arbitrary object, and later use `getTag` to get it (getTag returns an object, so you'd need to cast it). You can also use the `android:tag` XML parameter, and set a tag from XML (only strings).

For example, if you're creating a board game, say TicTacToe, you could layout your whole screen; you'd have 9 buttons (or imageViews, or imageButtons) and you can tag each one with a string, and then use the same method to respond to clicks; in the click handler, you read the tag, and it tells you which cell it was clicked:
```
<ImageView android:tag="0" onClick="cellClicked" ...>
<ImageView android:tag="1" onClick="cellClicked" ...>
...
```
And your handler would look like this:

```
public void cellClicked(View v)
{
	int tag=Integer.parseInt((String)v.getTag());
	int row=tag/3;
	int col=tag%3;
	
	// now set it on your board etc :)
}
```

###More than one tag
There are also versions of setTag and getTag that take an extra numeric parameter, so you can set several different tags, and retrieve them with their id.

##Inner classes

###Special notation for inner classes

## android:autolink
The android:autoLink property of a textview specifies whether urls in its contents should be automatically converted to clickable links. 
