package com.example.laz3r.emergencymedicalapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;
import com.example.laz3r.emergencymedicalapp.R;
import com.example.laz3r.emergencymedicalapp.model.alarm.Alarm;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.AlarmListHolder> {

    private Context parent;
    private ArrayList<Alarm> alarms;
    RequestOptions requestOptions = new RequestOptions();

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
        requestOptions.centerCrop();
        if (alarm.getAlarmDate().getHours() >= 12) {
            Glide.with(parent).load(R.drawable.night).apply(requestOptions).into(holder.timeIndicatorImageView);
        }
        Glide.with(parent).load(R.drawable.day).apply(requestOptions).into(holder.timeIndicatorImageView);
        holder.eventBody.addView(LayoutInflater.from(parent).inflate(R.layout.event_pill_body, holder.eventBody, false));
        holder.alarmSwitch.setChecked(alarm.getIsAlarmOn());
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    class AlarmListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.alarmItemName)
        TextView alarmItemName;
        @BindView(R.id.eventCard)
        CardView eventCard;
        @BindView(R.id.timeIndicatorImageView)
        RoundedImageView timeIndicatorImageView;
        @BindView(R.id.eventBody)
        FrameLayout eventBody;
        @BindView(R.id.alarmSwitch)
        Switch alarmSwitch;

        AlarmListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
