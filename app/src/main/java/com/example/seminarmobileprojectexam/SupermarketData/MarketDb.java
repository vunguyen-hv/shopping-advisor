package com.example.seminarmobileprojectexam.SupermarketData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MarketObj.class}, version = 2)
public abstract class MarketDb extends RoomDatabase {
    public abstract MarketDao dao();

    private static final String DATABASE_NAME = "marketdb";
    private static MarketDb instance;

    public static MarketDb getInstance(Context context) {
        if (instance == null) {
            synchronized (MarketDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), MarketDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
