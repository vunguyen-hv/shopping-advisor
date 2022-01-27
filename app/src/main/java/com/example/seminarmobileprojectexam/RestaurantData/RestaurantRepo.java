package com.example.seminarmobileprojectexam.RestaurantData;

import android.app.Application;

import java.util.List;

public class RestaurantRepo {
    private RestaurantDao dao;

    public RestaurantRepo(Application application) {
        RestaurantDb db = RestaurantDb.getInstance(application);
        dao = db.dao();
    }

    public List<RestaurantObj> getAlls() {
        return dao.getAlls();
    }

    public void insert(RestaurantObj var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }

    public RestaurantObj findById(int id) {
        return dao.findById(id);
    }
}
