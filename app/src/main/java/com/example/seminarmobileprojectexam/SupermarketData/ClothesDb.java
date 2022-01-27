package com.example.seminarmobileprojectexam.SupermarketData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Clothes.class}, version = 2)
public abstract class ClothesDb extends RoomDatabase {
    public abstract ClothesDao dao();

    private static final String DATABASE_NAME = "clothesdb";
    private static ClothesDb instance;

    public static ClothesDb getInstance(Context context) {
        if (instance == null) {
            synchronized (ClothesDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), ClothesDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
