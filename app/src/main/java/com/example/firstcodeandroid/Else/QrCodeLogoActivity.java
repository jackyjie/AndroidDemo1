package com.example.firstcodeandroid.Else;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.firstcodeandroid.R;
import com.example.firstcodeandroid.Utils.QrCodeUtil;

public class QrCodeLogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_logo);
        ImageView image_view = (ImageView)findViewById(R.id.qr_image_view);
        Bitmap bitmap = QrCodeUtil.createQRCodeBitmap("http://localhost", 480, 480);
        Bitmap logobitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Bitmap resultbitmap = QrCodeUtil.addLogo(bitmap, logobitmap);
        image_view.setImageBitmap(resultbitmap);
    }
}
