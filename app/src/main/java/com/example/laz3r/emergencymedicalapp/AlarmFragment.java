package com.example.laz3r.emergencymedicalapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laz3r.emergencymedicalapp.adapter.AlarmListAdapter;
import com.example.laz3r.emergencymedicalapp.model.alarm.Alarm;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlarmFragment extends Fragment {

    @BindView(R.id.alarmRecyclerView)
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);
        ButterKnife.bind(this, view);
        //TODO save and retreive from internet
        ArrayList<Alarm> alarms = new ArrayList<>();
        alarms.add(new Alarm(true, "Home", new Date(), true));
        alarms.add(new Alarm(false, "Office", new Date(), true));
        alarms.add(new Alarm(true, "Home", new Date(), true));
        alarms.add(new Alarm(true, "Office", new Date(), true));
        alarms.add(new Alarm(true, "Home", new Date(), true));
        alarms.add(new Alarm(false, "Office", new Date(), true));
        recyclerView.setAdapter(new AlarmListAdapter(getContext(), alarms));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
