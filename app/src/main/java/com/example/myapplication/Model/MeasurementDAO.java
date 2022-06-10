package com.example.myapplication.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MeasurementDAO {
    @Insert
    void insert(Measurement measurement);
    @Update
    void update(Measurement measurement);
    @Delete
    void delete(Measurement measurement);
    @Query("SELECT * FROM measurements")
    LiveData<List<Measurement>> getAllMeasurements();
}
