package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewVerticalActivity extends AppCompatActivity {

    private List<Fruit> fruitList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_vertical);
        initFruit();
        RecyclerView view = (RecyclerView)findViewById(R.id.recyleView_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);
        FruitAdapter3 fruitAdapter3 = new FruitAdapter3(fruitList);
        view.setAdapter(fruitAdapter3);
    }


    private void initFruit(){
        for(int i = 0 ; i< 20; i++){
            Fruit fruit = new Fruit("fruit"+ i,R.drawable.add_32x32);
            fruitList.add(fruit);
        }
    }
}
