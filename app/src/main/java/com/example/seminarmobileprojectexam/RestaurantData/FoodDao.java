package com.example.seminarmobileprojectexam.RestaurantData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Food var);

    String table = "food";

    @Query("select * from " + table + " where name like ('%' || :name || '%')")
    Food findByName(String name);

    @Query("select * from " + table + " where id = :id")
    Food findById(int id);

    @Query("select * from " + table + " order by id ASC")
    List<Food> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}