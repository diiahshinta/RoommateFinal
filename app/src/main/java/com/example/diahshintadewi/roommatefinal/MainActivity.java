package com.example.diahshintadewi.roommatefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    GridView androidGridView;

    String[] gridViewString = {
            "Find",
            "Wishlist",
            "Account",
            "POI"};

    int[] gridViewImageId = {
            R.drawable.ic_find,
            R.drawable.ic_wishlist,
            R.drawable.ic_account,
            R.drawable.ic_poi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewString, gridViewImageId);
        androidGridView = (GridView) findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i) {
                    case 0:
                        Intent a = new Intent(view.getContext(), ListActivity.class);
                        view.getContext().startActivity(a);
                        break;
                    case 1:
                        Intent b = new Intent(view.getContext(), MainActivity.class);
                        view.getContext().startActivity(b);
                        break;
                    case 2:
                        Intent c = new Intent(view.getContext(), AccountActivity.class);
                        view.getContext().startActivity(c);
                        break;
                    case 3:
                        Intent d = new Intent(view.getContext(), MainActivity.class);
                        view.getContext().startActivity(d);
                        break;
                }

                Toast.makeText(MainActivity.this, "  " + gridViewString[+i], Toast.LENGTH_SHORT).show();

            }
        });
    }

}


