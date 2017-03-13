package com.gitaumoses4.audiocapture;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by root on 3/11/17.
 */

public class MainActivity extends AppCompatActivity {

    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    private Button start, stop, play;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        stop = (Button) findViewById(R.id.stopButton);
        play = (Button) findViewById(R.id.playButton);

        stop.setEnabled(false);
        play.setEnabled(false);

        outputFile = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/myRecording.3gp";

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);
    }

    public void start(View view) {
        try {
            myAudioRecorder.prepare();
            myAudioRecorder.start();
        } catch (IllegalStateException e) {
            //TODO handle exception
        } catch (IOException e) {
            //TODO handle exception
            e.printStackTrace();
        }

        start.setEnabled(false);
        stop.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_LONG).show();
    }

    public void stop(View view) {
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder = null;
        stop.setEnabled(false);
        play.setEnabled(true);

        Toast.makeText(getApplicationContext(),
                "Audio Recorded successfully", Toast.LENGTH_LONG)
                .show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void play(View view) throws
            IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayer m = new MediaPlayer();
        m.setDataSource(outputFile);
        m.prepare();
        m.start();

        Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
    }
}
