package com.example.laz3r.emergencymedicalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.laz3r.emergencymedicalapp.adapter.AlarmListAdapter;
import com.example.laz3r.emergencymedicalapp.model.Alarm;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlarmActivity extends AppCompatActivity {

    @BindView(R.id.alarmRecyclerView)
    RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alarm_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.alarmAdd) {
            Toast.makeText(AlarmActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);

        setSupportActionBar((Toolbar) findViewById(R.id.alarmToolbar));
        //TODO save and retreive from internet
        ArrayList<Alarm> alarms = new ArrayList<>();
        alarms.add(new Alarm(true, "Home", new Date(), true));
        alarms.add(new Alarm(false, "Office", new Date(), true));
        alarms.add(new Alarm(true, "Home", new Date(), true));
        alarms.add(new Alarm(true, "Office", new Date(), true));
        alarms.add(new Alarm(true, "Home", new Date(), true));
        alarms.add(new Alarm(false, "Office", new Date(), true));
        recyclerView.setAdapter(new AlarmListAdapter(this, alarms));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
