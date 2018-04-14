package com.example.firstcodeandroid.Else;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;
//import com.google.zxing.client.android.CaptureActivity;

public class StartActivity3 extends AppCompatActivity implements View.OnClickListener{

    private Button qr_code;
    private Button qr_code_logo;
    private Button qr_code_find;
    private Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start3);
        qr_code = (Button)findViewById(R.id.Else_btn1);
        qr_code.setOnClickListener(this);
        qr_code_logo = (Button)findViewById(R.id.else_btn2);
        qr_code_logo.setOnClickListener(this);
        qr_code_find = (Button)findViewById(R.id.else_btn3);
        qr_code_find.setOnClickListener(this);
        cal= (Button)findViewById(R.id.else_btn4);
        cal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.Else_btn1:
                intent = new Intent(this, QrCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.else_btn2:
                intent = new Intent(this, QrCodeLogoActivity.class);
                startActivity(intent);
                break;
            case R.id.else_btn3:
//                intent = new Intent(this, CaptureActivity.class);
//                startActivity(intent);
                break ;
            case R.id.else_btn4:
                intent = new Intent(this, CalculateActivity.class);
                startActivity(intent);
                break;
        }
    }
}
