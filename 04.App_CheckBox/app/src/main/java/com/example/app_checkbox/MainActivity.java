package com.example.app_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_value1, et_value2;
    private CheckBox check_add, check_sub;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value1 = findViewById(R.id.txt_value1);
        et_value2 = findViewById(R.id.txt_value2);
        check_add = findViewById(R.id.check_add);
        check_sub = findViewById(R.id.check_subtract);
        tv_result = findViewById(R.id.tv_result);
    }

    //Method for calculate button
    public void calculate(View view) {

        String value1_String = et_value1.getText().toString();
        String value2_String = et_value2.getText().toString();

        int value1_int = Integer.parseInt(value1_String);
        int value2_int = Integer.parseInt(value2_String);

        String result = "";
        if (check_add.isChecked()) {
            int add = value1_int + value2_int;
            result = " The Sum is: " + add + " / ";
        }
        if (check_sub.isChecked()) {
            int subtract = value1_int - value2_int;
            result = result + " The Subtraction is: " + subtract;
        }
        tv_result.setText(result);
    }
}