package com.example.firstcodeandroid.Controls;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

/**
 * Created by JackR on 2018/3/22.
 */

public class TitleLayout extends LinearLayout {

    private Button title_back;
    private Button title_edit;

    public TitleLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        title_back = (Button)findViewById(R.id.title_back);
        title_edit = (Button)findViewById(R.id.title_edit);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        title_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击编辑按钮", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
