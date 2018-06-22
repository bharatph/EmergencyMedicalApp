package com.example.laz3r.emergencymedicalapp.fragment;

import android.app.Fragment;

import com.google.gson.Gson;

public abstract class BaseFragment extends Fragment {
    public BaseFragment(){

    }
    public abstract BaseFragment newInstance(String param);
}
