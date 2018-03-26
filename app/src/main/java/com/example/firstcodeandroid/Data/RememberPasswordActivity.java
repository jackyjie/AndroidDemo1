package com.example.firstcodeandroid.Data;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RememberPasswordActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private CheckBox checked;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_password);
        name = (EditText)findViewById(R.id.remember_user_name);
        password = (EditText)findViewById(R.id.remember_user_password);
        checked = (CheckBox)findViewById(R.id.remember_checked);
        btn = (Button)findViewById(R.id.remember_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked.isChecked()) {
                    String _name = name.getText().toString();
                    String _password = password.getText().toString();
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("name", _name);
                    map.put("password", _password);
                    save(map);
                }
            }
        });
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("password");
        HashMap<String, String> map = load(list);
        if(map.containsKey("name")){
            name.setText(map.get("name"));
        }
        if(map.containsKey("password")){
            password.setText(map.get("password"));
        }
    }

    private void save(HashMap<String, String> list){
        SharedPreferences.Editor pref = getSharedPreferences("data", MODE_PRIVATE).edit();
        for(String key :list.keySet()){
            pref.putString(key, list.get(key));
        }
        pref.apply();
        return ;
    }

    private HashMap<String, String> load(List<String> names) {
        HashMap<String, String> map = new HashMap<>();
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        for (String key : names) {
            String result = pref.getString(key, "");
            if(!result.equals("")){
                map.put(key, result);
            }
        }
        return map;
    }
}
