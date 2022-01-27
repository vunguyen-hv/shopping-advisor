package com.example.seminarmobileprojectexam.CinemaData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CinemaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CinemaObj var);

    String table = "cinema";


    @Query("select * from " + table + " where address like ('%' || :address || '%')")

    CinemaObj findByAddress(String address);

    @Query("select * from " + table + " where id = :id")
    CinemaObj findById(int id);

    @Query("select * from " + table + " order by id ASC")
    List<CinemaObj> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}
