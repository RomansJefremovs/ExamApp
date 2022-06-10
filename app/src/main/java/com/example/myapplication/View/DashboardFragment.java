package com.example.myapplication.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.databinding.FragmentDashboardBinding;
import com.example.myapplication.ViewModel.MeasurementsViewModel;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeasurementsViewModel dashboardViewModel =
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
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), WHR::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}