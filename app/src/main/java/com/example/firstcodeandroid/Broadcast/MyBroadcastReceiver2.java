package com.example.firstcodeandroid.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver2 extends BroadcastReceiver {
    public MyBroadcastReceiver2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "自定义有序广播接收成功", Toast.LENGTH_SHORT).show();
        abortBroadcast();
        Toast.makeText(context, "截断有序广播成功", Toast.LENGTH_SHORT).show();
    }
}
