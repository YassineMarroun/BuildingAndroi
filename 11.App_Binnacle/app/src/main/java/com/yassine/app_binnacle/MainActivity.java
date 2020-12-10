package com.yassine.app_binnacle;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.txt_name);
        et_content = findViewById(R.id.txt_binnacle);
        String[] files = fileList();

        if(ExistsFile(files)) {
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("binnacle.txt"));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                StringBuilder binnacleCompleted = new StringBuilder();

                while(line != null) {
                    binnacleCompleted.append(line).append("\n");
                    line = br.readLine();
                }
                br.close();
                file.close();
                et_content.setText(binnacleCompleted.toString());
            } catch (IOException ignored) {

            }
        }
    }

    private boolean ExistsFile(String[] files) {
        for (String file : files)
            if ("binnacle.txt".equals(file))
                return true;
            return false;
    }

    //Save button method
    public void Save(View view) {
        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("binnacle.txt", Activity.MODE_PRIVATE));
            file.write(et_content.getText().toString());
            file.flush();
            file.close();
        } catch (IOException ignored) {

        }
        Toast.makeText(this, "Log successfully saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    //Save to SD button method
    public void SaveSD(View view) {

        String name = et_name.getText().toString();
        String content = et_content.getText().toString();

        try {
            File cardSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, cardSD.getPath(), Toast.LENGTH_SHORT).show();
            OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput(name, Activity.MODE_PRIVATE));

            createFile.write(content);
            createFile.flush();
            createFile.close();

            Toast.makeText(this, "Saved correctly", Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_content.setText("");
        } catch (IOException e) {
            Toast.makeText(this, "Could not save", Toast.LENGTH_SHORT).show();
        }
    }

    //Consult button method
    public void Consult(View view) {

        String name = et_name.getText().toString();

        try {
            InputStreamReader openFile = new InputStreamReader(openFileInput(name));

            BufferedReader readFile = new BufferedReader(openFile);
            String line = readFile.readLine();
            StringBuilder contentCompleted = new StringBuilder();

            while(line != null) {
                contentCompleted.append(line).append("\n");
                line = readFile.readLine();
            }
            readFile.close();
            openFile.close();
            et_content.setText(contentCompleted);
        } catch (IOException e) {
            Toast.makeText(this, "Error reading file", Toast.LENGTH_SHORT).show();
        }
    }
}