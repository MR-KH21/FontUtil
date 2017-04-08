# FontUtil

a simple way to change the typeface allover your app or to a specific view directly from the layout xml without creating a custom class or refering to your view programmatically.


## How to use it

* add the below dependency to your gradle file
```
compile 'com.khouli.font:font-util:0.0.1'
```

* if you want to change the typeface in all the text views (TextView or any of its subclasses) all over the application apply font as below

```java
public class FontApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        
        FontUtil.applyFont(Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf"));
    }
    
    //dont forget to change the app name in your manifiest android:name=".your custom class name"
}
```

* OR if you want to change the typeface in any specific text view (TextView or any of its subclasses) directly from the layout xml init the library as below

```java
public class FontApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //hash map of (font name , font path in assets)
        HashMap<String,String> fontsMap = new HashMap<>();
        fontsMap.put(this.getResources().getString(R.string.pacifico_font),"fonts/Pacifico.ttf");

        FontUtil.init(this,fontsMap);
    }
}

```

and now to use the font in any layout just set the font name to the tag object as below 
```xml
    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:tag="@string/pacifico_font" 
        ...
        />
```

* last step is to override your attachBaseContext method in your base activity as below 
```java
public class YourBaseActivity extends AppCompatActivity {

   @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new UtilContextWrapper(newBase));

    }
    ... 
    }

```


---
please check the sample app to see it in action.

## Contribution 
if you find a bug ? or you have feature request? Please send a pull request or add an issue in the tracker.

