package com.example.shc.http.api;

import androidx.lifecycle.LiveData;

import com.example.shc.http.entities.LoginEntity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/1.1/login")
    Call<LoginEntity> login(@Body RequestBody body);
}
