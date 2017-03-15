#Android Clipboard

Android provides the clipboard framework for copying and pasting different
types of data. The data could be text, images, and binary stream data or other
complex data types.

Android provides the library of `ClipboardManager` and `ClipData` and
`ClipData.item` to use the copying and pasting framework. In order to use
clipboard framework, you need to put data into clip object, and then put that
object into system wide clipboard.

```java
ClipboardManager myClipboard;
myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
```

###Copying Data
The new thing you need to do is instanciate the ClipData object by calling the
respective type of data method of the ClipData class. In case of text data, the
`newPlainText` method will be called. After that you have to set that data as
the clip of the `ClipboardManager` object. Its syntax is given below.

```java
ClipData myClip;
String text = "Hello World";
myClip = ClipData.newPlainText("text",text);
myClipboard.setPrimaryClip(myClip);
```

###Pasting Data
In order to paste the data, we will first get the clip by calling the
`getPrimaryClip()` method. And from that click we will get the item in
ClipData.item object. And from the object we will get teh data. Its syntax is
given below.

```java
ClipData abc = myClipboard.getPrimaryClip();
ClipData.Item item = abc.getItemAt(0);
String text = item.getText().toString();
```
