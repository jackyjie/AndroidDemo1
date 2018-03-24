package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

public class NinePatchActivity extends AppCompatActivity implements View.OnClickListener {

    private List<NinePatchMsg> msgList = new ArrayList<>();
    private Button send_btn ;
    private EditText text_edit;
    private RecyclerView recyclerView;
    private NinePatchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_patch);
        initMsg();
        recyclerView = (RecyclerView)findViewById(R.id.nine_patch_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NinePatchAdapter(msgList);
        recyclerView.setAdapter(adapter);
        send_btn = (Button)findViewById(R.id.nine_patch_send);
        text_edit = (EditText)findViewById(R.id.nine_patch_text);
        send_btn.setOnClickListener(this);
    }

    private void initMsg (){

        for(int i = 0 ; i< 10 ; i++){
            NinePatchMsg msg = new NinePatchMsg(Integer.toString(i), NinePatchMsg.TYPE_RECEIVED);
            msgList.add(msg);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nine_patch_send:
                String text = text_edit.getText().toString();
                if(text.equals("")){
                    Toast.makeText(this, "发送不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    NinePatchMsg msg = new NinePatchMsg(text, NinePatchMsg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    text_edit.setText("");
                }

        }
    }
}
