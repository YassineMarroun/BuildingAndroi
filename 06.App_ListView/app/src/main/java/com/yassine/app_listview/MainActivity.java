package com.yassine.app_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private final String[] names = {"Samuel", "Daniel", "Petter", "Anna", "Gabriel", "Martin", "Martina", "Marcus", "Anthony", "Brad"};
    private final int[] ages = {24, 32, 19, 48, 29, 51, 44, 39, 53, 62};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.list_item_options, names);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener((parent, view, position, id) ->
                tv1.setText(getString(R.string.txt_tv1, lv1.getItemAtPosition(position), ages[position])));
    }
}