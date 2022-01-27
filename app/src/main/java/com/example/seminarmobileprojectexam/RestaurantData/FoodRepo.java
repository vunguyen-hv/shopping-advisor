package com.example.seminarmobileprojectexam.RestaurantData;

import android.app.Application;

import java.util.List;

public class FoodRepo {
    private FoodDao dao;

    public FoodRepo(Application application) {
        FoodDb db = FoodDb.getInstance(application);
        dao = db.dao();
    }

    public List<Food> getAlls() {
        return dao.getAlls();
    }

    public void insert(Food var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }
}
