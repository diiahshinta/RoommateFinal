package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by Diah Shinta Dewi on 4/16/2018.
 */

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    Context context;
    List<Wishlist> wishlistList;
    private DatabaseReference databaseReference;

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

        final String idWhislist = wishlist.getWishlistId();

        holder.nHostel.setText(wishlist.getNamaHostel());
        holder.aHostel.setText(wishlist.getAlamatHostel());
        holder.tHostel.setText(wishlist.getTelponHostel());

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        final String idUser = user.getUid();

        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("Wishlist").child(idUser).child(idWhislist).removeValue();
            }
        });
    }

    @Override
    public int getItemCount() {

        return wishlistList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView hapus;
        public TextView nHostel, aHostel, tHostel;

        public ViewHolder(View itemView) {

            super(itemView);
            nHostel = (TextView) itemView.findViewById(R.id.nHostel);
            aHostel = (TextView) itemView.findViewById(R.id.aHostel);
            tHostel = (TextView) itemView.findViewById(R.id.tHostel);
            hapus = (ImageView) itemView.findViewById(R.id.hapusWishlist);
        }
    }}
