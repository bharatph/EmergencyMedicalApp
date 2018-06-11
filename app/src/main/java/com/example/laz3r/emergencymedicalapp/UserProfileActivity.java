package com.example.laz3r.emergencymedicalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setSupportActionBar((Toolbar) findViewById(R.id.userProfileToolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
