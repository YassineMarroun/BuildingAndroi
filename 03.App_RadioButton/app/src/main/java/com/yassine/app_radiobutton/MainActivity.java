package com.yassine.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_value1, et_value2;
    private RadioButton rb_add, rb_sub, rb_mul, rb_div;
    private TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value1 = findViewById(R.id.txt_value1);
        et_value2 = findViewById(R.id.txt_value2);
        rb_add = findViewById(R.id.rb_add);
        rb_sub = findViewById(R.id.rb_subtract);
        rb_mul = findViewById(R.id.rb_multiplication);
        rb_div = findViewById(R.id.rb_division);
        tv_result = findViewById(R.id.tv_result);
    }

    //Method for calculate button
    public void calculate(View view) {

        String value1_String = et_value1.getText().toString();
        String value2_String = et_value2.getText().toString();

        int value1_int = Integer.parseInt(value1_String);
        int value2_int = Integer.parseInt(value2_String);

        if (rb_add.isChecked()) {
            int add = value1_int + value2_int;
            String result = String.valueOf(add);
            tv_result.setText(result);
        } else if (rb_sub.isChecked()) {
            int subtract = value1_int - value2_int;
            String result = String.valueOf(subtract);
            tv_result.setText(result);
        } else if (rb_mul.isChecked()) {
            int multiplication = value1_int * value2_int;
            String result = String.valueOf(multiplication);
            tv_result.setText(result);
        } else if (rb_div.isChecked()) {

            if (value2_int != 0) {
                int division = value1_int / value2_int;
                String result = String.valueOf(division);
                tv_result.setText(result);
            } else {
                Toast.makeText(this, "The second value must be non-zero", Toast.LENGTH_LONG).show();
            }
        }
    }
}