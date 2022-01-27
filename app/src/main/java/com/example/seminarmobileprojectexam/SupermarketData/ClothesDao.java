package com.example.seminarmobileprojectexam.SupermarketData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClothesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Clothes var);

    String table = "clothes_table";
    @Query("select * from " + table + " where name like ('%' || :name || '%')")
    Clothes findByName(String name);

    @Query("select * from " + table +" where id = :id")
    Clothes findById(int id);

    @Query("select * from " + table)
    List<Clothes> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}