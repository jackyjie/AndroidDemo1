package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstcodeandroid.R;

import java.util.List;

/**
 * Created by JackR on 2018/3/22.
 */

public class FruitAdapter4 extends RecyclerView.Adapter<FruitAdapter4.ViewHolder> {

    private List<Fruit> fruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView text_view;

        public ViewHolder(View itemView) {
            super(itemView);
            image_view = (ImageView)itemView.findViewById(R.id.item_image_view3);
            text_view = (TextView)itemView.findViewById(R.id.item_text3);
        }
    }

    public FruitAdapter4(List<Fruit> _fruitList) {
        fruitList = _fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item3, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.image_view.setImageResource(fruit.getImageId());
        holder.text_view.setText(fruit.getFruitName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
