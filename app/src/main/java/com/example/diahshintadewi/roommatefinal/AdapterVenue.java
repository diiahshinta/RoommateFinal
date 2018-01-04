package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Diah Shinta Dewi on 1/4/2018.
 */

public class AdapterVenue extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    List<DataVenue> data = Collections.emptyList();
    DataVenue current;
    int currentPos = 0;

    public AdapterVenue(Context context, List<DataVenue> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_poi, parent, false);
        AdapterVenue.MyHolder holder = new AdapterVenue.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterVenue.MyHolder myHolder = (AdapterVenue.MyHolder) holder;
        DataVenue current = data.get(position);
        myHolder.venueName.setText(current.name);
        myHolder.venueRating.setText(current.rating);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder{
        TextView venueName, venueRating;
        public MyHolder(View itemView) {
            super(itemView);
            venueName = (TextView) itemView.findViewById(R.id.nameVenue);
            venueRating = (TextView) itemView.findViewById(R.id.ratingVenue);
        }
    }
}

