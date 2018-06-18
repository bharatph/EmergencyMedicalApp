package com.example.laz3r.emergencymedicalapp.model;


import java.util.Date;

public class Alarm {

    private String alarmName;

    private boolean isAlarmOn;

    private boolean shouldRepeat;

    private Date repeatRange;

    public Alarm(boolean isAlarmOn, String alarmName, Date repeatRange, boolean shouldRepeat) {
        this.isAlarmOn = isAlarmOn;
        this.alarmName = alarmName;
        this.repeatRange = repeatRange;
        this.shouldRepeat = shouldRepeat;
    }

    public String getAlarmName() {
        return this.alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public boolean getIsAlarmOn() {
        return this.isAlarmOn;
    }

    public void setIsAlarmOn(Boolean isAlarmOn) {
        this.isAlarmOn = isAlarmOn;
    }

    public boolean getShouldRepeat() {
        return this.shouldRepeat;
    }

    public void setShouldRepeat(Boolean shouldRepeat) {
        this.shouldRepeat = shouldRepeat;
    }

    public Date getRepeatRange() {
        return this.repeatRange;
    }

    public void setRepeatRange(Date repeatRange) {
        this.repeatRange = repeatRange;
    }


}
