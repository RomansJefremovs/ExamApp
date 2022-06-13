package com.example.myapplication.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Info;
import com.example.myapplication.Repository.FirebseRepo;
import com.example.myapplication.View.Adapter.InfoAdapter;
import com.example.myapplication.databinding.FragmentNotificationsBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class NotificationsFragment extends Fragment {

    private final FirebseRepo repo = new FirebseRepo();
    private DatabaseReference reference;
    private FragmentNotificationsBinding binding;
    RecyclerView infoListRV;
    InfoAdapter infoAdapter;
    public NotificationsFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        reference = repo.getReference();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        infoListRV = binding.rv;
        infoListRV.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        infoListRV.setLayoutManager(layoutManager);
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Info> options =
                new FirebaseRecyclerOptions.Builder<Info>()
                        .setQuery(reference, Info.class)
                        .build();
        infoAdapter = new InfoAdapter(options);
        infoListRV.setAdapter(infoAdapter);
        infoAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        infoAdapter.stopListening();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}