package com.example.myapplication.Model.RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Model.Indeces;

import java.util.List;
@Dao
public interface IndecesDAO {
    @Insert
    void insert(Indeces indeces);
    @Update
    void update(Indeces indeces);
    @Delete
    void delete(Indeces indeces);
    @Query("SELECT * FROM indeces")
    LiveData<List<Indeces>> getAllIndeces();
}
