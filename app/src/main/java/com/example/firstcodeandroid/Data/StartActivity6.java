package com.example.firstcodeandroid.Data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity6 extends AppCompatActivity implements View.OnClickListener{

    private Button file_btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start6);
        file_btn1 = (Button)findViewById(R.id.dataTest_btn1);
        file_btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.dataTest_btn1:
                intent = new Intent(this, FileActivity.class);
                startActivity(intent);
                break;
        }
    }
}
