package com.example.firstcodeandroid.Service;

import android.app.DownloadManager;
import android.app.PendingIntent;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by JackR on 2018/3/28.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer>{

    private static final int TYPE_SUCCESS = 1;
    private static final int TYPE_FAILED= 2;
    private static final int TYPE_PAUSED = 3;
    private static final int TYPE_CANCELED = 4;

    private DownLoadListener listner;

    private boolean isCanceled = false;
    private boolean isPaused = false;
    private int lastProgress;

    public DownloadTask(DownLoadListener listener){
        this.listner = listener;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if(progress > lastProgress){
            listner.onProgress(progress);
            lastProgress =  progress;
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile saveFile = null;
        File file = null;
        try{
            long downloadedlength = 0;
            String downloadurl = params[0];
            String fileName = downloadurl.substring(downloadurl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory +fileName);
            if(file.exists()){
                downloadedlength = file.length();
            }
            long contentLengh = getContentLength(downloadurl);
            if(contentLengh == 0 ){
                return TYPE_FAILED;
            }
            else if(contentLengh == downloadedlength) {
                return TYPE_SUCCESS;
            }
            OkHttpClient  client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE", "bytes="+downloadedlength + "-")
                    .url(downloadurl)
                    .build();
            Response response = client.newCall(request).execute();
            if(response != null){
                is = response.body().byteStream();
                saveFile = new RandomAccessFile(file, "rw");
                saveFile.seek(downloadedlength);
                byte[] b = new byte[1024];
                int total = 0 ;
                int len ;
                while((len = is.read(b))!= -1){
                    if(isCanceled){
                        return TYPE_CANCELED;
                    }
                    else if(isPaused){
                        return TYPE_PAUSED;
                    }
                    else {
                         total += len;
                        saveFile.write(b, 0, len);
                        int progress = (int)((total + downloadedlength) * 100/ contentLengh);
                        publishProgress(progress);
                    }
                }
                response.body().close();
                return TYPE_SUCCESS;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                if(is !=  null){
                    is.close();
                }
                if(saveFile != null) {
                    saveFile.close();
                }
                if(isCanceled && file != null){
                    file.delete();
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return TYPE_FAILED;
    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status){
            case TYPE_SUCCESS:
                listner.onSuccess();
                break ;
            case TYPE_CANCELED:
                listner.onCanceled();
                break;
            case TYPE_FAILED:
                listner.onFailed();
                break;
            case TYPE_PAUSED:
                listner.onPaused();
                break;
        }
    }

    public void PauseDownload(){
        isPaused = true;
    }

    public void CancelDownload(){
        isCanceled = true;
    }

    private long getContentLength(String downloadurl) throws IOException{
//        X509TrustManager trustManager;
//        SSLSocketFactory sslSocketFactory=null;
//        trustManager = new X509TrustManager() {
//            @Override
//            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//
//            }
//            @Override
//            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//
//            }
//
//            public X509Certificate[] getAcceptedIssuers() {
//                return new X509Certificate[0];
//            }
//        };
//
//        try {
//            SSLContext sslContext;
//            sslContext = SSLContext.getInstance("SSL");
//            sslContext.init(null,new X509TrustManager[]{trustManager},null);
//            sslSocketFactory = sslContext.getSocketFactory();
//        } catch (GeneralSecurityException e) {
//            throw new RuntimeException(e);
//        }
//
//        HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
//            @Override
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        };
//        OkHttpClient client = new OkHttpClient.Builder()
//                .hostnameVerifier(DO_NOT_VERIFY)
//                .sslSocketFactory(sslSocketFactory, trustManager)
//                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadurl)
                .build();
        Response response = client.newCall(request).execute();
        if(response!= null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }
        return 0 ;
    }
}
