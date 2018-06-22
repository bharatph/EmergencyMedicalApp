package com.example.laz3r.emergencymedicalapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.ResourceManager;
import com.example.laz3r.emergencymedicalapp.adapter.MultipleFragmentCardAdapter;
import com.example.laz3r.emergencymedicalapp.model.BodyWaterLevel;
import com.example.laz3r.emergencymedicalapp.model.CardModel;
import com.example.laz3r.emergencymedicalapp.model.HeartRate;
import com.example.laz3r.emergencymedicalapp.model.Info;
import com.example.laz3r.emergencymedicalapp.model.List;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DashboardFragment extends Fragment {
    ResourceManager resourceManager;


    @BindView(R.id.cardRecyclerView)
    RecyclerView cardRecyclerView;
    Unbinder unbinder;


    public DashboardFragment() {
        resourceManager = ResourceManager.getInstance();
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        unbinder = ButterKnife.bind(this, view);


        ArrayList<CardModel> cards = new ArrayList<>();

        //set up recycler view
        cardRecyclerView.setAdapter(new MultipleFragmentCardAdapter(getContext(), cards, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
        ));
        cardRecyclerView.setLayoutManager(new
                LinearLayoutManager(getContext()));
        cards.add(new List("Allergies", resourceManager.getUser().getStringAllergies()));
        cards.add(new HeartRate());
        cards.add(new Info("Dynamic Cards", "Multiple cards can be added in this view"));
        cards.add(new List("Disease", resourceManager.getUser().getStringDiseases()));
        cards.add(new BodyWaterLevel(2710, 20));
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
