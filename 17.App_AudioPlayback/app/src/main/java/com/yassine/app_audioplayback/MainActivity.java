package com.yassine.app_audioplayback;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int playback_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play =(Button)findViewById(R.id.button_play);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        playback_sound = sp.load(this, R.raw.sound_short, 1);
    }

    //Method for the SoundPool button
    public void AudioSoundPool(View view) {

        sp.play(playback_sound, 1, 1, 1,0,0);
    }

    //Method for the MediaPlayer button
    public void AudioMediaPlayer(View view) {

        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_long);
        mp.start();
    }
}