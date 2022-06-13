package com.example.myapplication.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Info;
import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class InfoAdapter extends FirebaseRecyclerAdapter<Info, InfoAdapter.InfoViewHolder> {

    public InfoAdapter(@NonNull FirebaseRecyclerOptions<Info> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull InfoViewHolder holder, int position, @NonNull Info model) {
        holder.title.setText(model.getTitle());
        holder.paragraph.setText(model.getParagraph());
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item, parent,false);
        return new InfoViewHolder(view);
    }

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