package com.example.firstcodeandroid.Utils;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by JackR on 2018/3/29.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }

    public static Context getContext(){
        return context;
    }
}
