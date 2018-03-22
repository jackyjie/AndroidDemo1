package com.example.firstcodeandroid.Intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class StartActivity1 extends AppCompatActivity implements View.OnClickListener{

    private Button intent_btn1;
    private Button intent_btn2;
    private Button intent_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start1);
        intent_btn1 = (Button)findViewById(R.id.intent_btn1);
        intent_btn2 = (Button)findViewById(R.id.intent_btn2);
        intent_btn3 = (Button)findViewById(R.id.intent_btn3);
        intent_btn1.setOnClickListener(this);
        intent_btn2.setOnClickListener(this);
        intent_btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.intent_btn1:
                intent = new Intent("com.example.firstcodeandroid.ACTION_START");
                startActivity(intent);
                break;
            case R.id.intent_btn2:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.intent_btn3:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;
        }
    }
}
