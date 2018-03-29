package com.example.firstcodeandroid.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;

public class MyServiceActivity extends AppCompatActivity {

    private static final String TAG = "MyServiceActivity";
    private MyService.DownloadBinder binder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyService.DownloadBinder)service;
            binder.startDownload();
            binder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        Button start = (Button)findViewById(R.id.myservice_start);
        Button stop = (Button)findViewById(R.id.myservice_stop);
        Button bindService = (Button)findViewById(R.id.bindservice);
        Button unbindService = (Button)findViewById(R.id.unbindservice);
        Button intentService = (Button)findViewById(R.id.startMyIntentService);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyServiceActivity.this, MyService.class);
                startService(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopService = new Intent(MyServiceActivity.this, MyService.class);
                stopService(stopService);
            }
        });
        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent(MyServiceActivity.this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
            }
        });
        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });
        intentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Thread id is " + Thread.currentThread().getId());
                Intent newIntent = new Intent(MyServiceActivity.this, MyIntentService.class);
                startService(newIntent);
            }
        });
    }
}
