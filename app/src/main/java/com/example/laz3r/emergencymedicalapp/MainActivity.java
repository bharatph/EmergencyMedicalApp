package com.example.laz3r.emergencymedicalapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context = this;

    ImageView headerUserImage;
    TextView headerUserName;
    TextView headerUserHealth;

    Button headerHelplineButton;
    Button headerHeartButton;
    Button headerAlarmButton;
    Button headerNewsButton;

    void initializeLayout(){
        headerUserImage = findViewById(R.id.headerUserImage);
        headerUserName = findViewById(R.id.headerUserName);
        headerUserHealth = findViewById(R.id.headerUserHealth);

        headerHelplineButton = findViewById(R.id.headerHelplineButton);
        headerHeartButton = findViewById(R.id.headerHeartButton);
        headerAlarmButton = findViewById(R.id.headerAlarmButton);
        headerNewsButton = findViewById(R.id.headerNewsButton);

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
        initializeLayout();
        assignListeners();
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.headerHelplineButton:
                i = new Intent(this, HelplineActivity.class);
                break;
            case R.id.headerHeartButton:
                i = new Intent(this, HeartMonitorActivity.class);
                break;
            case R.id.headerAlarmButton:
                i = new Intent(this, AlarmActivity.class);
                break;
            case R.id.headerNewsButton:
                i = new Intent(this, NewsActivity.class);
                break;
        }
        context.startActivity(i);
    }
}
