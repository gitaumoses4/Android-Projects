#Android Camera

These are the following two ways, in which you can use camera in your
application.

*Using existing camera application in our application
*Directly using Camera API provided by android in our application

###Using existing android camera application in our application
You will use `MediaStore.ACTION_IMAGE_CAPTURE` to launch an existing camera
application installed on your phone. Its synta is given below.

```java
Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
```

Apart from the above there are other available intents provided by MediaStore.
They are listed as follows.

>**ACTION_IMAGE_CAPTURE_SECURE** - It returns the image captured from the
>camera, when the device is secured.
>**ACTION_VIDEO_CAPTURE** - It calls the existing video application in android
>to capture the video.
>**EXTRA_SCREEN_ORIENTATION** - It is used to set the orientation of the screen
>to vertical or landscape.
>**EXTRA_FULL_SCREEN** - It is used to control the user interface of the
>`ViewImage`
>**INTENT_ACTION_VIDEO_CAMERA** - This intent is used to launch the camera in
>the video mode.
>**EXTRA_SIZE_LIMIT** - It is used to specify the size limit of video or image
>capture size.

Now you will use the function `startActivityForResult()` to launch this
activity and wait for it result. Its syntax is given:

```java
startActivityForResult(intent,0)
```

###Directly using Camera API provided by android in our application
We will be using the Camera API to integrate the camera in our application.

First you will need to initialize the camera object using the static method
provided by the api called `Camera.open`. Its syntax is:
```java
Camera object = null;
object = Camera.open();
```

Now you will need to make a separate class and extend it with SurfaceView and
implements SurfaceHolder interface.
Two classes that have been used have the following purposes.

* **Camera** - It is used to control the camera and take images or capture
  video from the camera.
* **SurfaceView** - It is used to present a live camera preview to the user.

You will have to call the preview method of the camera to start the preview of
the camera to the user.

```java
public class ShowCamera extends SurfaceView implements SurfaceHolder.Callback{

    private Camera theCamera;

    public void SurfaceCreated(SurfaceHolder holder){
        theCamera.setPreviewDisplay(holder);
        theCamera.startPreview();
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int
    arg3){    
    }

    public void surfaceDestroyed(SurfaceHolder arg0){
    }
}
```

