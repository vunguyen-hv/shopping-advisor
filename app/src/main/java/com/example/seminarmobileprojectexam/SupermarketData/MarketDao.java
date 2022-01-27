package com.example.seminarmobileprojectexam.SupermarketData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MarketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MarketObj var);

    String table = "supermarket_table";

    @Query("select * from " + table + " where address like ('%' || :address || '%')")
    MarketObj findByAddress(String address);

    @Query("select * from " + table + " where id = :id")
    MarketObj findById(int id);

    @Query("select * from " + table + " order by id ASC")
    List<MarketObj> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}