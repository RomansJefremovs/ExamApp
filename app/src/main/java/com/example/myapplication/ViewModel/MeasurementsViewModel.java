package com.example.myapplication.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Model.Measurement;
import com.example.myapplication.Repository.MeasurementRepository;

import java.util.List;

public class MeasurementsViewModel extends AndroidViewModel {
    private MeasurementRepository repository;
    private LiveData<List<Measurement>>  allMeasurements;

    public MeasurementsViewModel(Application application) {
        super(application);
        repository = new MeasurementRepository(application);
        allMeasurements = repository.getAllMeasurements();
    }

    public void insert(Measurement measurement){
        repository.insert(measurement);
    }
    public void update(Measurement measurement){
        repository.update(measurement);
    }
    public void delete(Measurement measurement){
        repository.delete(measurement);
    }

    public LiveData<List<Measurement>> allMeasurements(){
        return repository.getAllMeasurements();
    }



}