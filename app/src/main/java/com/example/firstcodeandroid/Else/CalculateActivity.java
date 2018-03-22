package com.example.firstcodeandroid.Else;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText cal_a;
    private EditText cal_b;
    private EditText cal_result;
    private Button cal_to;
    private Spinner spinner;

    private int a = 0 ;
    private int b = 0 ;
    private String method = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        cal_a = (EditText)findViewById(R.id.cal_a);
        cal_b = (EditText)findViewById(R.id.cal_b);
        cal_result = (EditText)findViewById(R.id.cal_result);
        cal_to = (Button)findViewById(R.id.cal_to);
        cal_to.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.cal_method);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.languages);
                method = languages[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cal_to:
                // 验证
                if(Judge()) {
                    int result = 0 ;
                    switch (method){
                        case "-":
                            result = a-b;
                            break;
                        case "/":
                            result = a/b;
                            break;
                        case "*":
                            result = a* b;
                            break ;
                        case "+":
                            result = a+b;
                            break ;
                    }
                cal_result.setText(Integer.toString(result));
            }
        }
    }

    private boolean Judge(){
        if(cal_a.getText().equals("") || cal_b.getText().equals("")){
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            a = Integer.parseInt(cal_a.getText().toString());
            b = Integer.parseInt(cal_b.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(this, "不能为非数字", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(method == "/" && b == 0){
            Toast.makeText(this, "除法不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
