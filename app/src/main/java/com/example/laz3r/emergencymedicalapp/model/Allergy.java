package com.example.laz3r.emergencymedicalapp.model;



public class Allergy extends Content {

    private String allergyName;
    
    private int hit;

    public Allergy(String allergyName, int hit) {
        super("allergy");
        this.allergyName = allergyName;
        this.hit = hit;
    }

    public String getAllergyName() {
        return this.allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }
    
    public int getHit() {
        return this.hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

}
