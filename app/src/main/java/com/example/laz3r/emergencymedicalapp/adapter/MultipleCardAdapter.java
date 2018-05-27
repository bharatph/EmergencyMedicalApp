package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laz3r.emergencymedicalapp.CardFactory;
import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.CardModel;

import java.util.ArrayList;

public class MultipleCardAdapter extends RecyclerView.Adapter<MultipleCardAdapter.MultipleCardHolder> {

    private ArrayList<CardModel> cardViews;
    private Context parent;
    private View.OnClickListener onClickListener;

    public MultipleCardAdapter(Context parent, ArrayList<CardModel> cardViews, View.OnClickListener onClickListener) {
        this.parent = parent;
        this.cardViews = cardViews;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MultipleCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.parent).inflate(R.layout.card_item_base, parent, false);
        return new MultipleCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MultipleCardHolder holder, int position) {
        View v = CardFactory.getView(parent, cardViews.get(position));
        holder.cardItem.addView(v);
        v.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return cardViews.size();
    }

    class MultipleCardHolder extends RecyclerView.ViewHolder {
        private CardView cardItem;

        public MultipleCardHolder(View itemView) {
            super(itemView);
            cardItem = (CardView) itemView;
        }
    }
}
