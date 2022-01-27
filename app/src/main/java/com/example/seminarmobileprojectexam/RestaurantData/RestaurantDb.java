package com.example.seminarmobileprojectexam.RestaurantData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RestaurantObj.class}, version = 3)
public abstract class RestaurantDb extends RoomDatabase {
    public abstract RestaurantDao dao();

    private static final String DATABASE_NAME = "restaurantdb";
    private static RestaurantDb instance;

    public static RestaurantDb getInstance(Context context) {
        if (instance == null) {
            synchronized (RestaurantDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), RestaurantDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
