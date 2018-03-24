package com.example.firstcodeandroid.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input;
    private Button file_save;
    private Button file_get;
    private Button share_save;
    private Button share_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        input = (EditText) findViewById(R.id.file_input);
        file_save = (Button) findViewById(R.id.file_send);
        file_get = (Button)findViewById(R.id.file_get);
        file_save.setOnClickListener(this);
        file_get.setOnClickListener(this);
        share_save = (Button) findViewById(R.id.share_send);
        share_get = (Button)findViewById(R.id.share_get);
        share_save.setOnClickListener(this);
        share_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.file_send:
                String input_text = input.getText().toString();
                if(input_text.equals("")){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                save(input_text);
                Toast.makeText(this, "文件存入成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.file_get:
                String input_text2 = load();
                Toast.makeText(this, "文件读取：" + input_text2, Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_send:
                String input_text3 = input.getText().toString();
                if(input_text3.equals("")){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                shareSave("name", input_text3);
                Toast.makeText(this, "文件存入成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_get:
                String input_text4 = shareLoad("name");
                Toast.makeText(this, "文件读取：" + input_text4, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void shareSave(String name, String data){
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString(name, data);
        editor.apply();
    }

    public String shareLoad(String name){
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        return pref.getString(name, "");
    }


    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try{
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine()) != null){
                builder.append(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return builder.toString();
    }

    public void save(String data){
        FileOutputStream stream = null;
        BufferedWriter write = null;
        try{
            stream = openFileOutput("data", Context.MODE_PRIVATE);
            write = new BufferedWriter(new OutputStreamWriter(stream));
            write.write(data);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                if(write != null){
                    write.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
