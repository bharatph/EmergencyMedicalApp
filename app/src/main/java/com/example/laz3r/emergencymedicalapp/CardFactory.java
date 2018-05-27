package com.example.laz3r.emergencymedicalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.laz3r.emergencymedicalapp.model.CardModel;

public class CardFactory {
    public static View getView(Context context, CardModel model) {
        LayoutInflater li = LayoutInflater.from(context);
        String id = model.getId();
        if (id.equals("heart")) {
            return li.inflate(R.layout.card_heart_monitor, null);
        } else if (id.equals("list")) {
            return li.inflate(R.layout.card_list, null);
        } else if (id.equals("info")) {
            return li.inflate(R.layout.card_info, null);
        } else {
            return li.inflate(R.layout.card_item_base, null);
        }
    }
}
