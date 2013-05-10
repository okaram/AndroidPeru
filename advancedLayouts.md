#Advanced Layouts

Android provides several layouts that display a bunch (ok, an array :) of items; although you could layout your views programmatically, and use a ScrollView to scroll among them, this would be inefficient, since all the views would be in memory, even if not visible.

Since Android is designed for 'slow' devices, this waste is not good; instead, Android provides specialized classes that display an array of items, while creating only the views that are visible (and reusing those views whenever possible). In order to do that, it burdens the programmer a little, by forcing us to use `Adapters`; but then it creates several classes that make this easier.

## The Widgets
* [`Spinner`](http://developer.android.com/reference/android/widget/Spinner.html) [(tutorial)](http://developer.android.com/reference/android/widget/Spinner.html) which has a list of choices (strings), displays the current one and displays a menu of choices
* [`ListView`](http://developer.android.com/reference/android/widget/ListView.html) and [guide](http://developer.android.com/guide/topics/ui/layout/listview.html)
* [`GridView`](http://developer.android.com/reference/android/widget/GridView.html)  and [guide](http://developer.android.com/guide/topics/ui/layout/gridview.html)


##Challenges
