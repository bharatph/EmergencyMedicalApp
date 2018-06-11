package com.example.laz3r.emergencymedicalapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.adapter.ListItemAdapter;
import com.example.laz3r.emergencymedicalapp.model.List;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private View rootView;

    @BindView(R.id.listHeaderTextView) TextView title;
    @BindView(R.id.listRecyclerView) RecyclerView recyclerView;
    private List list;

    private String mParam1;

    public ListFragment() {
    }

    public static ListFragment newInstance(String param1) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            Gson gson = new Gson();
            mParam1 = getArguments().getString(ARG_PARAM1);
            list = gson.fromJson(mParam1, List.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        title.setText(list.getTitle());
        ListItemAdapter listItemAdapter = new ListItemAdapter(getContext(), list.getList());
        recyclerView.setAdapter(listItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
