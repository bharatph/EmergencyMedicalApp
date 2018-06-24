package com.example.laz3r.emergencymedicalapp.adapter;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;
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
    Resources res;


    public AlarmListAdapter(Context parent, ArrayList<Alarm> alarms) {
        this.parent = parent;
        this.alarms = alarms;
        res = parent.getResources();
    }

    @NonNull
    @Override
    public AlarmListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.parent).inflate(R.layout.event_item, parent, false);
        return new AlarmListHolder(view);
    }

    private void customizeAlarm(AlarmListHolder holder, Alarm alarm, Alarm.AlarmType alarmType) {
        final int alarmHour = alarm.getAlarmDate().getHours();

        if (alarmHour >= 0 && alarmHour < 12) {
            Glide.with(parent).load(R.drawable.day).apply(requestOptions).into(holder.timeIndicatorImageView);
            holder.eventBody.setBackground(res.getDrawable(R.drawable.card_bottom_yellow));
        } else if (alarmHour >= 12 && alarmHour <= 16) {
            Glide.with(parent).load(R.drawable.midday).apply(requestOptions).into(holder.timeIndicatorImageView);
            holder.eventBody.setBackground(res.getDrawable(R.drawable.card_bottom_orange));
        } else {
            Glide.with(parent).load(R.drawable.night).apply(requestOptions).into(holder.timeIndicatorImageView);
            holder.eventBody.setBackground(res.getDrawable(R.drawable.card_bottom_blue));
        }

        if (alarmType == Alarm.AlarmType.PILL) {
            holder.eventBody.addView(LayoutInflater.from(parent).inflate(R.layout.event_pill_body, holder.eventBody, false));
        } else if (alarmType == Alarm.AlarmType.APPOINTMENT) {
            holder.eventBody.addView(LayoutInflater.from(parent).inflate(R.layout.event_appointment_body, holder.eventBody, false));
        } else {
            holder.eventBody.addView(LayoutInflater.from(parent).inflate(R.layout.event_excercise_body, holder.eventBody, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final AlarmListHolder holder, int position) {
        final Alarm alarm = alarms.get(position);
        final Alarm.AlarmType alarmType = alarm.getAlarmType();

        holder.alarmItemName.setText(alarm.getAlarmName());
        holder.alarmIndicatorTextView.setText(alarm.getAlarmDate().getHours() + ":" + alarm.getAlarmDate().getMinutes());

        holder.alarmIndicatorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(parent, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        holder.alarmIndicatorTextView.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        Date date = new Date();
                        date.setHours(hourOfDay);
                        date.setMinutes(minute);
                        alarm.setAlarmDate(date);
                    }
                }, alarm.getAlarmDate().getHours(), alarm.getAlarmDate().getMinutes(), true);
                tpd.show();
                customizeAlarm(holder, alarm, alarmType);
            }
        });
        customizeAlarm(holder, alarm, alarmType);

        requestOptions.centerCrop();
        holder.alarmSwitch.setChecked(alarm.getIsAlarmOn());
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    class AlarmListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.alarmItemName)
        TextView alarmItemName;
        @BindView(R.id.timeIndicatorImageView)
        RoundedImageView timeIndicatorImageView;
        @BindView(R.id.eventBody)
        FrameLayout eventBody;
        @BindView(R.id.alarmSwitch)
        Switch alarmSwitch;
        @BindView(R.id.alarmIndicatorTextView)
        TextView alarmIndicatorTextView;

        AlarmListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
