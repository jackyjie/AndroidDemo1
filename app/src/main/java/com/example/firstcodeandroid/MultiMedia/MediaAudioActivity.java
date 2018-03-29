package com.example.firstcodeandroid.MultiMedia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

import java.io.File;

public class MediaAudioActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mediaPlayer = new MediaPlayer();

    private Button media_test_btn1;
    private Button media_test_btn2;
    private Button media_test_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_audio);
        media_test_btn1 = (Button)findViewById(R.id.media_test_btn1);
        media_test_btn1.setOnClickListener(this);
        media_test_btn2 = (Button)findViewById(R.id.media_test_btn2);
        media_test_btn2.setOnClickListener(this);
        media_test_btn3 = (Button)findViewById(R.id.media_test_btn3);
        media_test_btn3.setOnClickListener(this);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        else {
            initMediaPlayer();
        }
    }

    private void initMediaPlayer(){
        try{
            File file = new File(Environment.getExternalStorageDirectory(), "music.aac");
//            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0 &&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initMediaPlayer();
                }
                else {
                    Toast.makeText(this, "permission denied.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.media_test_btn1:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
                break;
            case R.id.media_test_btn2:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                break;
            case R.id.media_test_btn3:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
