package com.example.seminarmobileprojectexam.RestaurantData;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class RestaurantViewModel extends AndroidViewModel {
    private RestaurantRepo repository;
    private List<RestaurantObj> lists;

    public RestaurantViewModel(Application application) {
        super(application);
        repository = new RestaurantRepo(application);
        lists = repository.getAlls();
    }

    public List<RestaurantObj> getAlls() {
        return lists;
    }

    public void insert(RestaurantObj var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public RestaurantObj findById(int id) {
        return repository.findById(id);
    }
}
