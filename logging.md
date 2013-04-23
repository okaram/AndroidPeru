#Logging and Debugging

Since you're doing GUI applications, you can't just `System.out.println`; to display debugging messages; however, you can:
* use a Toast, to display a quick message to the screen
* use Logging to display a message to your IDE/Debugger 

##Using Toasts
A toast will display a message for a small amount of time, and then make it disappear; the code is very simple; we create a Toast, and call its show method.
```
Toast.makeText(getApplicationContext(), "mensaje", Toast.LENGTH_SHORT).show(); 
```
We can also use `Toast.LENGTH_LONG`

##Logging

Android defines a class, `android.util.Log`, with several methods, for logging to the IDE/debugger; the methods usually take two strings, a tag and a messagge; there are several methods, `d` for debug messages, `i` for info messages etc (in eclipse, you can filter by tag or priority)

##Challenges
1. Change your converter (xml) application, so that it logs the celsius and farenheit temperatures
2. Change your converter so that, if the celsius is 0 or less it displays a toast sayint 'Brrr !'
