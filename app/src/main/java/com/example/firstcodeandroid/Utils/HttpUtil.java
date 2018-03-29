package com.example.firstcodeandroid.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by JackR on 2018/3/28.
 */

public class HttpUtil {
    /*
    * httpUrlConnection  sendRequest
    * address 地址
    * listener 回调函数
    * */
    public static  void sendHttpRequest(final String address, final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try{
                    URL url = new URL(address);
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line= reader.readLine()) != null){
                        response.append(line);
                    }
                    if(listener != null)
                    {
                        listener.onFinish(response.toString());
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    if(listener != null){
                        listener.onError(ex);
                    }
                }
                finally {
                    if(connection != null){
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }

    /*
    * Okhttp sendRequest
    * address 地址
    * okHttp3.callback 回调函数
    * */
    public void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
