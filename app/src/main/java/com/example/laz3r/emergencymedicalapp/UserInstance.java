package com.example.laz3r.emergencymedicalapp;

import android.provider.ContactsContract;

import com.example.laz3r.emergencymedicalapp.enumerator.BloodGroup;
import com.example.laz3r.emergencymedicalapp.enumerator.Gender;
import com.example.laz3r.emergencymedicalapp.model.Allergy;
import com.example.laz3r.emergencymedicalapp.model.Disease;
import com.example.laz3r.emergencymedicalapp.model.HeartState;
import com.example.laz3r.emergencymedicalapp.model.User;

import java.util.ArrayList;
import java.util.Date;

class UserInstace {
    private static User user;

    public static User getUser() {
        if(user == null){
            user = new User(183, "1001", Gender.MALE, new Date(), 90, "Mr. Dummy", new ArrayList<Disease>(), new ArrayList<Allergy>(), BloodGroup.O_POS, new HeartState(83, 45.0));
            //TODO load from firebase
        }
        return user;
    }
}
