package com.example.laz3r.emergencymedicalapp.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.laz3r.emergencymedicalapp.MainActivity;
import com.example.laz3r.emergencymedicalapp.fragment.BaseFragment;
import com.example.laz3r.emergencymedicalapp.model.CardModel;

public class FragmentCardView extends CardView {
    BaseFragment fragmentClass = null;
    CardModel model = null;
    MainActivity mainActivity = null;

    public boolean isInteractable() {
        return interactable;
    }

    public void setInteractable(boolean interactable) {
        this.interactable = interactable;
    }

    public void setMotion(BaseFragment fragmentClass, CardModel cardModel) {
        this.fragmentClass = fragmentClass;
        this.model = cardModel;
    }

    private boolean interactable;

    void init() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isInteractable()) {
                    mainActivity.showFragment(fragmentClass, model);
                }
            }
        });
    }

    public FragmentCardView(Context context) {
        super(context);
        init();
    }

    public FragmentCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FragmentCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
    }
}
