package com.yassine.app_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Put the icon in ActionBar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @SuppressLint("NonConstantResourceId")
    public void Selection(View view) {

        switch(view.getId()) {
            case R.id.blackberry:
                Toast.makeText(this, "These are blackberries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bananas:
                Toast.makeText(this, "These are bananas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cherries:
                Toast.makeText(this, "These are cherries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.raspberries:
                Toast.makeText(this, "These are raspberries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.strawberries:
                Toast.makeText(this, "These are strawberries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.kiwi:
                Toast.makeText(this, "These are kiwis", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mango:
                Toast.makeText(this, "These are mangoes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.apple:
                Toast.makeText(this, "These are apples", Toast.LENGTH_SHORT).show();
                break;
            case R.id.melon:
                Toast.makeText(this, "These are melons", Toast.LENGTH_SHORT).show();
                break;
            case R.id.orange:
                Toast.makeText(this, "These are oranges", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pear:
                Toast.makeText(this, "These are pears", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pineapple:
                Toast.makeText(this, "These are pineapples", Toast.LENGTH_SHORT).show();
                break;
            case R.id.watermelon:
                Toast.makeText(this, "These are watermelons", Toast.LENGTH_SHORT).show();
                break;
            case R.id.grapes:
                Toast.makeText(this, "These are grapes", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}