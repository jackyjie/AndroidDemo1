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

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button create_book;
    private Button add_data;
    private Button delete_data;
    private Button change_data;
    private Button search_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        create_book = (Button)findViewById(R.id.create_database_pal);
        create_book.setOnClickListener(this);
        add_data = (Button)findViewById(R.id.add_data_pal);
        add_data.setOnClickListener(this);
        delete_data = (Button)findViewById(R.id.delete_data_pal);
        delete_data.setOnClickListener(this);
        change_data = (Button)findViewById(R.id.change_data_pal);
        change_data.setOnClickListener(this);
        search_data = (Button)findViewById(R.id.search_data_pal);
        search_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Book book;
        switch (v.getId()){
            case R.id.create_database_pal:
                Connector.getDatabase();
                break;
            case R.id.add_data_pal:
                book = new Book();
                book.setName("Tom");
                book.setAuthor("Jack");
                book.setPages(454);
                book.setPrice(25.5);
                book.save();
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_data_pal:
                DataSupport.deleteAll(Book.class, "price>?", "10");
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_data_pal:
                book = new Book();
                book.setPrice(122.2);
                book.updateAll("name=?", "Tom");
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_data_pal:
                List<Book> list = DataSupport.select("name", "pages", "price")
                        .where("pages>?", "10")
                        .order("pages")
                        .limit(10).offset(0)
                        .find(Book.class);
                for(Book item : list){
                    Toast.makeText(this, item.getName()+"|"+item.getPages()+"|"+ item.getPrice(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

