package com.example.seminarmobileprojectexam.RestaurantData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Food.class}, version=2)
public abstract class FoodDb extends RoomDatabase {
    public abstract FoodDao dao();

    private static final String DATABASE_NAME = "fooddb";
    private static FoodDb instance;

    public static FoodDb getInstance(Context context) {
        if (instance == null) {
            synchronized (FoodDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), FoodDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
