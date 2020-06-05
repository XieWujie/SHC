package com.example.shc.respository;

import androidx.lifecycle.MutableLiveData;

import com.example.shc.http.entities.LoginEntity;
import com.example.shc.http.json.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository extends BothRepository<UserLocalRepository,RLoginRepository> implements Callback<LoginEntity> {


    private User user;
    private MutableLiveData<LoginEntity> success = new MutableLiveData<>();
    private MutableLiveData<Throwable> err = new  MutableLiveData<Throwable>();

    public LoginRepository(UserLocalRepository local, RLoginRepository remote) {
        super(local, remote);
        user = new User(local.getUsername(),local.getPassword());
    }

    public void login(){
        remote.login(user,this);
    }

    public User getUser(){
        return user;
    }

    @Override
    public void onResponse(Call<LoginEntity> call, Response<LoginEntity> response) {
        LoginEntity entity = response.body();
        if (response.code() == 200) {
            local.setPassword(user.getPassword());
            local.setUsername(user.getUsername());
            local.setObjectId(entity.getObjectId());
            local.setSessionToken(entity.getSessionToken());
            success.postValue(entity);
        }else {
            try {
                err.postValue(new Throwable(response.errorBody().string()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<LoginEntity> call, Throwable t) {
        t.printStackTrace();
        err.postValue(t);
    }

    public MutableLiveData<LoginEntity> getSuccess() {
        return success;
    }

    public MutableLiveData<Throwable> getErr() {
        return err;
    }
}
