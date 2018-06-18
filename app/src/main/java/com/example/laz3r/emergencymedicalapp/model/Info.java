package com.example.laz3r.emergencymedicalapp.model;



public class Info extends CardModel {
    
    private String title;
    
    private String message;

    public Info(String message, String title) {
        super("info", true);
        this.message = message;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
