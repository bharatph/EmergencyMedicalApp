package com.example.laz3r.emergencymedicalapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.adapter.MultipleCardAdapter;
import com.example.laz3r.emergencymedicalapp.model.CardModel;
import com.example.laz3r.emergencymedicalapp.model.HeartRate;
import com.example.laz3r.emergencymedicalapp.model.Info;
import com.example.laz3r.emergencymedicalapp.model.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final private Context context = this;

    ImageView headerUserImage;
    TextView headerUserName;
    TextView headerUserHealth;

    ImageButton headerHelplineButton;
    ImageButton headerHeartButton;
    ImageButton headerAlarmButton;
    ImageButton headerNewsButton;

    RecyclerView cardRecyclerView;

    void initializeLayout() {
        headerUserImage = findViewById(R.id.headerUserImage);
        headerUserName = findViewById(R.id.headerUserName);
        headerUserHealth = findViewById(R.id.headerUserHealth);

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
        cardRecyclerView.setAdapter(new MultipleCardAdapter(this, cards, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.cardHeart:
                        ActivityOptionsCompat opt1 =
                                ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                                        v.findViewById(R.id.cardHeartHRM),
                                        getString(R.string.transition_heart_hrm_name)
                                );
                        Intent int1 = new Intent(context, HeartMonitorActivity.class);
                        ActivityCompat.startActivity(context, int1, opt1.toBundle());
                        break;
                    case R.id.cardList:
                        ActivityOptionsCompat opt2 =
                                ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                                        v.findViewById(R.id.cardListHeaderText),
                                        getString(R.string.transition_list_header_name)
                                );
                        Intent int2 = new Intent(context, ListActivity.class);
                        int2.putExtra(context.getString(R.string.extra_card_list_obj), 12);
                        ActivityCompat.startActivity(context, int2, opt2.toBundle());
                        break;
                    case R.id.cardInfo:
                        ActivityOptionsCompat opt3 =
                                ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                                        v.findViewById(R.id.cardInfoHeaderText),
                                        getString(R.string.transition_info_header_name)
                                );
                        Intent int3 = new Intent(context, InfoActivity.class);
                        int3.putExtra(context.getString(R.string.extra_card_info_obj), 12);
                        ActivityCompat.startActivity(context, int3, opt3.toBundle());
                        break;
                }
            }
        }
        ));
        cardRecyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        cards.add(new HeartRate());
        cards.add(new List("Allergies", UserInstace.getUser().getStringAllergies()));
        cards.add(new Info("Dynamic Cards", "Multiple cards can be added in this view"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
