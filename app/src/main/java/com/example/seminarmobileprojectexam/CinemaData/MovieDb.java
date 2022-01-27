package com.example.seminarmobileprojectexam.CinemaData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class}, version = 2)
public abstract class MovieDb extends RoomDatabase {
    public abstract MovieDao dao();

    private static final String DATABASE_NAME = "moviedb";
    private static MovieDb instance;

    public static MovieDb getInstance(Context context) {
        if (instance == null) {
            synchronized (MovieDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), MovieDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
