package com.yassine.app_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.imageView2);
        button1 = findViewById(R.id.button);
    }

    public void Hide(View view) {
        button1.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.VISIBLE);
    }
}