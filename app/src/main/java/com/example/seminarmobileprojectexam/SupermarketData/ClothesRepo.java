package com.example.seminarmobileprojectexam.SupermarketData;

import android.app.Application;

import java.util.List;

public class ClothesRepo {
    private ClothesDao dao;

    public ClothesRepo(Application application) {
        ClothesDb db = ClothesDb.getInstance(application);
        dao = db.dao();
    }

    public List<Clothes> getAlls() {
        return dao.getAlls();
    }

    public void insert(Clothes var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }
}
