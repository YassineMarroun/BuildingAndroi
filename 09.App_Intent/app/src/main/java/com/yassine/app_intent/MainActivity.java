package com.yassine.app_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et3 = (EditText)findViewById(R.id.txt_web);
    }

    //Send button method
    public void Send(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("data", et1.getText().toString());
        startActivity(i);
    }

    //Go button method
    public void Navigate(View view){
        Intent i = new Intent(this, WebActivity.class);
        i.putExtra("website", et3.getText().toString());
        startActivity(i);
    }
}