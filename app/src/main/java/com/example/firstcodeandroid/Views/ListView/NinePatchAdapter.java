package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackR on 2018/3/23.
 */

public class NinePatchAdapter extends RecyclerView.Adapter<NinePatchAdapter.ViewHolder> {

    private List<NinePatchMsg> msgList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout leftLayout;
        public LinearLayout rightLayout;
        public TextView left_msg;
        public TextView right_msg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (LinearLayout)itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout)itemView.findViewById(R.id.right_layout);
            left_msg = (TextView)itemView.findViewById(R.id.left_text);
            right_msg = (TextView)itemView.findViewById(R.id.right_text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nine_patch_msg_item, parent , false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NinePatchMsg msg = msgList.get(position);
        if(msg.getType() == msg.TYPE_SENT){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.right_msg.setText(msg.getContent());
        }
        else {
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.left_msg.setText(msg.getContent());
        }
    }

    public NinePatchAdapter(List<NinePatchMsg> _msgList) {
        msgList = _msgList;
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }
}
