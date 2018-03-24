package com.example.firstcodeandroid.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

public class BroadcastCustomStandardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button custom_broadcast;
    private Button custom_broadcast2;
    private Button custom_broadcast3;

    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_custom_standard);
        custom_broadcast = (Button)findViewById(R.id.custom_broadcast_send);
        custom_broadcast.setOnClickListener(this);
        custom_broadcast2 = (Button)findViewById(R.id.custom_broadcast_send2);
        custom_broadcast2.setOnClickListener(this);
        custom_broadcast3 = (Button)findViewById(R.id.custom_broadcast_send3);
        custom_broadcast3.setOnClickListener(this);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.firstcodeandroid.MY_BROADCAST3");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.custom_broadcast_send:
                intent = new Intent("com.example.firstcodeandroid.MY_BROADCAST");
                sendBroadcast(intent);
                break;
            case R.id.custom_broadcast_send2:
                intent = new Intent("com.example.firstcodeandroid.MY_BROADCAST2");
                sendOrderedBroadcast(intent, null);
                break;
            case R.id.custom_broadcast_send3:
                intent = new Intent("com.example.firstcodeandroid.MY_BROADCAST3");
                localBroadcastManager.sendBroadcast(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "接收到本地广播", Toast.LENGTH_SHORT).show();
        }
    }
}
