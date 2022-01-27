package com.example.seminarmobileprojectexam.RestaurantData;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {
    private FoodRepo repository;
    private List<Food> lists;

    public FoodViewModel(Application application) {
        super(application);
        repository = new FoodRepo(application);
        lists = repository.getAlls();
    }

    public List<Food> getAlls() {
        return lists;
    }

    public void insert(Food var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
