package com.example.firstcodeandroid.Permission;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackR on 2018/3/26.
 */

public class ContactUserAdapter extends ArrayAdapter<ContactUser> {

    private int resourceId;
    private List<ContactUser> list;

    public ContactUserAdapter(Context context, int resource, List<ContactUser> objects) {
        super(context, resource);
        resourceId = resource;
        list = objects;
    }

    public void refresh(List<ContactUser> _list) {
        list = _list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactUser user = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView)view.findViewById(R.id.contact_text);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.textView.setText(user.getUserName()+"\n" +user.getUserPhone());
        return view;
    }

    class ViewHolder{
        public TextView textView;
    }
}
