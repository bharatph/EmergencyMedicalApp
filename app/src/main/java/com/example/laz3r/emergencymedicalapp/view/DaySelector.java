package com.example.laz3r.emergencymedicalapp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.example.laz3r.emergencymedicalapp.R;

public class DaySelector extends LinearLayout {

    private String shortDays[] = {
            "M",
            "T",
            "W",
            "Th",
            "F",
            "Sa",
            "Su"
    };
    private String fullDays[] = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };

    ToggleButton dayButtons[] = new ToggleButton[7];

    void init() {
        for (int i = 0; i < 7; i++) {
            ToggleButton button = (ToggleButton) LayoutInflater.from(getContext()).inflate(R.layout.alarm_toggle_button, this, false);
            button.setText(shortDays[i]);
            button.setTextOn(shortDays[i]);
            button.setTextOff(shortDays[i]);
            button.setContentDescription(fullDays[i]);
            button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
            this.addView(button);
            dayButtons[i] = button;
        }
    }

    public DaySelector(Context context) {
        super(context);
        init();

    }

    public DaySelector(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DaySelector(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DaySelector(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


}
