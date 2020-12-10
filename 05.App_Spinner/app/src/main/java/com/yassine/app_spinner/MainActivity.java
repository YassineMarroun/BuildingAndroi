package com.yassine.app_spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et_value1, et_value2;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value1 = findViewById(R.id.txt_value1);
        et_value2 = findViewById(R.id.txt_value2);
        tv_result = findViewById(R.id.tv_result);
        spinner1 = findViewById(R.id.spinner);

        String[] options = {"Add", "Subtract", "Multiplication", "Division"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_options, options);
        spinner1.setAdapter(adapter);
    }

    //Method for calculate button
    public void calculate(View view) {

        String value1_String = et_value1.getText().toString();
        String value2_String = et_value2.getText().toString();

        int value1_int = Integer.parseInt(value1_String);
        int value2_int = Integer.parseInt(value2_String);

        String selection = spinner1.getSelectedItem().toString();
        switch (selection) {
            case "Add": {
                int add = value1_int + value2_int;
                String result = String.valueOf(add);
                tv_result.setText(result);
                break;
            }
            case "Subtract": {
                int subtract = value1_int - value2_int;
                String result = String.valueOf(subtract);
                tv_result.setText(result);
                break;
            }
            case "Multiplication": {
                int multiplication = value1_int * value2_int;
                String result = String.valueOf(multiplication);
                tv_result.setText(result);
                break;
            }
            case "Division":
                if (value2_int != 0) {
                    int division = value1_int / value2_int;
                    String result = String.valueOf(division);
                    tv_result.setText(result);
                } else {
                    Toast.makeText(this, "The second value must be non-zero", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}