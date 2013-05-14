#Advanced Layouts

Android provides several layouts that display a bunch (ok, an array :) of items; although you could layout your views programmatically, and use a ScrollView to scroll among them, this would be inefficient, since all the views would be in memory, even if not visible.

Since Android is designed for 'slow' devices, this waste is not good; instead, Android provides specialized classes that display an array of items, while creating only the views that are visible (and reusing those views whenever possible). In order to do that, it burdens the programmer a little, by forcing us to use [`Adapters`](http://developer.android.com/reference/android/widget/Adapter.html); but then it creates several classes that make this easier.

## The Widgets
* [`Spinner`](http://developer.android.com/reference/android/widget/Spinner.html) [(tutorial)](http://developer.android.com/reference/android/widget/Spinner.html) which has a list of choices (strings), displays the current one and displays a menu of choices
* [`ListView`](http://developer.android.com/reference/android/widget/ListView.html) and [guide](http://developer.android.com/guide/topics/ui/layout/listview.html)
* [`GridView`](http://developer.android.com/reference/android/widget/GridView.html)  and [guide](http://developer.android.com/guide/topics/ui/layout/gridview.html)


## Adapters

Android uses the [`Adapter`](http://developer.android.com/reference/android/widget/Adapter.html) class as the base for all adapters; we will later see the `CursorAdapter`, which displays SQL cursors; the other widely used class is ArrayAdapter, which takes data from an Array, and which we'll extend.

```
		ListView lv=(ListView)findViewById(R.id.theListView);
		ArrayAdapter a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lines);
		lv.setAdapter(a);
```
### Array Adapter
The ArrayAdapter class is the simplest and easier to use; it takes an array of elements, and, by default, produces a TextView obtained by calling toString on each element; we can also pass it the id of a layout, and the id of a textview inside that layout; we can also extend the class to return a view we want, as below.


```
	class MyAdapter extends ArrayAdapter<Person> {
		public MyAdapter(Person[]people) {
			super(getApplicationContext(),0,people);
		}
		
		public View getView(int position, View convertView, ViewGroup parent)
		{
			Person p=getItem(position);
			RelativeLayout l=(RelativeLayout)getLayoutInflater().inflate(R.layout.list_row_layout, null);
			TextView tv=(TextView)l.findViewById(R.id.textView1);
			tv.setText(p.name);
			
			ImageView iv=(ImageView)l.findViewById(R.id.imageView1);
			iv.setImageDrawable(p.icon);
			int c=R.color.green;
			String[] numeros=getResources().getStringArray(R.array.numeros);
			Log.d("ttt",numeros[0]);
			return l;
		}
	}

```

### Holder Pattern
In order to avoid
