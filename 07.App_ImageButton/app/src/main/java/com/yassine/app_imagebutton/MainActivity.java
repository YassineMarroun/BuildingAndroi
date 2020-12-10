package com.yassine.app_imagebutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method for Adidas button
    public void MessageAdidas(View view) {
        Toast.makeText(this, "Adidas", Toast.LENGTH_SHORT).show();
    }

    //Method for Nike button
    public void MessageNike(View view) {
        Toast.makeText(this, "Nike", Toast.LENGTH_SHORT).show();
    }
}