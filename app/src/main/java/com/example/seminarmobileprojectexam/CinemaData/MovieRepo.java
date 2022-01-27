package com.example.seminarmobileprojectexam.CinemaData;

import android.app.Application;

import java.util.List;

public class MovieRepo {
    private MovieDao dao;

    public MovieRepo(Application application) {
        MovieDb db = MovieDb.getInstance(application);
        dao = db.dao();
    }
    public List<Movie> getAlls(){
        return dao.getAlls();
    }

    public void insert(Movie var) {
        dao.insert(var);
    }

    public void deleteAll() {
        dao.deleteAll();
    }
}
