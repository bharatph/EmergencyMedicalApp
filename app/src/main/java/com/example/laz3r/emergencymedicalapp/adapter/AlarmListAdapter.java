package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.Alarm;
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
        holder.alarmName.setText(alarm.getAlarmName());
        holder.alarmSwitch.setChecked(alarm.getIsAlarmOn());
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    class AlarmListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.alarmName)
        TextView alarmName;
        @BindView(R.id.alarmSwitch)
        RMSwitch alarmSwitch;

        AlarmListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
