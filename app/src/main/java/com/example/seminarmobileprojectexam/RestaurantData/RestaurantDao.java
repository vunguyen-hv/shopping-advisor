package com.example.seminarmobileprojectexam.RestaurantData;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RestaurantObj var);

    String table = "restaurant_table";

    @Query("select * from " + table + " where address like ('%' || :address || '%')")
    RestaurantObj findByAddress(String address);

    @Query("select * from " + table + " where id = :id")
    RestaurantObj findById(int id);

    @Query("select * from " + table)
    List<RestaurantObj> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}