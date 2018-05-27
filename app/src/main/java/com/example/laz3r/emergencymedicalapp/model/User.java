package com.example.laz3r.emergencymedicalapp.model;

import com.example.laz3r.emergencymedicalapp.enumerator.BloodGroup;
import com.example.laz3r.emergencymedicalapp.enumerator.Gender;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String id;

    private String name;

    private Gender gender;

    private ArrayList<Disease> diseases;

    private ArrayList<Allergy> allergies;

    private Date dob;

    private BloodGroup bloodGroup;

    private HeartState heartState;

    private int weight;

    private int height;

    public User(int height, String id, Gender gender, Date dob, int weight, String name, ArrayList<Disease> diseases, ArrayList<Allergy> allergies, BloodGroup bloodGroup, HeartState heartState) {
        this.height = height;
        this.id = id;
        this.gender = gender;
        this.dob = dob;
        this.weight = weight;
        this.name = name;
        this.diseases = diseases;
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
        this.heartState = heartState;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Disease> getDiseases() {
        if (this.diseases == null) {
            this.diseases = new ArrayList<>();
        }
        return this.diseases;
    }

    public void setDiseases(ArrayList<Disease> diseases) {
        this.diseases = diseases;
    }

    public ArrayList<Allergy> getAllergies() {
        if (this.allergies == null) {
            this.allergies = new ArrayList<>();
        }
        return this.allergies;
    }

    public void setAllergies(ArrayList<Allergy> allergies) {
        this.allergies = allergies;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public BloodGroup getBloodGroup() {
        return this.bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public HeartState getHeartState() {
        return this.heartState;
    }

    public void setHeartState(HeartState heartState) {
        this.heartState = heartState;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public ArrayList<String> getStringAllergies() {
        ArrayList<String> strings = new ArrayList<>();
        for (Allergy a : getAllergies()) {
            strings.add(a.getAllergyName());
        }
        return strings;
    }

    public ArrayList<String> getStringDiseases() {
        ArrayList<String> strings = new ArrayList<>();
        for (Disease d : getDiseases()) {
            strings.add(d.getDiseaseName());
        }
        return strings;
    }

}
