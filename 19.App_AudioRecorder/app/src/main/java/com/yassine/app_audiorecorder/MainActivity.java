package com.yassine.app_audiorecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaRecorder recording;
    private String outputFile = null;
    private Button btn_recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_recorder = findViewById(R.id.btn_rec);

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }

    //Method for Record button
    public void Recorder(View view) {

        if(recording == null) {
            outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Recording.mp3";
            recording = new MediaRecorder();
            recording.setAudioSource(MediaRecorder.AudioSource.MIC);
            recording.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recording.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            recording.setOutputFile(outputFile);

            try {
                recording.prepare();
                recording.start();
            } catch (IOException ignored) {

            }
            btn_recorder.setBackgroundResource(R.drawable.rec);
            Toast.makeText(getApplicationContext(), "Recording...", Toast.LENGTH_SHORT).show();
        } else {
            recording.stop();
            recording.release();
            recording = null;
            btn_recorder.setBackgroundResource(R.drawable.stop_rec);
            Toast.makeText(getApplicationContext(), "Recording finished", Toast.LENGTH_SHORT).show();
        }
    }

    //Method Play button
    public void Play(View view) {

        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(outputFile);
            mediaPlayer.prepare();
        } catch(IOException ignored) {

        }
        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_SHORT).show();
    }
}