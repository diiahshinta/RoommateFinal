package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Diah Shinta Dewi on 4/5/2018.
 */
class RoomTypeAdapter extends RecyclerView.Adapter<RoomTypeAdapter.ViewHolder>{

    private List<RoomType> data ;
    private Context context;

    RoomTypeAdapter(Context context,List<RoomType> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_roomtype,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RoomType tipeKamar = data.get(position);
        Glide.with(context).load(tipeKamar.getImageUrl()).into(holder.room);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView room;
        ViewHolder(View itemView) {
            super(itemView);
            room = (ImageView) itemView.findViewById(R.id.gambarTipe);

        }
    }
}