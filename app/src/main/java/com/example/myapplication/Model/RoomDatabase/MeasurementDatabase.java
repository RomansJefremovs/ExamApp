package com.example.myapplication.Model.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.Model.Indeces;
import com.example.myapplication.Model.Measurement;

@Database(entities = {Measurement.class, Indeces.class}, version = 2)
public abstract class MeasurementDatabase extends RoomDatabase {

    private static MeasurementDatabase instance;
    public abstract MeasurementDAO measurementDAO();
    public abstract IndecesDAO indecesDAO();
    public static synchronized MeasurementDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MeasurementDatabase.class, "measurements_database")
                    .fallbackToDestructiveMigration().createFromAsset("database/indeces.db")
                    .build();
        }
        return instance;
    }
}
