package com.example.laz3r.emergencymedicalapp;

import com.example.laz3r.emergencymedicalapp.enumerator.BloodGroup;
import com.example.laz3r.emergencymedicalapp.enumerator.Gender;
import com.example.laz3r.emergencymedicalapp.model.Allergy;
import com.example.laz3r.emergencymedicalapp.model.Disease;
import com.example.laz3r.emergencymedicalapp.model.HeartState;
import com.example.laz3r.emergencymedicalapp.model.User;

import java.util.ArrayList;
import java.util.Date;

public class ResourceManager {
    private static final ResourceManager ourInstance = new ResourceManager();

    public static ResourceManager getInstance() {
        return ourInstance;
    }

    private User user;

    public User getUser() {
        if(user == null){
            ArrayList<Allergy> allergies = new ArrayList<>();
            allergies.add(new Allergy("Sunflower", 23));
            allergies.add(new Allergy("Shellfish", 45));
            allergies.add(new Allergy("Dust", 78));
            user = new User(183, "1001", Gender.MALE, new Date(), 90, "Mr. Dummy", new ArrayList<Disease>(), allergies, BloodGroup.O_POS, new HeartState(83, 45.0));
            //TODO load from firebase
        }
        return user;
    }

    private ResourceManager() {
        //TODO load data from store to code
    }
}
