package com.example.firstcodeandroid.FunctionCode;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.firstcodeandroid.R;

public class aRemoteViewDemo extends AppCompatActivity implements View.OnClickListener{

    private NotificationManager manager;
    private Notification notification;
    private RemoteViews remoteViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_remote_view_demo);
        Button remoteOut = (Button)findViewById(R.id.remoteOut);
        Button remoteChange = (Button)findViewById(R.id.remoteChange);
        Button remoteWidget = (Button)findViewById(R.id.remoteWidget);
        remoteOut.setOnClickListener(this);
        remoteChange.setOnClickListener(this);
        remoteWidget.setOnClickListener(this);

        // 1.创建remote实例
        remoteViews = new RemoteViews("com.example.firstcodeandroid", R.layout.aa_remote_view);
        remoteViews.setImageViewResource(R.id.remote_image, R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.remote_content, "这是remoteView");


        // 2.构建IntentPending
        Intent intent = new Intent(this, aRemoteViewDemo.class);
        intent.addFlags(PendingIntent.FLAG_UPDATE_CURRENT);

        // 3.创建notification
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        notification = new Notification.Builder(this)
                .setContentText("这是通知")
                .setContentTitle("这是通知标题")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContent(remoteViews)
                .build();

        // 4.获取Manager
        manager = (NotificationManager)getSystemService(this.NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remoteOut:
                out();
                break;
            case R.id.remoteChange:
                change();
                break;
            case R.id.remoteWidget:
                start();
                break;
        }
    }

    private void out(){

        manager.notify(1, notification);
    }

    private void change(){

        remoteViews.setTextViewText(R.id.remote_content, "改变了内容");  // 添加Action
        manager.notify(1, notification); // 获取Action ApplyAction=>加载布局
    }

    private void start(){

        Intent intent = new Intent(this, WidgetService.class);
        startService(intent);
    }
}
