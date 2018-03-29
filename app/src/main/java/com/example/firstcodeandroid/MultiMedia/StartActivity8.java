package com.example.firstcodeandroid.MultiMedia;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.provider.DocumentFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

import java.io.File;
import java.io.FileNotFoundException;

public class StartActivity8 extends AppCompatActivity implements View.OnClickListener{

    private Button media_btn1;
    private Button media_btn2;
    private Button media_btn3;
    private Button camera_btn4;
    private Button camera_btn5;
    private Button media_btn6;

    private static final int TAKE_PHOTO = 1;
    private static final int CHOOSE_PHOTO = 2;
    private ImageView picture;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start8);
        media_btn1 = (Button)findViewById(R.id.media_btn1);
        media_btn1.setOnClickListener(this);
        media_btn2 = (Button)findViewById(R.id.media_btn2);
        media_btn2.setOnClickListener(this);
        media_btn3 = (Button)findViewById(R.id.media_btn3);
        media_btn3.setOnClickListener(this);
        camera_btn4 = (Button)findViewById(R.id.camera_btn4);
        camera_btn4.setOnClickListener(this);
        camera_btn5 = (Button)findViewById(R.id.camera_btn5);
        camera_btn5.setOnClickListener(this);
        media_btn6 = (Button)findViewById(R.id.media_btn6);
        media_btn6.setOnClickListener(this);
        picture = (ImageView)findViewById(R.id.camera_picture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode == RESULT_OK){
                    try{
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    }
                    catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if(resultCode == RESULT_OK){
                    if(Build.VERSION.SDK_INT >= 19){
                        handleImageOnKitKat(data);
                    }
                    else {
                        handleImageBeforeKitKat(data);
                    }
                }
            default:
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat (Intent data){
        String imagePath= null;
        Uri uri = data.getData();
        if(DocumentsContract.isDocumentUri(this, uri)){
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID +"="+id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        }
        else if("content".equalsIgnoreCase(uri.getScheme())) {
            imagePath = getImagePath(uri, null);
        }
        else if("file".equalsIgnoreCase(uri.getScheme())){
            imagePath = uri.getPath();
        }
        displayImage(imagePath);
    }

    private void handleImageBeforeKitKat(Intent data){
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }

    private String getImagePath(Uri uri, String selection){
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if(cursor != null){
            if(cursor.moveToNext()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String path){
        if(path != null){
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            picture.setImageBitmap(bitmap);
        }
        else {
            Toast.makeText(this, "fail to get image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        NotificationManager manager;
        Notification notification;
        Intent intent;
        PendingIntent pi;
        switch (v.getId()) {
            case R.id.media_btn1:
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.launcher_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.drawable.launcher_icon))
                        .build();
                manager.notify(1, notification);
                break;

            case R.id.media_btn2:
                intent = new Intent(this, NotificationActivity.class);
                pi = PendingIntent.getActivity(this, 0, intent, 0);
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.launcher_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.drawable.launcher_icon))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Harp.ogg")))
                        //.setVibrate(new long[]{0, 1000, 1000, 1000})
                        .setLights(Color.GREEN, 1000, 1000)
                        //.setDefaults(NotificationCompat.DEFAULT_ALL)
                        .build();
                manager.notify(1, notification);
                break;
            case R.id.media_btn3:
                intent = new Intent(this, NotificationActivity.class);
                pi = PendingIntent.getActivity(this, 0, intent, 0);
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is content text.This is content text.This is content text."
                                + "This is content text.This is content text.This is content text."
                                + "This is content text.This is content text.This is content text."
                                + "This is content text."))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.launcher_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.drawable.launcher_icon))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
                break;
            case R.id.camera_btn4:
                File outputImage = new File(getExternalCacheDir(), "out_image.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(StartActivity8.this,
                            "com.example.firstcodeandroid.fileprovider", outputImage);
                } else {
                    imageUri = Uri.fromFile(outputImage);
                }

                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
                break;
            case R.id.camera_btn5:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(StartActivity8.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    choosePhoto();
                }
                break;
            case R.id.media_btn6:
                intent = new Intent(this, MediaAudioActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0 &&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    choosePhoto();
                }
                else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
                }
                break ;
        }
    }

    private void choosePhoto(){
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, CHOOSE_PHOTO);
    }
}
