package com.example.myapplication.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Info;
import com.example.myapplication.R;
import com.example.myapplication.Repository.FirebseRepo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class InfoAdapter extends FirebaseRecyclerAdapter<Info, InfoAdapter.InfoViewHolder> {
    private FirebseRepo repo;

    public InfoAdapter(@NonNull FirebaseRecyclerOptions<Info> options) {
        super(options);

    }

//    public FirebaseRecyclerOptions<Info> getOptions(DatabaseReference reference){
//        FirebaseRecyclerOptions<Info> options =
//                new FirebaseRecyclerOptions.Builder<Info>()
//                        .setQuery(reference, Info.class)
//                        .build();
//        return options;
//    }
//
//    public FirebaseRecyclerAdapter<Info, InfoViewHolder> getAdapter(DatabaseReference reference){
//        FirebaseRecyclerAdapter<Info, InfoViewHolder> adapter = new FirebaseRecyclerAdapter<Info, InfoViewHolder>(getOptions(reference)) {
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
//            };

//            @NonNull
//            @Override
//            public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                LayoutInflater inflater =LayoutInflater.from(parent.getContext());
//                View view = inflater.inflate(R.layout.recycler_view_item, parent,false);
//                InfoViewHolder infoViewHolder = new InfoViewHolder(view);
//                return infoViewHolder;
//            }
//        };
//        return adapter;
//    }

    @Override
    protected void onBindViewHolder(@NonNull InfoViewHolder holder, int position, @NonNull Info model) {
        String textsRef = getRef(position).getKey();
        holder.title.setText(model.getTitle());
        holder.paragraph.setText(model.getParagraph());
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    final String title = snapshot.child(textsRef).child("title").getValue().toString();
//                    final String paragraph = snapshot.child(textsRef).child("paragraph").getValue().toString();
//
//                    holder.title.setText(title);
//                    holder.paragraph.setText(paragraph);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
////                        Log.v(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item, parent,false);
        InfoViewHolder infoViewHolder = new InfoViewHolder(view);
        return infoViewHolder;
    }

    //    private ArrayList<Info> infoArrayList = new ArrayList<>();
//
//    public InfoAdapter(ArrayList<Info> infoList){
//        infoArrayList = infoList;
//    }
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.recycler_view_item, parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Info info = infoArrayList.get(position);
//        holder.title.setText(info.getTitle());
//        holder.paragraph.setText(info.getParagraph());
//    }
//
//    @Override
//    public int getItemCount() {
//        return infoArrayList.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder{
//        TextView title;
//        TextView paragraph;
//        ViewHolder( View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.recyclerItemTitle);
//            paragraph =itemView.findViewById(R.id.recyclerItemParagraph);
//        }
//    }
    public static class InfoViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView paragraph;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recyclerItemTitle);
            paragraph =itemView.findViewById(R.id.recyclerItemParagraph);
        }
    }

}