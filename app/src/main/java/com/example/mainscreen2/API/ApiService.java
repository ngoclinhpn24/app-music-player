package com.example.mainscreen2.API;

import com.example.mainscreen2.Model.Banner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

//Link API: https://musicplay0123456789.000webhostapp.com/Server/banner.php
public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl(" https://musicplay0123456789.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("Server/banner.php")
    Call<List<Banner>> getDataBanner();
}
