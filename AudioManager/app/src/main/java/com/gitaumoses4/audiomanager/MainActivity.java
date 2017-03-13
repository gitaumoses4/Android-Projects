package com.gitaumoses4.audiomanager;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by root on 3/12/17.
 */

public class MainActivity extends AppCompatActivity {

    private Button vibrateButton, ringButton, silentButton, modeButton;
    private TextView status;
    private AudioManager audioManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        vibrateButton = (Button) findViewById(R.id.vibrate);
        ringButton = (Button) findViewById(R.id.ring);
        silentButton = (Button) findViewById(R.id.silent);
        modeButton = (Button) findViewById(R.id.mode);
        status = (TextView) findViewById(R.id.status);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    public void vibrate(View view) {
        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

    public void ring(View view) {
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }

    public void silent(View view) {
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    public void mode(View view) {
        int mod = audioManager.getRingerMode();
        String mode = "";
        switch (mod) {
            case AudioManager.RINGER_MODE_NORMAL:
                mode = "Ring";
                break;
            case AudioManager.RINGER_MODE_SILENT:
                mode = "Silent";
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                mode = "Vibrate";
                break;
            default:
                break;
        }
        status.setText("Current Status: " + mode);
    }
}
