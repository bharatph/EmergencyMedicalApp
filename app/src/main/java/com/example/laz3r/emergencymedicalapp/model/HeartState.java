package com.example.laz3r.emergencymedicalapp.model;

public class HeartState {
    
    private Integer avgBPM;
    
    private Double variance;

    public HeartState(Integer avgBPM, Double variance) {
        this.avgBPM = avgBPM;
        this.variance = variance;
    }
    
    public Integer getAvgBPM() {
        return this.avgBPM;
    }

    public void setAvgBPM(Integer avgBPM) {
        this.avgBPM = avgBPM;
    }
    
    public Double getVariance() {
        return this.variance;
    }
    
    public void setVariance(Double variance) {
        this.variance = variance;
    }

}
