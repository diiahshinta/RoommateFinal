package com.example.diahshintadewi.roommatefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView wishlist, share, whatsapp, phone;
    ListView roomType, hostelFacility;
    RatingBar ratingBar;
    TextView hostelRating, hostelPrice, hostelName, hostelAddress, hostelWebsite, hostelPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
    }
}
