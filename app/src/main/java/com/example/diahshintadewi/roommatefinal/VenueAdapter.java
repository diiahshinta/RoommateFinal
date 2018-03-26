package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Diah Shinta Dewi on 3/26/2018.
 */

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.ViewHolder> {

    Context context;
    List<VenueData> venueDataList;

    public VenueAdapter(Context context, List<VenueData> TempList) {

        this.venueDataList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_poi, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VenueData venueData = venueDataList.get(position);

        holder.nVenue.setText(venueData.getVenueName());
        holder.aVenue.setText(venueData.getVenueAddress());
        holder.rVenue.setText(venueData.getVenueRating());

    }

    @Override
    public int getItemCount() {

        return venueDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nVenue, aVenue, rVenue;

        public ViewHolder(View itemView) {

            super(itemView);
            nVenue = (TextView) itemView.findViewById(R.id.namaVenue);
            aVenue = (TextView) itemView.findViewById(R.id.alamatVenue);
            rVenue = (TextView) itemView.findViewById(R.id.ratingVenue);
    }
}}