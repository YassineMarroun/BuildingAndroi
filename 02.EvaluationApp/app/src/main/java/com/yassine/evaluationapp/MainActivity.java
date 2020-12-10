package com.yassine.evaluationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_mathematics);
        et2 = findViewById(R.id.txt_physics);
        et3 = findViewById(R.id.txt_chemistry);
        tv1 = findViewById(R.id.tv_status);
    }

    public void status(View view){
        String Mathematics_String = et1.getText().toString();
        String Physics_String = et2.getText().toString();
        String Chemistry_String = et3.getText().toString();

        int Mathematics_int = Integer.parseInt(Mathematics_String);
        int Physics_int = Integer.parseInt(Physics_String);
        int Chemistry_int = Integer.parseInt(Chemistry_String);

        int average = (Mathematics_int + Physics_int + Chemistry_int) / 3;

        if (average >= 6) {
            tv1.setText(getString(R.string.txt_status, "Passed", average));
        } else if (average <= 5) {
            tv1.setText(getString(R.string.txt_status, "Failed", average));
        }
    }
}