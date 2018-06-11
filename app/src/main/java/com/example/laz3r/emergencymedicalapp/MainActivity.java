package com.example.laz3r.emergencymedicalapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.adapter.MultipleFragmentCardAdapter;
import com.example.laz3r.emergencymedicalapp.fragment.HeartFragment;
import com.example.laz3r.emergencymedicalapp.fragment.InfoFragment;
import com.example.laz3r.emergencymedicalapp.fragment.ListFragment;
import com.example.laz3r.emergencymedicalapp.model.CardModel;
import com.example.laz3r.emergencymedicalapp.model.HeartRate;
import com.example.laz3r.emergencymedicalapp.model.Info;
import com.example.laz3r.emergencymedicalapp.model.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, InfoFragment.OnFragmentInteractionListener {

    final private Context context = this;

    ImageView headerUserImage;
    TextView headerUserName;
    TextView headerUserHealth;

    ConstraintLayout userDetailsConstraintLayout;

    ImageButton headerHelplineButton;
    ImageButton headerHeartButton;
    ImageButton headerAlarmButton;
    ImageButton headerNewsButton;

    RecyclerView cardRecyclerView;

    void initializeLayout() {
        headerUserImage = findViewById(R.id.headerUserImage);
        headerUserName = findViewById(R.id.headerUserName);
        headerUserHealth = findViewById(R.id.headerUserHealth);
        userDetailsConstraintLayout = findViewById(R.id.userDetailsConstraintLayout);

        headerHelplineButton = findViewById(R.id.headerHelplineButton);
        headerHeartButton = findViewById(R.id.headerHeartButton);
        headerAlarmButton = findViewById(R.id.headerAlarmButton);
        headerNewsButton = findViewById(R.id.headerNewsButton);

        cardRecyclerView = findViewById(R.id.cardRecyclerView);
    }

    void assignListeners() {
        headerHelplineButton.setOnClickListener(this);
        headerHeartButton.setOnClickListener(this);
        headerAlarmButton.setOnClickListener(this);
        headerNewsButton.setOnClickListener(this);
        userDetailsConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, UserProfileActivity.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //glue code to layout
        initializeLayout();
        assignListeners();

        ArrayList<CardModel> cards = new ArrayList<>();

        //set up recycler view
        cardRecyclerView.setAdapter(new MultipleFragmentCardAdapter(this, cards, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
        ));
        cardRecyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        cards.add(new List("Allergies", UserInstance.getUser().getStringAllergies()));
        cards.add(new HeartRate());
        cards.add(new Info("Dynamic Cards", "Multiple cards can be added in this view"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.headerHelplineButton:
                startActivity(new Intent(context, HelplineActivity.class));
                break;
            case R.id.headerHeartButton:
                //startActivity(new Intent(context, HeartMonitorActivity.class));
                break;
            case R.id.headerAlarmButton:
                startActivity(new Intent(context, AlarmActivity.class));
                break;
            case R.id.headerNewsButton:
                startActivity(new Intent(context, FeedsActivity.class));
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
