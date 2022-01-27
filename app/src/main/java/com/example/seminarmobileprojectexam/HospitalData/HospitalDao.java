package com.example.seminarmobileprojectexam.HospitalData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HospitalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HospitalObj var);

    String table = "hospital";

    @Query("select * from " + table + " where address like ('%' || :address || '%')")


    HospitalObj findByAddress(String address);

    @Query("select * from " + table +" where id = :id")
    HospitalObj findById(int id);

    @Query("select * from " + table  + " order by id ASC")
    List<HospitalObj> getAlls();

    @Query("delete from " + table)
    void deleteAll();
}
