package com.example.laz3r.emergencymedicalapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.eftimoff.viewpagertransformers.ParallaxPageTransformer;
import com.example.laz3r.emergencymedicalapp.adapter.MainViewPagerAdapter;
import com.example.laz3r.emergencymedicalapp.fragment.BaseFragment;
import com.example.laz3r.emergencymedicalapp.fragment.BodyWaterLevelFragment;
import com.example.laz3r.emergencymedicalapp.fragment.DashboardFragment;
import com.example.laz3r.emergencymedicalapp.fragment.HeartFragment;
import com.example.laz3r.emergencymedicalapp.fragment.HelplineFragment;
import com.example.laz3r.emergencymedicalapp.fragment.InfoFragment;
import com.example.laz3r.emergencymedicalapp.model.CardModel;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, InfoFragment.OnFragmentInteractionListener, BodyWaterLevelFragment.OnFragmentInteractionListener {

    final private Context context = this;
    ResourceManager resourceManager = ResourceManager.getInstance();
    @BindView(R.id.userDetailsConstraintLayout)
    ConstraintLayout userDetailsConstraintLayout;
    @BindView(R.id.mainTabLayout)
    TabLayout mainTabLayout;
    @BindView(R.id.mainViewPager)
    ViewPager mainViewPager;

    private int[] tabIcons = {
            R.drawable.header_dashboard,
            R.drawable.header_helpline,
            R.drawable.header_heart,
            R.drawable.header_alarm,
            R.drawable.header_feed
    };

    void assignListeners() {
        userDetailsConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, UserProfileActivity.class));
            }
        });
    }

    private void setupViewPager() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DashboardFragment(), "Dashboard");
        adapter.addFrag(new HelplineFragment(), "Helpline");
        adapter.addFrag(new HeartFragment(), "Heart");
        adapter.addFrag(new AlarmFragment(), "Alarm");
        adapter.addFrag(new FeedsFragment(), "Feeds");
        mainViewPager.setAdapter(adapter);
        //mainViewPager.setPageTransformer(true, new ParallaxPageTransformer(R.id.headerUserName));
    }

    private void setupTabIcons() {
        mainTabLayout.getTabAt(0).setIcon(tabIcons[0]);
        mainTabLayout.getTabAt(1).setIcon(tabIcons[1]);
        mainTabLayout.getTabAt(2).setIcon(tabIcons[2]);
        mainTabLayout.getTabAt(3).setIcon(tabIcons[3]);
        mainTabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupTabDescriptions() {
        //TODO update tabs with descriptions
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        assignListeners();
        setupViewPager();
        mainTabLayout.setupWithViewPager(mainViewPager);
        setupTabIcons();
        setupTabDescriptions();
    }


    public void showFragment(BaseFragment fragmentClass, CardModel model) {
        //TODO open fragment in fullscreen
        Gson gson = new Gson();
        BaseFragment fragment = fragmentClass.newInstance(gson.toJson(model));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
