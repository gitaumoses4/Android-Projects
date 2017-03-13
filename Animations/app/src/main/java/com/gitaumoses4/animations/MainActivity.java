package com.gitaumoses4.animations;


import com.gitaumoses4.animations.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        int animationId;
        switch (item.getItemId()) {
            case R.id.zoomInOut:
                animationId = R.anim.myanimation;
                break;
            case R.id.rotate360:
                animationId = R.anim.clockwise;
                break;
            case R.id.fadeInOut:
                animationId = R.anim.fade;
                break;
            default:
                return false;
        }
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), animationId);
        image.startAnimation(animation);
        return true;
    }
}
