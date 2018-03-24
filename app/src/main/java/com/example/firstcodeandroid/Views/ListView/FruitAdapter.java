package com.example.firstcodeandroid.Views.ListView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstcodeandroid.R;
import com.example.firstcodeandroid.Views.ListView.Fruit;

import java.util.List;

/**
 * Created by JackR on 2018/3/22.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//        ImageView image_view = (ImageView)view.findViewById(R.id.item_image_view);
//        TextView text_view = (TextView)view.findViewById(R.id.item_text);
//        image_view.setImageResource(fruit.getImageId());
//        text_view.setText(fruit.getFruitName());
        // 优化
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image_view = (ImageView)view.findViewById(R.id.item_image_view);
            viewHolder.text_view = (TextView)view.findViewById(R.id.item_text);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.image_view.setImageResource(fruit.getImageId());
        viewHolder.text_view.setText(fruit.getFruitName());
        return view;
    }

    class ViewHolder{
        ImageView image_view;
        TextView text_view;
    }
}
