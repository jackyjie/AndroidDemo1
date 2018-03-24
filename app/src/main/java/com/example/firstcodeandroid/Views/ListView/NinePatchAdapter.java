package com.example.firstcodeandroid.Views.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackR on 2018/3/23.
 */

public class NinePatchAdapter extends RecyclerView.Adapter<NinePatchAdapter.ViewHolder> {

    private List<NinePatchMsg> msgList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.)
    }

    public NinePatchAdapter(List<NinePatchMsg> _msgList) {
        msgList = _msgList;
    }

    @Override
    public int getItemCount() {
        return msgList.size()
    }
}
