package com.example.seminarmobileprojectexam.CinemaData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface MovieDao {
    String table = "movie";

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movie var);

    @Query("select * from " + table + " where id = :id")
    Movie findById(int id);

    @Query("select * from " + table + " order by id ASC")
    List<Movie> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}
