package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.laz3r.emergencymedicalapp.R;

import java.util.ArrayList;

public class MultipleCardAdapter extends RecyclerView.Adapter<MultipleCardAdapter.MultipleCardHolder> {

    private ArrayList<ViewGroup> cardViews;
    private Context parent;
    public MultipleCardAdapter(Context parent, ArrayList<ViewGroup> cardViews){
        this.cardViews = cardViews;
        this.parent = parent;
    }
    @NonNull
    @Override
    public MultipleCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_base, parent, false);
        return new MultipleCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleCardHolder holder, int position) {
        holder.cardItem.addView(cardViews.get(position));
    }

    @Override
    public int getItemCount() {
        return cardViews.size();
    }

    class MultipleCardHolder extends RecyclerView.ViewHolder {
        private CardView cardItem;
        public MultipleCardHolder(View itemView) {
            super(itemView);
            cardItem = itemView.findViewById(R.id.cardItem);
        }
    }
}
