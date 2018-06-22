package com.example.laz3r.emergencymedicalapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laz3r.emergencymedicalapp.adapter.FeedItemAdapter;
import com.example.laz3r.emergencymedicalapp.model.Feed;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FeedsFragment extends Fragment {

    final private String TAG = "Feeds";

    @BindView(R.id.feedsRecyclerView)
    RecyclerView feedsRecyclerView;
    Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_feeds, container, false);
        unbinder = ButterKnife.bind(this, view);


        ArrayList<Feed> feeds = new ArrayList<>();
        feedsRecyclerView.setAdapter(new FeedItemAdapter(getContext(), feeds));
        feedsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
