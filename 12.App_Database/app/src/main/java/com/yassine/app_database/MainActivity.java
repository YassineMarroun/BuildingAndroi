package com.yassine.app_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_code, et_description, et_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_code = findViewById(R.id.txt_code);
        et_description = findViewById(R.id.txt_description);
        et_price = findViewById(R.id.txt_price);
    }

    //Register button method
    public void Register(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase dataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();
        String description = et_description.getText().toString();
        String price = et_price.getText().toString();

        if(!code.isEmpty() && !description.isEmpty() && !price.isEmpty()) {
            ContentValues registry = new ContentValues();
            registry.put("code", code);
            registry.put("description", description);
            registry.put("price", price);

            dataBase.insert("articles", null, registry);
            dataBase.close();
            et_code.setText("");
            et_description.setText("");
            et_price.setText("");

            Toast.makeText(this, "Successful registration", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Need to fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    //Search button method
    public void Search(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase baseOfDataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();

        if(!code.isEmpty()) {
            Cursor row = baseOfDataBase.rawQuery("select description, price from articles where code = " + code, null);

            if(row.moveToFirst()) {
                et_description.setText(row.getString(0));
                et_price.setText(row.getString(1));
            } else {
                Toast.makeText(this, "Article does not exist", Toast.LENGTH_SHORT).show();
            }
            baseOfDataBase.close();
            row.close();
        } else {
            Toast.makeText(this, "Need to enter the item code", Toast.LENGTH_SHORT).show();
        }
    }

    //Modify button method
    public void Modify(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase baseOfDataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();
        String description = et_description.getText().toString();
        String price = et_price.getText().toString();

        if(!code.isEmpty() && !description.isEmpty() && !price.isEmpty()) {

            ContentValues registry = new ContentValues();
            registry.put("code", code);
            registry.put("description", description);
            registry.put("price", price);

            int quantity = baseOfDataBase.update("articles", registry, "code = " + code, null);
            baseOfDataBase.close();

            if(quantity == 1) {
                Toast.makeText(this, "Item modified successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Article does not exist", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Need to fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    //Delete button method
    public void Delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase baseOfDataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();

        if(!code.isEmpty()) {
            int quantity = baseOfDataBase.delete("articles", "code = " + code, null);
            baseOfDataBase.close();

            et_code.setText("");
            et_description.setText("");
            et_price.setText("");

            if(quantity == 1) {
                Toast.makeText(this, "Item removed successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Article does not exist", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Need to enter the item code", Toast.LENGTH_SHORT).show();
        }
    }
}