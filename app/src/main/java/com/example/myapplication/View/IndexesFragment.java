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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Model.Measurement;
import com.example.myapplication.ViewModel.MeasurementsViewModel;
import com.example.myapplication.databinding.FragmentDashboardBinding;

public class IndexesFragment extends Fragment {
//    private double BMIndex;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeasurementsViewModel viewModel =
                new ViewModelProvider(this).get(MeasurementsViewModel.class);

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

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               float weight = parseFloat(weightEdit.getText().toString());
               float height = parseFloat(heightEdit.getText().toString());
               float waist = parseFloat(waistEdit.getText().toString());
                float hip;
               if (hipEdit.getText().toString().isEmpty()){
                   hip = 0;
               } else{
                   hip = parseFloat(hipEdit.getText().toString());
               }
               double BMIndex = viewModel.getBMI(new Measurement(weight,height,waist,hip));

                Log.v(TAG,"This is the weight float" + weight);
                Log.v(TAG,"This is the height float" + height);
                Log.v(TAG,"This is the waist float" + waist);
                Log.v(TAG,"This is the hip float" + hip);
                Log.v(TAG,"This is the BMI" + BMIndex);
//                BMI.setText(String.valueOf(BMIndex));
                Toast.makeText(getActivity(), "lol", Toast.LENGTH_SHORT).show();
            }
        });

//        viewModel.getBMI().observe(getViewLifecycleOwner(), WHR::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}