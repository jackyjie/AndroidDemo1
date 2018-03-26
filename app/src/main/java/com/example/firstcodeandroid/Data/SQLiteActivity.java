package com.example.firstcodeandroid.Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener{

    private Button create_book;
    private Button add_data;
    private Button delete_data;
    private Button change_data;
    private Button search_data;
    private MyDataBaseHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        helper = new MyDataBaseHelper(this, "BookStore.db", null, 3);
        create_book = (Button)findViewById(R.id.create_database);
        create_book.setOnClickListener(this);
        add_data = (Button)findViewById(R.id.add_data);
        add_data.setOnClickListener(this);
        delete_data = (Button)findViewById(R.id.delete_data);
        delete_data.setOnClickListener(this);
        change_data = (Button)findViewById(R.id.change_data);
        change_data.setOnClickListener(this);
        search_data = (Button)findViewById(R.id.search_data);
        search_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_database:
                db = helper.getWritableDatabase();
                break;
            case R.id.add_data:
                db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "Tom");
                values.put("author", "Jack");
                values.put("pages", 454);
                values.put("price", 25.5);
                db.insert("Book", null, values);
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_data:
                db = helper.getWritableDatabase();
                db.delete("Book", "pages>?", new String[]{"10"});
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_data:
                db = helper.getWritableDatabase();
                ContentValues values2 = new ContentValues();
                values2.put("price", 122.2);
                db.update("Book",values2, "name=?", new String[] {"Tom"});
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_data:
                db = helper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null,null, null, null, null);
                if(cursor.moveToFirst()){
                    do{
                        // 遍历打印
                        String name  = cursor.getString(cursor.getColumnIndex("name"));
                        int pages  = cursor.getInt(cursor.getColumnIndex("pages"));
                        Toast.makeText(this, name + Integer.toString(pages), Toast.LENGTH_SHORT).show();
                    }while(cursor.moveToNext());
                }
                cursor.close();
                break;
        }
    }
}
