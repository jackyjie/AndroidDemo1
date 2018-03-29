package com.example.firstcodeandroid.Service;

/**
 * Created by JackR on 2018/3/28.
 */

public interface DownLoadListener {

    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
