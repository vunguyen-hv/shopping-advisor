package com.example.seminarmobileprojectexam.CinemaData;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class CinemaViewModel extends AndroidViewModel {
    private CinemaRepo repository;
    private List<CinemaObj> lists;

    public CinemaViewModel(Application application) {
        super(application);
        repository = new CinemaRepo(application);
        lists = repository.getAlls();
    }

    public List<CinemaObj> getAlls() {
        return lists;
    }

    public void insert(CinemaObj var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public CinemaObj findById(int id) {
        return repository.findById(id);
    }
}
