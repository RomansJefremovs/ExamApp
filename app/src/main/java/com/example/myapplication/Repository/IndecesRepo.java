package com.example.myapplication.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myapplication.Model.Indeces;
import com.example.myapplication.Model.RoomDatabase.IndecesDAO;
import com.example.myapplication.Model.RoomDatabase.MeasurementDatabase;

import java.util.List;

public class IndecesRepo {
    private IndecesDAO indecesDAO;
    private LiveData<List<Indeces>> allIndeces;

    public IndecesRepo(Application application) {
        MeasurementDatabase database = MeasurementDatabase.getInstance(application);
        indecesDAO = database.indecesDAO();
        allIndeces = indecesDAO.getAllIndeces();
    }


    public void insert(Indeces indeces){
        new IndecesRepo.InsertIndecesAsyncTask(indecesDAO).execute(indeces);
    }

    public void update(Indeces indeces){
        new IndecesRepo.UpdateIndecesAsyncTask(indecesDAO).execute(indeces);
    }

    public void delete(Indeces indeces){
        new IndecesRepo.DeleteIndecesAsyncTask(indecesDAO).execute(indeces);
    }

    public LiveData<List<Indeces>> getAllIndeces(){
        return allIndeces;
    }


    private static class InsertIndecesAsyncTask extends AsyncTask<Indeces, Void, Void> {
        private IndecesDAO indecesDAO;

        public InsertIndecesAsyncTask(IndecesDAO indecesDAO) {
            this.indecesDAO = indecesDAO;
        }

        @Override
        protected Void doInBackground(Indeces... indeces){
            indecesDAO.insert(indeces[0]);
            return null;
        }
    }
    private static class UpdateIndecesAsyncTask extends AsyncTask<Indeces, Void, Void>{
        private IndecesDAO indecesDAO;

        public UpdateIndecesAsyncTask(IndecesDAO indecesDAO) {
            this.indecesDAO = indecesDAO;
        }

        @Override
        protected Void doInBackground(Indeces...indeces){
            indecesDAO.update(indeces[0]);
            return null;
        }
    }

    private static class DeleteIndecesAsyncTask extends AsyncTask<Indeces, Void, Void>{
        private IndecesDAO indecesDAO;

        public DeleteIndecesAsyncTask(IndecesDAO indecesDAO) {
            this.indecesDAO = indecesDAO;
        }

        @Override
        protected Void doInBackground(Indeces...indeces){
            indecesDAO.delete(indeces[0]);
            return null;
        }
    }

}

