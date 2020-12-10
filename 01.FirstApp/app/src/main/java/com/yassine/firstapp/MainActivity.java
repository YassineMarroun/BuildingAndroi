package com.yassine.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yassine.firstapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_num1);
        et2 = findViewById(R.id.txt_num2);
        tv1 = findViewById(R.id.txt_result);
    }

    //This method performs the sum.
    public void Sum(View view) {

        String value1 = et1.getText().toString();
        String value2 = et2.getText().toString();

        int num1 = Integer.parseInt(value1);
        int num2 = Integer.parseInt(value2);

        int sum = num1 + num2;

        String result = String.valueOf(sum);
        tv1.setText(result);
    }
}