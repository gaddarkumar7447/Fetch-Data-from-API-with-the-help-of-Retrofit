package com.example.fetchapidataretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Comm extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm);
        recyclerView = findViewById(R.id.recyclerViewComments);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<ModelClassComments>> call = jsonPlaceHolder.getComments();
        call.enqueue(new Callback<List<ModelClassComments>>() {
            @Override
            public void onResponse(Call<List<ModelClassComments>> call, Response<List<ModelClassComments>> response) {
                if (response.isSuccessful()){
                    List<ModelClassComments> list1 = response.body();
                    AdapterComments adapterComments = new AdapterComments(list1,Comm.this);
                    recyclerView.setAdapter(adapterComments);
                }
            }

            @Override
            public void onFailure(Call<List<ModelClassComments>> call, Throwable t) {

            }
        });

    }
}