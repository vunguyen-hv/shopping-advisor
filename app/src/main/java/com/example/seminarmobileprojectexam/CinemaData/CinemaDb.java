package com.example.seminarmobileprojectexam.CinemaData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CinemaObj.class}, version = 2)
public abstract class CinemaDb extends RoomDatabase {
    public abstract CinemaDao dao();

    private static final String DATABASE_NAME = "cinemadb";
    private static CinemaDb instance;

    public static CinemaDb getInstance(Context context) {
        if (instance == null) {
            synchronized (CinemaDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), CinemaDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
