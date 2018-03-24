package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

import java.util.List;

/**
 * Created by JackR on 2018/3/23.
 */

public class FruitAdapter5 extends RecyclerView.Adapter<FruitAdapter5.ViewHolder> {

    private List<Fruit> fruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        View fruitView;
        ImageView image_view;
        TextView text_view;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            image_view = (ImageView)itemView.findViewById(R.id.item_image_view3);
            text_view = (TextView)itemView.findViewById(R.id.item_text3);
        }
    }

    public FruitAdapter5(List<Fruit> _fruitList) {
        fruitList = _fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item3, parent, false);
        final  ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(), "name:" + fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(), "image:" + fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
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
