package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewPoolActivity extends AppCompatActivity {

    private List<Fruit> fruitList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_pool);
        initFruit();
        RecyclerView view = (RecyclerView)findViewById(R.id.recyleView_view3);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(
                3, StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(staggeredGridLayoutManager);
        FruitAdapter4 fruitAdapter4 = new FruitAdapter4(fruitList);
        view.setAdapter(fruitAdapter4);
    }


    private void initFruit(){
        for(int i = 0 ; i< 20; i++){
//            while(i>0){
//                i=i-1;
//            }
//            String con = "888888";
//            while(i-- > 0){
//                con += con;
//            }
            Fruit fruit = new Fruit("fruit"+ i,R.drawable.add_32x32);
            fruitList.add(fruit);
        }
    }
}
