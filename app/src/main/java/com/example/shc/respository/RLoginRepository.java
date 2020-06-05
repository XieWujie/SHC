package com.example.shc.respository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shc.http.api.LoginService;
import com.example.shc.http.entities.LoginEntity;
import com.example.shc.http.json.User;
import com.google.gson.Gson;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RLoginRepository implements RemoteRepository {

    private LoginService service;

    public RLoginRepository(LoginService service) {
        this.service = service;
    }

    public void login(User user,Callback callback){
        Gson gson = new Gson();
        String body = gson.toJson(user, User.class);
        Call<LoginEntity> call = service
                .login(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),body));
        call.enqueue(callback);
    }


}
