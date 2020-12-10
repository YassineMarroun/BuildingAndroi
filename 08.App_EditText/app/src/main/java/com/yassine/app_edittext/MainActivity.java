package com.yassine.app_edittext;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etn, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = (EditText)findViewById(R.id.txt_name);
        etp = (EditText)findViewById(R.id.txt_password);
    }

    //Method for the button
    public void Register(View view) {

        String name = etn.getText().toString();
        String password = etp.getText().toString();

        if(name.length() == 0) {
            Toast.makeText(this, "You need to enter a name", Toast.LENGTH_LONG).show();
        }
        if(password.length() == 0) {
            Toast.makeText(this, "You need to enter a password", Toast.LENGTH_LONG).show();
        }
        if(name.length() != 0 && password.length() != 0) {
            Toast.makeText(this, "Registration in process...", Toast.LENGTH_LONG).show();
        }
    }
}