package com.example.laz3r.emergencymedicalapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.adapter.MultipleCardAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context = this;

    ImageView headerUserImage;
    TextView headerUserName;
    TextView headerUserHealth;

    ImageButton headerHelplineButton;
    ImageButton headerHeartButton;
    ImageButton headerAlarmButton;
    ImageButton headerNewsButton;

    RecyclerView cardRecyclerView;

    void initializeLayout(){
        headerUserImage = findViewById(R.id.headerUserImage);
        headerUserName = findViewById(R.id.headerUserName);
        headerUserHealth = findViewById(R.id.headerUserHealth);

        headerHelplineButton = findViewById(R.id.headerHelplineButton);
        headerHeartButton = findViewById(R.id.headerHeartButton);
        headerAlarmButton = findViewById(R.id.headerAlarmButton);
        headerNewsButton = findViewById(R.id.headerNewsButton);

        cardRecyclerView = findViewById(R.id.cardRecyclerView);
    }

    void assignListeners(){
        headerHelplineButton.setOnClickListener(this);
        headerHeartButton.setOnClickListener(this);
        headerAlarmButton.setOnClickListener(this);
        headerNewsButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //glue code to layout
        initializeLayout();
        assignListeners();

        ArrayList<ViewGroup> cards = new ArrayList<>();

        //set up recycler view
        cardRecyclerView.setAdapter(new MultipleCardAdapter(this, cards));
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        final ViewGroup heartMonitorCard = (ViewGroup)LayoutInflater.from(this).inflate(R.layout.card_heart_monitor, null);
        heartMonitorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                                heartMonitorCard.findViewById(R.id.cardHeartHRM),
                                getString(R.string.transition_heart_hrm_name)
                        );
                ActivityCompat.startActivity(context, new Intent(context, HeartMonitorActivity.class), options.toBundle());
            }
        });

        cards.add((ViewGroup) LayoutInflater.from(this).inflate(R.layout.card_check_list, null));
        cards.add(heartMonitorCard);
        cards.add((ViewGroup) LayoutInflater.from(this).inflate(R.layout.card_info, null));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.headerHelplineButton:
                startActivity(new Intent(context, HelplineActivity.class));
                break;
            case R.id.headerHeartButton:
                startActivity(new Intent(context, HeartMonitorActivity.class));
                break;
            case R.id.headerAlarmButton:
                startActivity(new Intent(context, AlarmActivity.class));
                break;
            case R.id.headerNewsButton:
                startActivity(new Intent(context, NewsActivity.class));
                break;
        }
    }
}
