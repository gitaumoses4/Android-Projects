# Android Custom Fonts

In Android you can define your own custom fonts for the strings in your
application. You just need to download the required font from the internet, and
then place it in the assets/fonts folder.

After putting fonts in the assets folder, under fonts folder, you can access it
in your java code through Typeface class. First get the reference of the text
view in the code. Its syntax is given below.

```java
TextView textView = (TextView) findViewById(R.id.textview);
```

The next thing you need to do is to call a static method of Typeface class
`createFromAsset()` to get your custom font from assets. Its syntax is given
below.

```java
Typeface customFont = Typeface.createFromAsset(getAssets(),
"fonts/fontName.ttf");
```


The last thing you need to do is to set this custom font object to your
TextView Typeface property. You need to call `setTypeface() method to do that.
Its syntax is given below:

```java
textView.setTypeface(customFont):
```
