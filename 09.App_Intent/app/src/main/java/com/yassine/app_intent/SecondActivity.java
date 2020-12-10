package com.yassine.app_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv1 = (TextView)findViewById(R.id.et2);
        String data = getIntent().getStringExtra("data");
        tv1.setText(getString(R.string.txt_tv1, data));
    }

    //Return button method
    public void Return(View view) {
        Intent i  = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}