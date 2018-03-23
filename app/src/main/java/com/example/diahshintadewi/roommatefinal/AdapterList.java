package com.example.diahshintadewi.roommatefinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


public class AdapterList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataList> data = Collections.emptyList();
    DataList current;
    int currentPos = 0;
    public static String DATA_NAME = "name";

    public AdapterList(Context context, List<DataList> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyHolder myHolder = (MyHolder) holder;
        DataList current = data.get(position);
        myHolder.hostelName.setText(current.name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myHolder.hostelName.getText(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context.getApplicationContext(), DetailsActivity.class);
                i.putExtra(DATA_NAME, myHolder.hostelName.getText());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder{
        TextView hostelName;
        public MyHolder(View itemView) {
            super(itemView);
            hostelName = (TextView) itemView.findViewById(R.id.nameHostel);
        }
    }
}
