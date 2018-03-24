package com.example.firstcodeandroid.Views.padView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity4 extends AppCompatActivity implements View.OnClickListener {

    private Button fragment;
    private Button fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start4);
        fragment = (Button)findViewById(R.id.padText_btn1);
        fragment.setOnClickListener(this);
        fragment2 = (Button)findViewById(R.id.padText_btn2);
        fragment2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.padText_btn1:
                intent = new Intent(this, FragmentTest.class);
                startActivity(intent);
                break;
            case R.id.padText_btn2:
                intent = new Intent(this, FragmentTest2.class);
                startActivity(intent);
                break;
        }
    }
}
