package com.gitaumoses4.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by root on 3/14/17.
 */
public class SecondActivity extends AppCompatActivity {

    private Camera cameraObject;
    private ShowCamera showCamera;
    private ImageView pic;


    public static Camera isCameraAvailable() {
        Camera object = null;
        try {
            object = Camera.open();
        } catch (Exception e) {

        }
        return object;
    }

    public void useInbuiltCamera(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private Camera.PictureCallback capturedIt = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            if (bitmap == null) {
                Toast.makeText(getApplicationContext(), "Not taken", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SecondActivity.this, "Taken", Toast.LENGTH_SHORT).show();
            }
            cameraObject.release();
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        pic = (ImageView) findViewById(R.id.imageView2);
        cameraObject = isCameraAvailable();
        showCamera = new ShowCamera(this, cameraObject);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(showCamera);
    }

    public void snapIt(View view) {
        cameraObject.takePicture(null, null, capturedIt);
    }

    private static class ShowCamera extends SurfaceView implements SurfaceHolder.Callback {

        private SurfaceHolder holdMe;
        private Camera theCamera;

        public ShowCamera(Context context, Camera camera) {
            super(context);
            theCamera = camera;
            holdMe = getHolder();
            holdMe.addCallback(this);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                theCamera.setPreviewDisplay(holder);
                theCamera.startPreview();
            } catch (Exception e) {

            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }
}
