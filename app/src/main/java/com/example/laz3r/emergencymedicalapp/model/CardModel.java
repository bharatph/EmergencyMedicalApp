package com.example.laz3r.emergencymedicalapp.model;


import java.io.Serializable;

public class CardModel extends Object implements Serializable {
    
    protected String id;

    protected boolean isInteractable;

    public CardModel(String id, boolean isInteractable) {
        this.id = id;
        this.isInteractable = isInteractable;
    }
    
    public String getId() {
        return this.id;
    }

    public boolean isInteractable() {
        return isInteractable;
    }

    public void setId(String id) {
        this.id = id;
    }

}
