package com.example.firstcodeandroid.Broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.R;
import com.example.firstcodeandroid.Utils.BaseActivity;

public class ForceDownActivity extends BaseActivity {

    private Button login_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_down);
        login_down = (Button)findViewById(R.id.login_down);
        login_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.firstcodeandroid.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
