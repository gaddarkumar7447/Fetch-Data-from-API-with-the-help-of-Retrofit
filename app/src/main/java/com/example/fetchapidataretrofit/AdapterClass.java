package com.example.fetchapidataretrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder>{
    List<ModelClass> arrayList;
    List<ModelClassComments> modelClassComments;
    Context context;


    public AdapterClass(List<ModelClass> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_views, null, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        /*ModelClass modelClass = arrayList.get(position);
        holder.userId.setText(modelClass.getUseId());
        holder.Id.setText(modelClass.getId());
        holder.title.setText(modelClass.getTitle());
        holder.body.setText(modelClass.getBody());*/

        holder.userId.setText("User Id: "+arrayList.get(position).getUseId());
        holder.Id.setText("Id: "+arrayList.get(position).getId());
        holder.title.setText("Title: "+arrayList.get(position).getTitle());
        holder.body.setText("body :"+arrayList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, Id, title, body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            Id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title1);
            body = itemView.findViewById(R.id.body);
        }
    }
}
