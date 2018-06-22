package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.alarm.Alarm;
import com.github.zagum.switchicon.SwitchIconView;
import com.rm.rmswitch.RMSwitch;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.AlarmListHolder> {
    private Context parent;
    private ArrayList<Alarm> alarms;
    public AlarmListAdapter(Context parent, ArrayList<Alarm> alarms) {
        this.parent = parent;
        this.alarms = alarms;
    }

    @NonNull
    @Override
    public AlarmListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.parent).inflate(R.layout.alarm_item, parent, false);
        return new AlarmListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmListHolder holder, int position) {
        Alarm alarm = alarms.get(position);
        holder.alarmItemName.setText(alarm.getAlarmName());
        holder.alarmItemSwitch.setChecked(alarm.getIsAlarmOn());
        holder.alarmItemRepeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SwitchIconView)v).switchState();
            }
        });
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    class AlarmListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.alarmItemName)
        TextView alarmItemName;
        @BindView(R.id.alarmItemRepeatButton)
        SwitchIconView alarmItemRepeatButton;
        @BindView(R.id.alarmItemSwitch)
        RMSwitch alarmItemSwitch;

        AlarmListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
