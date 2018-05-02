package com.example.diahshintadewi.roommatefinal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diahshintadewi.roommatefinal.listPage.AdapterList;
import com.example.diahshintadewi.roommatefinal.listPage.HostelData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    ImageView wishlist, share, whatsapp, phone;
    ListView hostelFacility, roomType;
    LinearLayout Wish, Maps, Share;
    RatingBar ratingBar;
    TextView hostelRating, hostelPrice, hostelName, hostelAddress, hostelWebsite, hostelPhone,hostelPhone2, anotherPhoto;
    FirebaseUser user;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference, dbReference;
    String namaHostel;
    private VrPanoramaView vrPanoramaView;
    List<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter, adapterRoom;
    private RecyclerView recyclerView, recycleViewType;
    private User usr;
    private Wishlist wish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        InitComponent();


        Intent i = getIntent();
        namaHostel = i.getStringExtra(AdapterList.DATA_NAME);
        InitFirebase();
        InitData();
        loadPhotoSphere();
        addListenerOnButtonClick();
    }



    private void InitFirebase(){
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }

    private void InitData(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("HostelList").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot user: dataSnapshot.getChildren()) {
                    String alamatHostel = user.child("alamatHostel").getValue() +"";
                    ArrayList<String> fasilitasHostel = (ArrayList<String>) user.child("fasilitasHostel").getValue();
                    //String gambar360 = user.child("gambar360").getValue();
                    GenericTypeIndicator<List<String>> gti = new GenericTypeIndicator<List<String>>() {};
                    String nama = user.child("tipeKamar").child("nama").getValue(String.class);
                    List<String> fasilitas = user.child("tipeKamar").child("fasilitas").getValue(gti);
                    String harga = user.child("tipeKamar").child("harga").getValue(String.class);
                    String gambar = user.child("gambar").getValue() +"";
                    String komentar = user.child("komentar").getValue() +"";
                    String nameHostel = user.child("namaHostel").getValue() +"";
                    String ratingHostel = user.child("ratingHostel").getValue() +"";
                    String telp2 = user.child("telp2").getValue() +"";
                    String telpHostel = user.child("telpHostel").getValue() +"";
//                    RoomType roomType1 = (RoomType) user.child("tipeKamar").getValue();
                    String website = user.child("website").getValue() +"";

                    HostelData data = new HostelData(alamatHostel, fasilitasHostel, gambar,
                            harga, komentar, nameHostel, ratingHostel, telp2, telpHostel, website);
                    if (namaHostel.equals(data.getNamaHostel())){
                        hostelName.setText(data.getNamaHostel());
                        hostelAddress.setText(data.getAlamatHostel());
                        recyclerView.setAdapter(new FacilityAdapter(fasilitasHostel));
                        hostelWebsite.setText(data.getWebsite());
                        hostelPhone.setText(data.getTelpHostel());
                        hostelPhone2.setText(data.getTelp2());
                        break;
                    }
                }
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void InitComponent() {


        hostelName = (TextView) findViewById(R.id.hName);
        hostelAddress = (TextView) findViewById(R.id.hAddress);
        hostelWebsite = (TextView) findViewById(R.id.hWebsite);
        hostelPhone = (TextView) findViewById(R.id.hPhone);
        hostelPhone2 = (TextView) findViewById(R.id.hPhone2);
        vrPanoramaView = (VrPanoramaView) findViewById(R.id.vrPanoramaView);
        Wish = (LinearLayout) findViewById(R.id.wish);
        Wish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String idUser = user.getUid();
                String wishId = databaseReference.push().getKey();
                String Hnama = hostelName.getText().toString();
                String Halamat = hostelAddress.getText().toString();
                String Htelpon = hostelPhone.getText().toString();
                dbReference = FirebaseDatabase.getInstance().getReference();
                dbReference.child("Wishlist").child(idUser).child(wishId).child("namaHostel").setValue(Hnama);
                dbReference.child("Wishlist").child(idUser).child(wishId).child("alamatHostel").setValue(Halamat);
                dbReference.child("Wishlist").child(idUser).child(wishId).child("telponHostel").setValue(Htelpon);
                Toast.makeText(DetailsActivity.this, "Wishlist Saved", Toast.LENGTH_SHORT).show();
            }
        });
        Share = (LinearLayout) findViewById(R.id.share);
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentu = new Intent(Intent.ACTION_SEND);
                intentu.setType("text/plain");
                String namaHostel = hostelName.getText().toString();
                String alamat = hostelAddress.getText().toString();
                String roommate = "This information from Roommate App";
                intentu.putExtra(Intent.EXTRA_SUBJECT, namaHostel);
                intentu.putExtra(Intent.EXTRA_TEXT, alamat + "\n" + roommate);
                startActivity(Intent.createChooser(intentu, "Share using"));

            }
        });
        Maps = (LinearLayout) findViewById(R.id.maps);
        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alamat = hostelName.getText().toString();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + alamat);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        phone = (ImageView) findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = hostelPhone.getText().toString();
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });
        whatsapp = (ImageView) findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smsNumber = hostelPhone2.getText().toString();
                boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
                if (isWhatsappInstalled) {
                    try {
                        Intent sendIntent = new Intent("android.intent.action.MAIN");
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.setType("text/plain");
                        sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
                        sendIntent.setPackage("com.whatsapp");
                        startActivity(sendIntent);
                    } catch(Exception e) {
                        Toast.makeText(DetailsActivity.this, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Uri uri = Uri.parse("market://details?id=com.whatsapp");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    Toast.makeText(DetailsActivity.this, "WhatsApp not Installed",
                            Toast.LENGTH_SHORT).show();
                    DetailsActivity.this.startActivity(goToMarket);
                }
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleViewType = (RecyclerView) findViewById(R.id.roomType);
        recycleViewType.setHasFixedSize(true);
        recycleViewType.setLayoutManager(new LinearLayoutManager(this));

    }


    private void addListenerOnButtonClick() {
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        final EditText comment = (EditText) findViewById(R.id.comment);
        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = auth.getCurrentUser();
                String idUser = user.getUid();
                String nama = hostelName.getText().toString();
                String idFeedback = databaseReference.push().getKey();
                String rating = String.valueOf(ratingBar.getRating());
                String komentar = comment.getText().toString().trim();
                //user.child("Feedback").child(idFeedback).child("rating").setValue(rating);
                databaseReference.child("HostelList").child(nama).child("Feedback").child(idFeedback).child("komentar").setValue(komentar);
                Toast.makeText(DetailsActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = DetailsActivity.this.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
    private void loadPhotoSphere() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;

        AssetManager assetManager = getAssets();
        try {
            inputStream = assetManager.open("pano.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            vrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        vrPanoramaView.pauseRendering();
    }

    @Override
    protected void onResume() {
        super.onResume();
        vrPanoramaView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        vrPanoramaView.shutdown();
        super.onDestroy();
    }
}
