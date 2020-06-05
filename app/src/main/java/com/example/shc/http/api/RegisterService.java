package com.example.shc.http.api;

import androidx.lifecycle.LiveData;

import com.example.shc.http.entities.RegisterEntity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegisterService {

    @POST("/1.1/users")
    Call<RegisterEntity> register(@Body RequestBody body);

}
