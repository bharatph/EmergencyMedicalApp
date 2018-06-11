package com.example.laz3r.emergencymedicalapp.adapter;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.laz3r.emergencymedicalapp.CardFactory;
import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.CardModel;
import com.example.laz3r.emergencymedicalapp.model.HeartRate;

import java.util.ArrayList;
import java.util.Random;

public class MultipleFragmentCardAdapter extends RecyclerView.Adapter<MultipleFragmentCardAdapter.MultipleFragmentCardHolder> {

    private ArrayList<CardModel> cardViews;
    private Context parent;
    private View.OnClickListener onClickListener;

    public MultipleFragmentCardAdapter(Context parent, ArrayList<CardModel> cardViews, View.OnClickListener onClickListener) {
        this.parent = parent;
        this.cardViews = cardViews;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MultipleFragmentCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.parent).inflate(R.layout.card_item_base, parent, false);
        itemView.setId(itemView.generateViewId());
        return new MultipleFragmentCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleFragmentCardHolder holder, int position) {
        Fragment v = CardFactory.getFragment(parent, cardViews.get(position));
        FragmentManager fragmentManager = ((AppCompatActivity) parent).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(holder.cardItem.getId(), v, String.valueOf(new Random().nextInt()));
        fragmentTransaction.commit();
    }

    @Override
    public int getItemCount() {
        return cardViews.size();
    }

    class MultipleFragmentCardHolder extends RecyclerView.ViewHolder {
        private CardView cardItem;

        public MultipleFragmentCardHolder(View itemView) {
            super(itemView);
            cardItem = (CardView) itemView;
        }
    }
}
