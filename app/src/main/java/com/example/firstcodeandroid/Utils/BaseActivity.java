package com.example.firstcodeandroid.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.firstcodeandroid.Broadcast.LoginActivity;

/**
 * Created by JackR on 2018/3/24.
 */

public class BaseActivity extends AppCompatActivity {

    private ForceOffReceiver forceOffReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollection.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollection.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.firstcodeandroid.FORCE_OFFLINE");
        forceOffReceiver = new ForceOffReceiver();
        registerReceiver(forceOffReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(forceOffReceiver!=null){
            unregisterReceiver(forceOffReceiver);
        }
    }

    class ForceOffReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Warning");
            alertDialog.setMessage("您的QQ在其他地方已经登录，请重新登录");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollection.finishAll();
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            alertDialog.show();
        }
    }
}
