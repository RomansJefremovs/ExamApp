package com.example.myapplication.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Info;
import com.example.myapplication.R;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder>{

    private ArrayList<Info> infoArrayList;

    public InfoAdapter(ArrayList<Info> infoList){
        infoArrayList = infoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(infoArrayList.get(position).getTitle());
        holder.paragraph.setText(infoArrayList.get(position).getParagraph());
    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView paragraph;
        ViewHolder( View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recyclerItemTitle);
            paragraph =itemView.findViewById(R.id.recyclerItemParagraph);
        }
    }
}
