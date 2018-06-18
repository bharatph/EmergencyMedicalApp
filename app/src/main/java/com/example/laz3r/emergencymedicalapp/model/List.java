package com.example.laz3r.emergencymedicalapp.model;


import java.util.ArrayList;

public class List extends CardModel {

    private String title;

    private ArrayList<String> list;

    public List(String title, ArrayList<String> list) {
        super("list", false);
        this.title = title;
        this.list = list;
    }

    public ArrayList<String> getList() {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        return this.list;
    }

    public String getTitle(){
        return this.title;
    }
    
    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void setTitle(String title){
        this.title = title;
    }
    
}
