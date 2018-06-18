package com.example.laz3r.emergencymedicalapp.model;



public class HeartRate extends CardModel {

    private HeartState heartState;
    public HeartRate() {
        super("heart", false);
    }

    public void setHeartState(HeartState heartState) {
        this.heartState = heartState;
    }

    public HeartState getHeartState() {
        return heartState;
    }
}
