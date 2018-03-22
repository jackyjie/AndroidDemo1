package com.example.firstcodeandroid.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.firstcodeandroid.R;

public class StartActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button gravity_test;
    private Button LinearLayout_test;
    private Button LinearLayout_test2;
    private Button RelativeLayout_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);
        gravity_test = (Button)findViewById(R.id.gravity_test);
        gravity_test.setOnClickListener(this);
        LinearLayout_test = (Button)findViewById(R.id.LinearLayout_test);
        LinearLayout_test.setOnClickListener(this);
        LinearLayout_test2 = (Button)findViewById(R.id.LinearLayout_test2);
        LinearLayout_test2.setOnClickListener(this);
        RelativeLayout_test = (Button)findViewById(R.id.relative_layout_test);
        RelativeLayout_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.gravity_test:
                intent = new Intent(this, TextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.LinearLayout_test:
                intent = new Intent(this, LinearLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.LinearLayout_test2:
                intent = new Intent(this, LinearLayoutActivity2.class);
                startActivity(intent);
                break;
            case R.id.relative_layout_test:
                intent = new Intent(this, RelativeLayoutTest.class);
                startActivity(intent);
                break;
        };
    }
}
