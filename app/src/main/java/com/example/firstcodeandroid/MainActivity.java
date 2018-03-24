package com.example.firstcodeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.Broadcast.StartActivity5;
import com.example.firstcodeandroid.Data.StartActivity6;
import com.example.firstcodeandroid.Else.StartActivity3;
import com.example.firstcodeandroid.Intent.StartActivity1;
import com.example.firstcodeandroid.Menu.MenuTest;
import com.example.firstcodeandroid.Views.StartActivity2;
import com.example.firstcodeandroid.Views.padView.StartActivity4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button menu_test;
    private Button virtual_intent_test;
    private Button view_test;
    private Button elseFunction;
    private Button padTest;
    private Button broadcast;
    private Button data_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_test = (Button)findViewById(R.id.menu_test);
        virtual_intent_test = (Button)findViewById(R.id.virtual_intent_test);
        menu_test.setOnClickListener(this);
        virtual_intent_test.setOnClickListener(this);
        view_test = (Button)findViewById(R.id.view_test);
        view_test.setOnClickListener(this);
        elseFunction = (Button)findViewById(R.id.elseFunction);
        elseFunction.setOnClickListener(this);
        padTest = (Button)findViewById(R.id.padFunction);
        padTest.setOnClickListener(this);
        broadcast = (Button)findViewById(R.id.broadcast);
        broadcast.setOnClickListener(this);
        data_test = (Button)findViewById(R.id.data_test);
        data_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.menu_test:
                intent = new Intent(this, MenuTest.class);
                startActivity(intent);
                break;
            case R.id.virtual_intent_test:
                intent =new Intent(this, StartActivity1.class);
                startActivity(intent);
                break;
            case R.id.view_test:
                intent = new Intent(this, StartActivity2.class);
                startActivity(intent);
                break;
            case R.id.elseFunction:
                intent = new Intent(this, StartActivity3.class);
                startActivity(intent);
                break;
            case R.id.padFunction:
                intent = new Intent(this, StartActivity4.class);
                startActivity(intent);
                break;
            case R.id.broadcast:
                intent = new Intent(this, StartActivity5.class);
                startActivity(intent);
                break;
            case R.id.data_test:
                intent = new Intent(this, StartActivity6.class);
                startActivity(intent);
                break;

        }
    }
}
