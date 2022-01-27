package com.example.seminarmobileprojectexam.SupermarketData;

import android.app.Application;

import java.util.List;

public class MarketRepo {
    private MarketDao dao;

    public MarketRepo(Application application) {
        MarketDb db = MarketDb.getInstance(application);
        dao = db.dao();
    }
    public List<MarketObj> getAlls(){
        return dao.getAlls();
    }

    public void insert(MarketObj var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }

    public MarketObj findById(int id) {
        return dao.findById(id);
    }
}
