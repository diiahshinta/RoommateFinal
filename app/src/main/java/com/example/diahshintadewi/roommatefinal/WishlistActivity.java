package com.example.diahshintadewi.roommatefinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    List<Wishlist> list = new ArrayList<>();
    RecyclerView recyclerView;
    ImageView hapus;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        final String idUser = user.getUid();
        recyclerView = (RecyclerView) findViewById(R.id.wishlistList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(WishlistActivity.this));
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Wishlist").child(idUser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot wishSnapshot : dataSnapshot.getChildren()) {
                    Wishlist data = wishSnapshot.getValue(Wishlist.class);
                    list.add(data);
                }
                WishlistAdapter adapter = new WishlistAdapter(WishlistActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }}
