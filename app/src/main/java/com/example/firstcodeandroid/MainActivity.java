package com.example.firstcodeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.Advanced.AlarmService;
import com.example.firstcodeandroid.Broadcast.StartActivity5;
import com.example.firstcodeandroid.Data.StartActivity6;
import com.example.firstcodeandroid.Else.StartActivity3;
import com.example.firstcodeandroid.FunctionCode.FunctionCodeActivity;
import com.example.firstcodeandroid.Intent.StartActivity1;
import com.example.firstcodeandroid.Menu.MenuTest;
import com.example.firstcodeandroid.MultiMedia.StartActivity8;
import com.example.firstcodeandroid.Permission.StartActivity7;
import com.example.firstcodeandroid.Service.StartActivity9;
import com.example.firstcodeandroid.Views.ElseListView.ListView1Activity;
import com.example.firstcodeandroid.Views.StartActivity2;
import com.example.firstcodeandroid.Views.padView.StartActivity4;
import com.example.firstcodeandroid.Web.StartActivity10;
import com.example.firstcodeandroid.map.StartActivity11;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button menu_test = (Button)findViewById(R.id.menu_test);
        Button virtual_intent_test = (Button)findViewById(R.id.virtual_intent_test);
        Button view_test = (Button)findViewById(R.id.view_test);
        Button elseFunction = (Button)findViewById(R.id.elseFunction);
        Button padTest = (Button)findViewById(R.id.padFunction);
        Button broadcast = (Button)findViewById(R.id.broadcast);
        Button data_test = (Button)findViewById(R.id.data_test);
        Button runtime_permission_test = (Button)findViewById(R.id.runtime_permission_test);
        Button media_test = (Button)findViewById(R.id.media_test);
        Button service_test = (Button)findViewById(R.id.service_test);
        Button web_test = (Button)findViewById(R.id.web_test);
        Button map_test = (Button)findViewById(R.id.map_test);
        Button practise_test = (Button)findViewById(R.id.practise_test);
        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
//        Button remoteView = (Button)findViewById(R.id.remoteView);
        menu_test.setOnClickListener(this);
        virtual_intent_test.setOnClickListener(this);
        view_test.setOnClickListener(this);
        elseFunction.setOnClickListener(this);
        padTest.setOnClickListener(this);
        broadcast.setOnClickListener(this);
        data_test.setOnClickListener(this);
        runtime_permission_test.setOnClickListener(this);
        media_test.setOnClickListener(this);
        service_test.setOnClickListener(this);
        web_test.setOnClickListener(this);
        map_test.setOnClickListener(this);
        practise_test.setOnClickListener(this);
        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
//        remoteView.setOnClickListener(this);
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
            case R.id.runtime_permission_test:
                intent  = new Intent(this, StartActivity7.class);
                startActivity(intent);
                break;
            case R.id.media_test:
                intent = new Intent(this, StartActivity8.class);
                startActivity(intent);
                break;
            case R.id.service_test:
                intent = new Intent(this, StartActivity9.class);
                startActivity(intent);
                break;
            case R.id.web_test:
                intent = new Intent(this, StartActivity10.class);
                startActivity(intent);
                break;
            case R.id.map_test:
//                intent = new Intent(this, AlarmService.class);
//                startService(intent);
                intent = new Intent(this, StartActivity11.class);
                startActivity(intent);
                break;
            case R.id.remoteView:
                intent = new Intent(this, FunctionCodeActivity.class);
                startActivity(intent);
                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.practise_test:
//                intent = new Intent(this, ListView1Activity.class);
//                startActivity(intent);
//                break;

        }
    }
}
