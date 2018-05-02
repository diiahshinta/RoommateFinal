package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Diah Shinta Dewi on 4/16/2018.
 */

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    Context context;
    List<Wishlist> wishlistList;

    public WishlistAdapter(Context context, List<Wishlist> TempList) {

        this.wishlistList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_wish, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wishlist wishlist = wishlistList.get(position);

        holder.nHostel.setText(wishlist.getNamaHostel());
        holder.aHostel.setText(wishlist.getAlamatHostel());
        holder.tHostel.setText(wishlist.getTelponHostel());

    }

    @Override
    public int getItemCount() {

        return wishlistList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nHostel, aHostel, tHostel;

        public ViewHolder(View itemView) {

            super(itemView);
            nHostel = (TextView) itemView.findViewById(R.id.nHostel);
            aHostel = (TextView) itemView.findViewById(R.id.aHostel);
            tHostel = (TextView) itemView.findViewById(R.id.tHostel);
        }
    }}
