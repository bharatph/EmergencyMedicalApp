package com.example.laz3r.emergencymedicalapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.laz3r.emergencymedicalapp.model.Feed;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class FeedActivity extends AppCompatActivity {

    ImageView contentImageView;
    TextView contentTextView;

    void initialize(){
        contentImageView = findViewById(R.id.feedImageFull);
        contentTextView = findViewById(R.id.feedContentFull);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initialize();
        Toolbar toolbar = (Toolbar) findViewById(R.id.feedToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String jdata = getIntent().getStringExtra(getString(R.string.extra_feed));
        Gson gson = new Gson();
        Feed feed = gson.fromJson(jdata, Feed.class);

        Glide.with(this).load(feed.getImgUrl()).into(contentImageView);
        contentTextView.setText(feed.getFeedContent());
    }
}
