package com.example.firstcodeandroid.FunctionCode;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class FunctionCodeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_code);
        Button remoteView1 = (Button)findViewById(R.id.remoteView1);
        remoteView1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.remoteView1:
                intent = new Intent(this, aRemoteViewDemo.class);
                startActivity(intent);
                break;
        }
    }
}
