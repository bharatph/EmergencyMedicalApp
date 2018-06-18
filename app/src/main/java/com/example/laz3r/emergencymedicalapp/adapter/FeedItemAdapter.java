package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.laz3r.emergencymedicalapp.FeedActivity;
import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.Feed;
import com.example.laz3r.emergencymedicalapp.view.MarkdownTextView;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedItemAdapter extends RecyclerView.Adapter<FeedItemAdapter.FeedItemHolder> {
    private Context parent;
    private ArrayList<Feed> feeds;
    private Gson gson;

    public FeedItemAdapter(Context parent, ArrayList<Feed> feeds){
        this.parent = parent;
        this.feeds = feeds;
        gson = new Gson();
    }
    @NonNull
    @Override
    public FeedItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.parent).inflate(R.layout.feed_item, parent, false);
        return new FeedItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedItemHolder holder, int position) {
        final int pos = position;
        Feed feed = feeds.get(pos);
        holder.headerTextView.setText(feed.getFeedHeader());
        Glide.with(parent).load(feed.getImgUrl()).into(holder.imageView);
        holder.markdownTextView.setText(feed.getFeedContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent, FeedActivity.class);
                String jdata = gson.toJson(feeds.get(pos));
                intent.putExtra(parent.getString(R.string.extra_feed), jdata);
                parent.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    class FeedItemHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.feedHeaderTextView) TextView headerTextView;
        @BindView(R.id.feedImageView) ImageView imageView;
        @BindView(R.id.feedContent) MarkdownTextView markdownTextView;

        private FeedItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
