package com.example.seminarmobileprojectexam.HospitalData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {HospitalObj.class}, version = 2)
public abstract class HospitalDb extends RoomDatabase {
    public abstract HospitalDao dao();

    private static final String DATABASE_NAME = "hospitaldb";
    private static HospitalDb instance;

    public static HospitalDb getInstance(Context context) {
        if (instance == null) {
            synchronized (HospitalDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), HospitalDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
