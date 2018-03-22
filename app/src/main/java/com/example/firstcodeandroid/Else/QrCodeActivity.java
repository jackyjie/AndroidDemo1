package com.example.firstcodeandroid.Else;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.firstcodeandroid.R;
import com.example.firstcodeandroid.Utils.QrCodeUtil;

public class QrCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ImageView image_view = (ImageView)findViewById(R.id.image_view);
        Bitmap bitmap = QrCodeUtil.createQRCodeBitmap("http://localhost", 480, 480);
        image_view.setImageBitmap(bitmap);
    }
}
