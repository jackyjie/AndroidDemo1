package com.example.firstcodeandroid.FunctionCode;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.RemoteViews;

import com.example.firstcodeandroid.Advanced.AlarmService;

import java.util.Date;
import com.example.firstcodeandroid.R;

public class WidgetService extends Service {
    public WidgetService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        UpdateWidget(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    private void UpdateWidget(Intent intent){

        // 获取当前时间
        Date curDate =  new Date(System.currentTimeMillis());
        String   str   =  curDate.toString();

        // 添加到remoteView中
        RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.new_app_widget);
        remoteView.setTextViewText(R.id.appwidget_text, str);

        // 更新widget
        AppWidgetManager awg = AppWidgetManager.getInstance(this);
        awg.updateAppWidget(new ComponentName(this, NewAppWidget.class),
                remoteView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }
}
