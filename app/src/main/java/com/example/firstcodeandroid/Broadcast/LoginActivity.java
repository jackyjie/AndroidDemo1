package com.example.firstcodeandroid.Broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firstcodeandroid.MainActivity;
import com.example.firstcodeandroid.R;
import com.example.firstcodeandroid.Utils.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Intent intent = new Intent(LoginActivity.this, ForceDownActivity.class);
                startActivity(intent);
                break;
        }
    }
}
