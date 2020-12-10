package com.yassine.app_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.txt_name);
        et_data = findViewById(R.id.txt_data);
    }

    //Save button method
    public void Save(View view) {

        String name = et_name.getText().toString();
        String data = et_data.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferences.edit();
        objEditor.putString(name, data);
        objEditor.apply();

        Toast.makeText(this, "The contact has been saved", Toast.LENGTH_SHORT).show();
    }

    //Search button method
    public void Search(View view) {

        String name = et_name.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String data = preferences.getString(name, "");

        if(data.length() == 0) {
            Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show();
        } else {
            et_data.setText(data);
        }
    }
}