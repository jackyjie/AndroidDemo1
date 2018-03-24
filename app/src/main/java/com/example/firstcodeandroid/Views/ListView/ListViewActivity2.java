package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstcodeandroid.MainActivity;
import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity2 extends AppCompatActivity {

    private List<Fruit> fruitList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity2.this,R.layout.fruit_item, fruitList);
        ListView listView = (ListView)findViewById(R.id.listView_view2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity2.this, "name:"+fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit(){
        for(int i = 0 ; i< 20; i++){
            Fruit fruit = new Fruit("fruit"+ i,R.drawable.add_32x32);
            fruitList.add(fruit);
        }
    }
}
