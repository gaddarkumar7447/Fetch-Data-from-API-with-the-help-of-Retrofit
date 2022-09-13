package com.example.fetchapidataretrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterComments extends RecyclerView.Adapter<AdapterComments.viewHolder> {
    List<ModelClassComments> modelClassComments;
    Context context;

    public AdapterComments(List<ModelClassComments> modelClassComments, Context context) {
        this.modelClassComments = modelClassComments;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterComments.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_views, null, false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterComments.viewHolder holder, int position) {

        holder.userId.setText("UserId "+modelClassComments.get(position).getPostId());
        holder.Id.setText("Name: "+modelClassComments.get(position).getName());
        holder.title.setText("Email: "+modelClassComments.get(position).getEmail());
        holder.body.setText("Body: "+modelClassComments.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return modelClassComments.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView userId, Id, title, body;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            Id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title1);
            body = itemView.findViewById(R.id.body);
        }
    }
}
