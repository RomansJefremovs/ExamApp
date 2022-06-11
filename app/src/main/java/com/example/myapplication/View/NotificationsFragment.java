package com.example.myapplication.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Info;
import com.example.myapplication.View.Adapter.InfoAdapter;
import com.example.myapplication.ViewModel.NotificationsViewModel;
import com.example.myapplication.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {
    RecyclerView infoList;
    InfoAdapter infoAdapter;

    private FragmentNotificationsBinding binding;

    public NotificationsFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        infoList = binding.rv;
        infoList.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ArrayList<Info> infoArrayList = new ArrayList<>();
        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test TestTest Test Test Test Test Test Test Test Test TestTest Test Test Test Test Test Test Test Test Test"));
        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
        infoAdapter = new InfoAdapter(infoArrayList);
        infoList.setAdapter(infoAdapter);
        infoList.setLayoutManager(layoutManager);
//        reference.se
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}