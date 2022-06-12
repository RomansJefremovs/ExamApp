package com.example.myapplication.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Model.Info;
import com.example.myapplication.Repository.FirebseRepo;
import com.example.myapplication.ViewModel.HomeViewModel;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {
    FirebseRepo repo = new FirebseRepo();
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final Button btn = binding.test1;

        btn.setOnClickListener(new View.OnClickListener() {
            Info info = new Info("","");
            @Override
            public void onClick(View view) {
                info.setTitle("BMI");
                info.setParagraph("SOme");
                repo.addToDatabase("BMI", info);
            }
        });

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

        @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}