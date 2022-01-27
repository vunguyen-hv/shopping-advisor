package com.example.seminarmobileprojectexam.SupermarketData;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class ClothesViewModel extends AndroidViewModel {
    private ClothesRepo repository;
    private List<Clothes> lists;

    public ClothesViewModel(Application application) {
        super(application);
        repository = new ClothesRepo(application);
        lists = repository.getAlls();
    }

    public List<Clothes> getAlls() {
        return lists;
    }

    public void insert(Clothes var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
