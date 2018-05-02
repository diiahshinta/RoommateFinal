package com.example.diahshintadewi.roommatefinal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diah Shinta Dewi on 4/5/2018.
 */
class RoomTypeAdapter extends RecyclerView.Adapter<RoomTypeAdapter.ViewHolder>{
    private ArrayList<String> data;
    RoomTypeAdapter(ArrayList<String> data){
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_facility,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.roomType.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView roomType;
        ViewHolder(View itemView) {
            super(itemView);
            roomType = (TextView) itemView.findViewById(R.id.roomName);
        }
    }
}