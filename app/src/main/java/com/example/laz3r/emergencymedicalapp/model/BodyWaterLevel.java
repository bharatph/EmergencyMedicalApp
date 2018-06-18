package com.example.laz3r.emergencymedicalapp.model;

import java.util.ArrayList;

public class BodyWaterLevel extends CardModel {

    private Double currentLevel;

    public BodyWaterLevel(double waterLevel, double currentLevel) {
        super("waterLevel", true);
        this.waterLevel = waterLevel;
        this.currentLevel = currentLevel;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    private Double waterLevel;

    public Double getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Double currentLevel) {
        this.currentLevel = currentLevel;
    }
}
