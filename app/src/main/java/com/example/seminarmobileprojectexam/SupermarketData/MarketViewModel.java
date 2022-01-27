package com.example.seminarmobileprojectexam.SupermarketData;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MarketViewModel extends AndroidViewModel {
    private MarketRepo repository;
    private List<MarketObj> lists;

    public MarketViewModel(Application application) {
        super(application);
        repository = new MarketRepo(application);
        lists = repository.getAlls();
    }

    public List<MarketObj> getAlls() {
        return lists;
    }

    public void insert(MarketObj var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public MarketObj findById(int id) {
        return repository.findById(id);
    }
}
