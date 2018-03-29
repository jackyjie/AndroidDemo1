package com.example.firstcodeandroid.Utils;

/**
 * Created by JackR on 2018/3/28.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception ex);
}
