package com.example.myapplication.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myapplication.Model.Measurement;
import com.example.myapplication.Model.MeasurementDAO;
import com.example.myapplication.Model.MeasurementDatabase;

import java.util.List;

public class MeasurementRepository {
    private MeasurementDAO measurementDAO;
    private LiveData<List<Measurement>> allMeasurements;

    public MeasurementRepository(Application application) {
        MeasurementDatabase database = MeasurementDatabase.getInstance(application);
        measurementDAO = database.measurementDAO();
        allMeasurements = measurementDAO.getAllMeasurements();
    }

    public void insert(Measurement measurement){
        new InsertMeasurementAsyncTask(measurementDAO).execute(measurement);
    }

    public void update(Measurement measurement){
        new UpdateMeasurementAsyncTask(measurementDAO).execute(measurement);
    }

    public void delete(Measurement measurement){
        new DeleteMeasurementAsyncTask(measurementDAO).execute(measurement);
    }

    public LiveData<List<Measurement>> getAllMeasurements(){
        return allMeasurements;
    }

    private static class InsertMeasurementAsyncTask extends AsyncTask<Measurement, Void, Void>{
        private MeasurementDAO measurementDAO;

        public InsertMeasurementAsyncTask(MeasurementDAO measurementDAO) {
            this.measurementDAO = measurementDAO;
        }

        @Override
        protected Void doInBackground(Measurement...measurements){
            measurementDAO.insert(measurements[0]);
            return null;
        }
    }
    private static class UpdateMeasurementAsyncTask extends AsyncTask<Measurement, Void, Void>{
        private MeasurementDAO measurementDAO;

        public UpdateMeasurementAsyncTask(MeasurementDAO measurementDAO) {
            this.measurementDAO = measurementDAO;
        }

        @Override
        protected Void doInBackground(Measurement...measurements){
            measurementDAO.update(measurements[0]);
            return null;
        }
    }

    private static class DeleteMeasurementAsyncTask extends AsyncTask<Measurement, Void, Void>{
        private MeasurementDAO measurementDAO;

        public DeleteMeasurementAsyncTask(MeasurementDAO measurementDAO) {
            this.measurementDAO = measurementDAO;
        }

        @Override
        protected Void doInBackground(Measurement...measurements){
            measurementDAO.delete(measurements[0]);
            return null;
        }
    }
}
