package com.example.firstcodeandroid.Views.ListView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity22 extends AppCompatActivity implements View.OnClickListener {

    private Button listview_view;
    private Button listview_view2;
    private Button listview_view3;
    private Button listview_view4;
    private Button listview_view5;
    private Button listview_view6;
    private Button listview_view7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start22);
        listview_view = (Button)findViewById(R.id.listView_btn1);
        listview_view.setOnClickListener(this);
        listview_view2 = (Button)findViewById(R.id.listView_btn2);
        listview_view2.setOnClickListener(this);
        listview_view3 = (Button)findViewById(R.id.listView_btn3);
        listview_view3.setOnClickListener(this);
        listview_view4 = (Button)findViewById(R.id.listView_btn4);
        listview_view4.setOnClickListener(this);
        listview_view5 = (Button)findViewById(R.id.listView_btn5);
        listview_view5.setOnClickListener(this);
        listview_view6 = (Button)findViewById(R.id.listView_btn6);
        listview_view6.setOnClickListener(this);
        listview_view7 = (Button)findViewById(R.id.listView_btn7);
        listview_view7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.listView_btn1:
                intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.listView_btn2:
                intent = new Intent(this, ListViewActivity2.class);
                startActivity(intent);
                break;
            case R.id.listView_btn3:
                intent = new Intent(this, RecycleViewActivity.class);
                startActivity(intent);
                break;
            case R.id.listView_btn4:
                intent = new Intent(this,RecycleViewVerticalActivity.class);
                startActivity(intent);
                break;
            case R.id.listView_btn5:
                intent = new Intent(this,RecycleViewPoolActivity.class);
                startActivity(intent);
                break;
            case R.id.listView_btn6:
                intent = new Intent(this,RecycleViewClickActivity.class);
                startActivity(intent);
                break;
            case R.id.listView_btn7:
                intent = new Intent(this,NinePatchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
