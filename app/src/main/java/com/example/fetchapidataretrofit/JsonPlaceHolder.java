package com.example.fetchapidataretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolder {
    @GET("posts")
    Call<List<ModelClass>> getPost();

    @GET("comments")
    Call<List<ModelClassComments>> getComments();
}
