package com.example.laz3r.emergencymedicalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.adapter.ListItemAdapter;
import com.example.laz3r.emergencymedicalapp.model.List;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    TextView title= null;
    RecyclerView recyclerView = null;

    void initialize(){
        title = findViewById(R.id.listHeaderTextView);
        recyclerView = findViewById(R.id.listRecyclerView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Gson gson = new Gson();
        String jdata = getIntent().getStringExtra(getString(R.string.extra_card_list_obj));
        List list = gson.fromJson(jdata, List.class);
        initialize();

        title.setText(list.getTitle());
        ListItemAdapter listItemAdapter = new ListItemAdapter(this, list.getList());
        recyclerView.setAdapter(listItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
