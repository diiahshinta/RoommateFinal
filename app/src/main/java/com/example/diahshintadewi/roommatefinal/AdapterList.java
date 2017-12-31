package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class AdapterList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataList> data = Collections.emptyList();
    DataList current;
    int currentPos = 0;

    public AdapterList(Context context, List<DataList> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        DataList current = data.get(position);
        myHolder.hostelName.setText(current.name);
        myHolder.hostelAddress.setText(current.address);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder{
        TextView hostelName;
        TextView hostelAddress;
        public MyHolder(View itemView) {
            super(itemView);
            hostelName = (TextView) itemView.findViewById(R.id.nameHostel);
            hostelAddress = (TextView) itemView.findViewById(R.id.addressHostel);
        }
    }
}
