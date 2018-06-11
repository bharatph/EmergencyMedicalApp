package com.example.laz3r.emergencymedicalapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.HeartRate;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HeartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HeartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeartFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private View rootView;
    private TextView hrmTextView;
    private View pulseView;

    private HeartRate mParam1;

    void initialize() {
        hrmTextView = rootView.findViewById(R.id.heartHRM);
        //pulseView = rootView.findViewById(R.id.heartPulseView);
    }

    public HeartFragment() {
        // Required empty public constructor
    }

    public static HeartFragment newInstance(String param1) {
        HeartFragment fragment = new HeartFragment();
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
            mParam1 = gson.fromJson(getArguments().getString(ARG_PARAM1), HeartRate.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_heart, container, false);
        // Inflate the layout for this fragment
        initialize();
        return rootView;
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
