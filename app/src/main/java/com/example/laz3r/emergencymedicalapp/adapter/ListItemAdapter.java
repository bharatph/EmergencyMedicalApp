package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.R;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemHolder>{
    private Context parent;
    private ArrayList<String> list;
    ListItemAdapter(Context parent, ArrayList<String> list){
        this.parent = parent;
        this.list = list;
    }
    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.parent).inflate(R.layout.list_item, parent);
        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, final int position) {
        holder.itemRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
            }
        });
        holder.itemTextView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ListItemHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        ImageButton itemRemoveButton;
        public ListItemHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemRemoveButton = itemView.findViewById(R.id.itemRemoveButton);
        }
    }
}
