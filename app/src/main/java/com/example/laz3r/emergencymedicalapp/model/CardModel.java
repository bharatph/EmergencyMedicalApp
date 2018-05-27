package com.example.laz3r.emergencymedicalapp.model;


import java.io.Serializable;

public class CardModel implements Serializable {
    
    private String id;

    public CardModel(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
