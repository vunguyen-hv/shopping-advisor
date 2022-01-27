package com.example.seminarmobileprojectexam.CinemaData;

import android.app.Application;

import java.util.List;

public class CinemaRepo {
    private CinemaDao dao;

    public CinemaRepo(Application application) {
        CinemaDb db = CinemaDb.getInstance(application);
        dao = db.dao();
    }
    public List<CinemaObj> getAlls(){
        return dao.getAlls();
    }

    public void insert(CinemaObj var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }


    public CinemaObj findById(int id) {
        return dao.findById(id);
    }
}
