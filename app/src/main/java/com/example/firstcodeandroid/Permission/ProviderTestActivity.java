package com.example.firstcodeandroid.Permission;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstcodeandroid.Data.MyDataBaseHelper;
import com.example.firstcodeandroid.R;

public class ProviderTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button create_book;
    private Button add_data;
    private Button delete_data;
    private Button change_data;
    private Button search_data;
    private Button create_book2;
    private Button add_data2;
    private Button delete_data2;
    private Button change_data2;
    private Button search_data2;
    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_test);
        create_book = (Button)findViewById(R.id.create_database_provider);
        create_book.setOnClickListener(this);
        add_data = (Button)findViewById(R.id.add_data_provider);
        add_data.setOnClickListener(this);
        delete_data = (Button)findViewById(R.id.delete_data_provider);
        delete_data.setOnClickListener(this);
        change_data = (Button)findViewById(R.id.change_data_provider);
        change_data.setOnClickListener(this);
        search_data = (Button)findViewById(R.id.search_data_provider);
        search_data.setOnClickListener(this);
        create_book2 = (Button)findViewById(R.id.create_database_provider2);
        create_book2.setOnClickListener(this);
        add_data2 = (Button)findViewById(R.id.add_data_provider2);
        add_data2.setOnClickListener(this);
        delete_data2 = (Button)findViewById(R.id.delete_data_provider2);
        delete_data2.setOnClickListener(this);
        change_data2 = (Button)findViewById(R.id.change_data_provider2);
        change_data2.setOnClickListener(this);
        search_data2 = (Button)findViewById(R.id.search_data_provider2);
        search_data2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Uri uri;
        Uri newUri;
        Cursor cursor;
        switch (v.getId()){
            case R.id.create_database_provider:
                break;
            case R.id.add_data_provider:
                uri = Uri.parse("content://com.example.databasetest.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "Tom");
                values.put("author", "Jack");
                values.put("pages", 454);
                values.put("price", 25.5);
                newUri = getContentResolver().insert(uri, values);
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_data_provider:
                newId = "1";
                uri = Uri.parse("content://com.example.databasetest.provider/book/"+newId);
                getContentResolver().delete(uri, null, null);
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_data_provider:
                newId = "1";
                uri = Uri.parse("content://com.example.databasetest.provider/book/"+newId);
                ContentValues values2 = new ContentValues();
                values2.put("price", 122.2);
                getContentResolver().update(uri, values2, null, null);
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_data_provider:
                uri = Uri.parse("content://com.example.databasetest.provider/book");
                cursor = getContentResolver().query(uri, null, null, null, null);
                if(cursor!=null){
                    while(cursor.moveToNext()){
                        // 遍历打印
                        String name  = cursor.getString(cursor.getColumnIndex("name"));
                        int pages  = cursor.getInt(cursor.getColumnIndex("pages"));
                        Toast.makeText(this, name + Integer.toString(pages), Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                }
                break;
        }
    }
}
