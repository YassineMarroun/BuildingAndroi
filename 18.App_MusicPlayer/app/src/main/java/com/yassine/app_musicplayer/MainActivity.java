package com.yassine.app_musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repeat;
    ImageView iv;
    int repeat = 2, position = 0;
    MediaPlayer[] vector_mp = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repeat = (Button)findViewById(R.id.btn_repeat);
        iv = (ImageView)findViewById(R.id.imageView);

        vector_mp[0] = MediaPlayer.create(this, R.raw.race);
        vector_mp[1] = MediaPlayer.create(this, R.raw.sound);
        vector_mp[2] = MediaPlayer.create(this, R.raw.tea);
    }
    
    //Method for PlayPause button
    public void PlayPause(View view) {
        
        if(vector_mp[position].isPlaying()) {
            vector_mp[position].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        } else {
            vector_mp[position].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Method for Stop button
    public void Stop(View view) {

        if(vector_mp[position] != null) {
            vector_mp[position].stop();

            vector_mp[0] = MediaPlayer.create(this, R.raw.race);
            vector_mp[1] = MediaPlayer.create(this, R.raw.sound);
            vector_mp[2] = MediaPlayer.create(this, R.raw.tea);
            position = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Method for Repeat button
    public void Repeat(View view) {

        if(repeat == 1) {
            btn_repeat.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repeat", Toast.LENGTH_SHORT).show();
            vector_mp[position].setLooping(true);
            repeat = 2;
        } else {
            btn_repeat.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repeat", Toast.LENGTH_SHORT).show();
            vector_mp[position].setLooping(true);
            repeat = 1;
        }
    }

    //Method for Next button
    public void Next(View view) {

        if(position < vector_mp.length - 1) {

            if(vector_mp[position].isPlaying()) {
                vector_mp[position].stop();
                position++;
                vector_mp[position].start();

            } else {
                position++;
            }
            if(position == 0) {
                iv.setImageResource(R.drawable.portada1);
            } else if(position == 1) {
                iv.setImageResource(R.drawable.portada2);
            } else if(position == 2) {
                iv.setImageResource(R.drawable.portada3);
            }

        } else {
            Toast.makeText(this, "No more songs", Toast.LENGTH_SHORT).show();
        }
    }

    //Method for Previous button
    public void Previous(View view) {

        if(position >= 1) {

            if(vector_mp[position].isPlaying()) {
                vector_mp[position].stop();
                vector_mp[0] = MediaPlayer.create(this, R.raw.race);
                vector_mp[1] = MediaPlayer.create(this, R.raw.sound);
                vector_mp[2] = MediaPlayer.create(this, R.raw.tea);
                position--;

                if(position == 0) {
                    iv.setImageResource(R.drawable.portada1);
                } else if(position == 1) {
                    iv.setImageResource(R.drawable.portada2);
                } else if(position == 2) {
                    iv.setImageResource(R.drawable.portada3);
                }

                vector_mp[position].start();
            } else {
                position--;

                if(position == 0) {
                    iv.setImageResource(R.drawable.portada1);
                } else if(position == 1) {
                    iv.setImageResource(R.drawable.portada2);
                } else if(position == 2) {
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        } else {
            Toast.makeText(this, "No more songs", Toast.LENGTH_SHORT).show();
        }
    }
}