package com.example.laz3r.emergencymedicalapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.laz3r.emergencymedicalapp.adapter.FeedItemAdapter;
import com.example.laz3r.emergencymedicalapp.model.Feed;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedsActivity extends AppCompatActivity {

    final private Context context = this;
    final private String TAG = "Feeds";

    @BindView(R.id.feedsRecyclerView) RecyclerView recyclerView;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        ButterKnife.bind(this);

        setSupportActionBar((Toolbar) findViewById(R.id.feedsToolbar));
        getSupportActionBar().setTitle(R.string.feeds);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<Feed> feeds = new ArrayList<>();
        recyclerView.setAdapter(new FeedItemAdapter(this, feeds));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO update asynchronously from internet

        Feed feed = new Feed(getString(R.string.feed_image_sample), getString(R.string.feed_header_sample), getString(R.string.feed_content_sample));
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
        feeds.add(feed);
    }
}
