package com.example.firstcodeandroid.Permission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity7 extends AppCompatActivity implements View.OnClickListener{

    private Button permission_btn1;
    private Button permission_btn2;
    private Button permission_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start7);
        permission_btn1 = (Button)findViewById(R.id.persssion_btn1);
        permission_btn1.setOnClickListener(this);
        permission_btn2 = (Button)findViewById(R.id.persssion_btn2);
        permission_btn2.setOnClickListener(this);
        permission_btn3 = (Button)findViewById(R.id.persssion_btn3);
        permission_btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.persssion_btn1:
                intent = new Intent(this, PermissionActivity.class);
                startActivity(intent);
                break;
            case R.id.persssion_btn2:
                intent = new Intent(this, LoadContactsActivity.class);
                startActivity(intent);
                break;
            case R.id.persssion_btn3:
                intent = new Intent(this, ProviderTestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
