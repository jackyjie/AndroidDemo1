package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.firstcodeandroid.R;

public class ListViewActivity extends AppCompatActivity {

    private  String[] data = {"Apple", "Banana", "Orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView)findViewById(R.id.listView_view);
        listView.setAdapter(adapter);
    }
}
