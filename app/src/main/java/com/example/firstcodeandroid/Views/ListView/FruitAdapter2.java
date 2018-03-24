package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstcodeandroid.R;

import java.util.List;

/**
 * Created by JackR on 2018/3/22.
 */

public class FruitAdapter2 extends RecyclerView.Adapter<FruitAdapter2.ViewHolder> {

     static class ViewHolder extends RecyclerView.ViewHolder {

         ImageView image_view;
         TextView text_view;

         public ViewHolder(View itemView) {
             super(itemView);
             image_view = (ImageView)itemView.findViewById(R.id.item_image_view);
         }
     }

    @Override
    public void onBindViewHolder(Fruit holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
