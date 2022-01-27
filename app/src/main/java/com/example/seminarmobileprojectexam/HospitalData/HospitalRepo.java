package com.example.seminarmobileprojectexam.HospitalData;

import android.app.Application;

import java.util.List;

public class HospitalRepo {
    private HospitalDao dao;

    public HospitalRepo(Application application) {
        HospitalDb db = HospitalDb.getInstance(application);
        dao = db.dao();
    }

    public List<HospitalObj> getAlls() {
        return dao.getAlls();
    }

    public void insert(HospitalObj var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }

    public HospitalObj findById(int id) {
        return dao.findById(id);
    }
}
