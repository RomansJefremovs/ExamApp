package com.example.myapplication.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Measurement.class}, version = 1)
public abstract class MeasurementDatabase extends RoomDatabase {

    private static MeasurementDatabase instance;
    public abstract MeasurementDAO measurementDAO();
    public static synchronized MeasurementDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MeasurementDatabase.class, "measurements_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
