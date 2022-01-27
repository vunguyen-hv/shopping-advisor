package com.example.seminarmobileprojectexam.CinemaData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepo repository;
    private List<Movie> lists;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = new MovieRepo(application);
        lists = repository.getAlls();
    }

    public List<Movie> getAlls() {
        return lists;
    }

    public void insert(Movie var) {
        repository.insert(var);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
