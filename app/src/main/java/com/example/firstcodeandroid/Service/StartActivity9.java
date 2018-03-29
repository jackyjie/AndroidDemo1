package com.example.firstcodeandroid.Service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity9 extends AppCompatActivity implements View.OnClickListener{

    private Button thread_test;
    private Button service_test;
    private Button download_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start9);
        thread_test = (Button)findViewById(R.id.thread_test);
        thread_test.setOnClickListener(this);
        service_test = (Button)findViewById(R.id.service_test);
        service_test.setOnClickListener(this);
        download_test = (Button)findViewById(R.id.download_test);
        download_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.thread_test:
                intent = new Intent(this, ThreadTestActivity.class);
                startActivity(intent);
                break;
            case R.id.service_test:
                intent = new Intent(this, MyServiceActivity.class);
                startActivity(intent);
                break;
            case R.id.download_test:
                intent = new Intent(this, DownloadActivity.class);
                startActivity(intent);
                break;
        }
    }
}
