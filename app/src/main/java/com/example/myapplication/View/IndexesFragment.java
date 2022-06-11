package com.example.myapplication.View;

import static android.content.ContentValues.TAG;
import static java.lang.Float.parseFloat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Model.Indeces;
import com.example.myapplication.Model.Measurement;
import com.example.myapplication.ViewModel.IndecesViewModel;
import com.example.myapplication.ViewModel.MeasurementsViewModel;
import com.example.myapplication.databinding.FragmentDashboardBinding;

public class IndexesFragment extends Fragment {
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeasurementsViewModel viewModel =
                new ViewModelProvider(this).get(MeasurementsViewModel.class);

        IndecesViewModel indecesViewModel =
                new ViewModelProvider(this).get(IndecesViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        final TextView BMI = binding.BMI;
        final TextView BrocaIndex = binding.BrocaIndex;
        final TextView PonderalIndex = binding.PonderalIndex;
        final TextView BSI = binding.BSI;
        final TextView AMI = binding.AMI;
        final TextView WHTR = binding.WHTR;
        final TextView WHR = binding.WHR;
        final TextView bodyFat = binding.BodyFat;
        final EditText weightEdit = binding.weight;
        final EditText heightEdit = binding.height;
        final EditText waistEdit = binding.waist;
        final EditText hipEdit = binding.hip;
        final Button calculate = binding.button;

        displayDefault(BMI,PonderalIndex,BrocaIndex,BSI,AMI,WHTR,WHR,bodyFat);

        calculate.setOnClickListener(view -> {
            Measurement savedData = saveData(heightEdit,weightEdit,waistEdit,hipEdit,viewModel);
            Indeces calculatedIndeces = calculateIndeces(indecesViewModel,savedData);
            Log.v(TAG,"This is the the last values" + calculatedIndeces.getBMI());
            displayIndeces(BMI,PonderalIndex,BrocaIndex,BSI,AMI,WHTR,WHR,bodyFat,calculatedIndeces);
        });

        return root;
    }

    public Measurement saveData(EditText heightEdit,EditText weightEdit,EditText waistEdit,EditText hipEdit,MeasurementsViewModel viewModel){
        float weight;
        float height;
        float waist;
        float hip;

        if (hipEdit.getText().toString().isEmpty()){
            hip = 0;
        } else{
            hip = parseFloat(hipEdit.getText().toString());
        }
        if (weightEdit.getText().toString().isEmpty()){
            weight = 0;
        } else{
            weight = parseFloat(weightEdit.getText().toString());
        }
        if (heightEdit.getText().toString().isEmpty()){
            height = 0;
        } else{
            height = parseFloat(heightEdit.getText().toString());
        }
        if (waistEdit.getText().toString().isEmpty()){
            waist = 0;
        } else{
            waist = parseFloat(waistEdit.getText().toString());
        }
        Measurement measurement = new Measurement(weight,height,waist,hip);
        viewModel.insert(measurement);
        return measurement;
    }

    public Indeces calculateIndeces(IndecesViewModel indecesViewModel, Measurement measurement){
        return indecesViewModel.calculateIndeces(measurement);
    }

    public void displayIndeces(TextView BMI,
                               TextView Ponderal,
                               TextView Broca,
                               TextView BSI,
                               TextView AMI,
                               TextView WHTR,
                               TextView WHR,
                               TextView BodyFat,
                               Indeces indeces){
        BMI.setText(String.format("%.2f",indeces.getBMI()));
        Ponderal.setText(String.format("%.2f",indeces.getPonderal()));
        Broca.setText(String.format("%.2f",indeces.getBroca()));
        BSI.setText(String.format("%.2f",indeces.getBSI()));
        AMI.setText(String.format("%.2f",indeces.getAMI()));
        WHTR.setText(String.format("%.2f",indeces.getWHTR()));
        WHR.setText(String.format("%.2f",indeces.getWHR()));
        BodyFat.setText(String.format("%.2f",indeces.getBodyFat()));
    }

    public void displayDefault(TextView BMI,
                               TextView Ponderal,
                               TextView Broca,
                               TextView BSI,
                               TextView AMI,
                               TextView WHTR,
                               TextView WHR,
                               TextView BodyFat
                               ){
        BMI.setText("0");
        Ponderal.setText("0");
        Broca.setText("0");
        BSI.setText("0");
        AMI.setText("0");
        WHR.setText("0");
        WHTR.setText("0");
        BodyFat.setText("0");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}