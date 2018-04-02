package com.example.diahshintadewi.roommatefinal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diah Shinta Dewi on 4/2/2018.
 */

class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder>{
    private ArrayList<String> values;
    FacilityAdapter(ArrayList<String> values){
        this.values = values;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_facility,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.fasilitasHostel);
        }
    }
}

