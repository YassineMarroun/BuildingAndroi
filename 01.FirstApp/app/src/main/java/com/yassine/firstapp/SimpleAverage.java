package com.yassine.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SimpleAverage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int mathematics = 5;
        int chemistry = 5;
        int physical = 5;
        int average;

        average = (mathematics + chemistry + physical / 3);

        if (average >= 6) {
            Toast.makeText(this, "Approved", Toast.LENGTH_LONG).show();
        } else if (average <= 5) {
            Toast.makeText(this, "Suspended", Toast.LENGTH_LONG).show();
        }
    }
}
