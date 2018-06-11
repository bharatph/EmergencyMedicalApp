package com.example.laz3r.emergencymedicalapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import com.example.laz3r.emergencymedicalapp.fragment.HeartFragment;
import com.example.laz3r.emergencymedicalapp.fragment.InfoFragment;
import com.example.laz3r.emergencymedicalapp.fragment.ListFragment;
import com.example.laz3r.emergencymedicalapp.model.CardModel;
import com.example.laz3r.emergencymedicalapp.model.HeartRate;
import com.example.laz3r.emergencymedicalapp.model.Info;
import com.example.laz3r.emergencymedicalapp.model.List;
import com.google.gson.Gson;

public class CardFactory {
    public static Fragment getFragment(Context context, @NonNull CardModel model) {
        LayoutInflater li = LayoutInflater.from(context);
        Gson gson = new Gson();
        String id = model.getId();
        if (id.equals("heart")) {
            HeartRate heartRate = (HeartRate) model;
            return HeartFragment.newInstance(gson.toJson((HeartRate)model));
        } else if (id.equals("list")) {
            return ListFragment.newInstance(gson.toJson((List)model));
        } else if (id.equals("info")) {
            return InfoFragment.newInstance(gson.toJson((Info)model));
        } else {
            return new Fragment();
        }
    }
}
