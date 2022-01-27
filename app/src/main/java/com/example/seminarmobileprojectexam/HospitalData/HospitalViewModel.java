package com.example.seminarmobileprojectexam.HospitalData;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class HospitalViewModel extends AndroidViewModel {
    private HospitalRepo repository;
    private List<HospitalObj> lists;

    public HospitalViewModel(Application application) {
        super(application);
        repository = new HospitalRepo(application);
        lists = repository.getAlls();
    }

    public List<HospitalObj> getAlls() {
        return lists;
    }

    public void insert(HospitalObj var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public HospitalObj findById(int id) {
        return repository.findById(id);
    }
}
