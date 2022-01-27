package com.example.seminarmobileprojectexam.CinemaData;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "movie")
public class Movie implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "year")
    private int year;
    @ColumnInfo(name = "schedule1")
    private String schedule1;
    @ColumnInfo(name = "schedule2")
    private String schedule2;

    public Movie( @NonNull String name, String image, int year, String schedule1, String schedule2) {
        this.name = name;
        this.image = image;
        this.year = year;
        this.schedule1 = schedule1;
        this.schedule2 = schedule2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSchedule1() {
        return schedule1;
    }

    public void setSchedule1(String schedule1) {
        this.schedule1 = schedule1;
    }

    public String getSchedule2() {
        return schedule2;
    }

    public void setSchedule2(String schedule2) {
        this.schedule2 = schedule2;
    }
}
