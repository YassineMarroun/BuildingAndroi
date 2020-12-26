package com.yassine.app_overflowmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method to show and hide the menu
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Method to assign corresponding functions to options
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.item1) {
            Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item2) {
            Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item3) {
            Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}