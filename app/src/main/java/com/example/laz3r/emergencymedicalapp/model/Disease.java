package com.example.laz3r.emergencymedicalapp.model;

public class Disease extends Content{
    
    private String diseaseName;
    
    private Integer severity;
    
    private Integer hit;

    public Disease(Integer severity, Integer hit, String diseaseName) {
        super("disease");
        this.severity = severity;
        this.hit = hit;
        this.diseaseName = diseaseName;
    }
    
    public String getDiseaseName() {
        return this.diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
    
    public Integer getSeverity() {
        return this.severity;
    }
    
    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Integer getHit() {
        return this.hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

}
