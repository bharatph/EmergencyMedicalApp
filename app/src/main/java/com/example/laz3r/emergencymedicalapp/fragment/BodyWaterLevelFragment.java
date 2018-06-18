package com.example.laz3r.emergencymedicalapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.BodyWaterLevel;
import com.google.gson.Gson;
import com.john.waveview.WaveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BodyWaterLevelFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.waterLevelView)
    WaveView waterLevelView;
    Unbinder unbinder;

    private BodyWaterLevel mParam1;

    private OnFragmentInteractionListener mListener;

    public BodyWaterLevelFragment() {
        // Required empty public constructor
    }

    public static BodyWaterLevelFragment newInstance(String param1) {
        BodyWaterLevelFragment fragment = new BodyWaterLevelFragment();
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
            mParam1 = gson.fromJson(getArguments().getString(ARG_PARAM1), BodyWaterLevel.class);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_water_level, container, false);
        unbinder = ButterKnife.bind(this, view);
        waterLevelView.setProgress((int) (mParam1.getCurrentLevel() * 100));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
