# Android Gestures

Android provides special types of screen events such as pinch, double tap,
scrolls, king presses and flinch. These are all known as gestures.

Android provides `GestureDetector` class to receive motion events and tell us
that these events correspond to gestures or not. To use it, you need to create
an object of `GestureDetector` and then extend another class with
`GestureDetector.SimpleOnGestureListener` to act as a listener and override
some methods. Its syntax is given below:

```java
GestureDetector myGestureDetector;
myGestureDetector = new GestureDetector(this, new Gesture());

class Gesture extends GestureDetector.SimpleOnGestureListener{
    public boolean onSingleTapUp(MotionEvent event){
    
    }
    
    public void onLongPress(MotionEvent event){
    
    }

    public boolean onScroll(MotionEvent event1, MotionEvent event2, float
    distanceX, float distanceY){
    
    }

    public boolean onFling(MotionEvent event1, MotionEvent event2, float
    velocityX, float velocityY){
    
    }
}
```
## Handling Pinch Gesture

Android provides `ScaleGestureDetector` class to handle gesturs like pinch
e.t.c. In order to use it, you need to instantiate an object of this class. Its
syntax is as follows.

```java
ScaleGestureDetector scaleGestureDetector;
scaleGestureDetector = new ScaleGestureDetector(this , new ScaleListener());
```

The first parameter is the context and the second parameter is the event
listener. We have to define an event listener and override a function
`OnTouchEvent` to make it working. Its syntax is given below:

```java
public boolean onTouchEvent(MotionEvent event){
    scaleGestureDetector.onTouchEvent(event);
    return true;
}

private class ScaleListener extends
ScaleGestureDetector.SimpleOnScaleGestureListener{
    @Override
    public boolean onScale(ScaleGestureDetector detector){
        float scale = detector.getScaleFactor();

        return true;
    }
}
```


