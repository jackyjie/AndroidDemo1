package com.example.firstcodeandroid.Views;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Process;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.firstcodeandroid.MainActivity;
import com.example.firstcodeandroid.R;

public class TextViewActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_text;
    private Button views_btn1;
    private ImageView image_view;
    private Button views_btn2;
    private Button views_btn3;
    private ProgressBar progress_bar;
    private ProgressBar progress_bar2;
    private Button views_btn4;
    private Button views_btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        edit_text = (EditText)findViewById(R.id.edit_text);
        image_view = (ImageView) findViewById(R.id.image_view);
        views_btn1 = (Button)findViewById(R.id.views_btn1);
        views_btn1.setOnClickListener(this);
        views_btn2 = (Button)findViewById(R.id.views_btn2);
        views_btn2.setOnClickListener(this);
        progress_bar = (ProgressBar)findViewById(R.id.progressbar_test);
        progress_bar2 = (ProgressBar)findViewById(R.id.progressbar_test);
        views_btn3 = (Button)findViewById(R.id.views_btn3);
        views_btn3.setOnClickListener(this);
        views_btn4 = (Button)findViewById(R.id.views_btn4);
        views_btn4.setOnClickListener(this);
        views_btn5 = (Button)findViewById(R.id.views_btn5);
        views_btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.views_btn1:
                image_view.setImageResource(R.drawable.apply_32x32);
                break;
            case R.id.views_btn2:
                if(progress_bar.getVisibility() == View.GONE){
                    progress_bar.setVisibility(View.VISIBLE);
                }
                else{
                    progress_bar.setVisibility(View.GONE);
                }
                break;
            case R.id.views_btn3:
                int progress = progress_bar2.getProgress();
                progress = progress + 10;
                progress_bar2.setProgress(progress);
                break;
            case R.id.views_btn4:
                AlertDialog.Builder dialog = new AlertDialog.Builder(TextViewActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.views_btn5:
                ProgressDialog dialog1 = new ProgressDialog(TextViewActivity.this);
                dialog1.setTitle("This is ProgressDialog");
                dialog1.setMessage("Loading....");
                dialog1.setCancelable(true);
                dialog1.show();
                break;
        }
    }
}
