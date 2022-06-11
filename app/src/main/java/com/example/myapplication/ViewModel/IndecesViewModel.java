package com.example.myapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Model.Indeces;
import com.example.myapplication.Model.Measurement;
import com.example.myapplication.Repository.IndecesRepo;

import java.util.List;

public class IndecesViewModel extends AndroidViewModel {
    private IndecesRepo repo;
    private LiveData<List<Indeces>> allIndeces;
    private double weight;
    private double height;
    private double waist;
    private double hip;

    public IndecesViewModel(@NonNull Application application) {
        super(application);

        repo = new IndecesRepo(application);
        allIndeces = repo.getAllIndeces();
    }

    public void insert(Indeces indeces){repo.insert(indeces);}
    public void update(Indeces indeces){repo.update(indeces);}
    public void delete(Indeces indeces){repo.delete(indeces);}

    public LiveData<List<Indeces>> getAllIndeces() {
        return repo.getAllIndeces();
    }

    public Indeces calculateIndeces(Measurement measurement){
        weight = measurement.getWeight();
        height = measurement.getHeight();
        waist = measurement.getWaist();
        hip = measurement.getHip();
        double h2 = height*height;
        double h3 = height*height*height;
        double BMI = weight/h2;
        double pow = Math.pow(BMI,2/3);
        double hsqrt = Math.sqrt(height);
        double bsiBottom = pow*hsqrt;
        double Ponderal = weight/h3;
        double Broca = height*100-100;
        double BSI = waist/bsiBottom;
        double bmiForAMI = 1.048*BMI;
        double AMIman = bmiForAMI-16.08;
        double WHtR = waist/height;
        double WHR = waist/hip;
        double YMCAhip = 74.11*hip;
        double YMCA = YMCAhip-4464;
        double bodyFatLeft = YMCA/weight;
        double BodyFatMan = bodyFatLeft -8.2;
        return new Indeces(BMI,Ponderal,Broca,BSI,AMIman,WHtR,WHR,BodyFatMan);
    }
}
