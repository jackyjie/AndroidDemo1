package com.example.firstcodeandroid.Broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity5 extends AppCompatActivity implements View.OnClickListener{

    private Button broadcast_btn1;
    private Button broadcast_btn2;
    private Button broadcast_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start5);
        broadcast_btn1 = (Button)findViewById(R.id.broadcast_btn1);
        broadcast_btn1.setOnClickListener(this);
        broadcast_btn2 = (Button)findViewById(R.id.broadcast_btn2);
        broadcast_btn2.setOnClickListener(this);
        broadcast_btn3 = (Button)findViewById(R.id.broadcast_btn3);
        broadcast_btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.broadcast_btn1:
                intent = new Intent(this, BroadcastActivity.class);
                startActivity(intent);
                break;
            case R.id.broadcast_btn2:
                intent = new Intent(this, BroadcastCustomStandardActivity.class);
                startActivity(intent);
                break;
            case R.id.broadcast_btn3:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
