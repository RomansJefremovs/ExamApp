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
import com.example.myapplication.Repository.FirebseRepo;
import com.example.myapplication.View.Adapter.InfoAdapter;
import com.example.myapplication.ViewModel.NotificationsViewModel;
import com.example.myapplication.databinding.FragmentNotificationsBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class NotificationsFragment extends Fragment {
    RecyclerView infoListRV;
    InfoAdapter infoAdapter;
    private FirebseRepo repo = new FirebseRepo();
    private DatabaseReference reference;
//    private ArrayList<Info> infoArrayList;
    private FragmentNotificationsBinding binding;
//    private InfoAdapter adapter = new InfoAdapter(repo);

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
        reference = repo.getReference();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        infoListRV = binding.rv;
        infoListRV.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        ArrayList<Info> infoArrayList = new ArrayList<>();

//        repo.getReference().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    Info info = snapshot.child("BMI").getValue(Info.class);
//                    infoArrayList.add(info);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test TestTest Test Test Test Test Test Test Test Test TestTest Test Test Test Test Test Test Test Test Test"));
//        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
//        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
//        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
//        infoArrayList.add(new Info("Test","Test Test Test Test Test Test Test Test Test Test"));
//
//        infoAdapter = new InfoAdapter(infoArrayList);
//        infoListRV.setAdapter(infoAdapter);
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

//        FirebaseRecyclerAdapter<Info,InfoViewHolder> adapter = new FirebaseRecyclerAdapter<Info, InfoViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull InfoViewHolder holder, int position, @NonNull Info model) {
//                String textsRef = getRef(position).getKey();
//                reference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()){
//                            final String title = snapshot.child(textsRef).child("title").getValue().toString();
//                            final String paragraph = snapshot.child(textsRef).child("paragraph").getValue().toString();
//
//                            holder.title.setText(title);
//                            holder.paragraph.setText(paragraph);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
////                        Log.v(TAG, "Failed to read value.", error.toException());
//                    }
//                });
//            }
//
//            @NonNull
//            @Override
//            public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                LayoutInflater inflater =LayoutInflater.from(parent.getContext());
//                View view = inflater.inflate(R.layout.recycler_view_item, parent,false);
//                InfoViewHolder infoViewHolder = new InfoViewHolder(view);
//                return infoViewHolder;
//            }
//        };

        infoListRV.setAdapter(infoAdapter);
        infoAdapter.startListening();
    }

//    public static class InfoViewHolder extends RecyclerView.ViewHolder{
//        TextView title;
//        TextView paragraph;
//        public InfoViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.recyclerItemTitle);
//            paragraph =itemView.findViewById(R.id.recyclerItemParagraph);
//        }
//    }


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