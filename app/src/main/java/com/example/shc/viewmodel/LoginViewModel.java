package com.example.shc.viewmodel;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.shc.http.entities.LoginEntity;
import com.example.shc.http.json.User;
import com.example.shc.respository.LoginRepository;

import org.w3c.dom.Entity;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {

    private LoginRepository repository;
    private User user;

    public LoginViewModel(LoginRepository repository) {
        this.repository = repository;
        this.user = repository.getUser();
    }

    public void login(){
        if (TextUtils.isEmpty(user.getPassword()) || TextUtils.isEmpty(user.getUsername())){
            repository.getErr().setValue(new Throwable("账号或密码不能为空"));
            return;
        }
        repository.login();
    }

   public User getUser(){
        return user;
   }

    public LiveData<Throwable> err(){
        return repository.getErr();
    }

    public LiveData<LoginEntity> success(){
        return repository.getSuccess();
    }

   public static class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory{

       private LoginRepository repository;

       public LoginViewModelFactory(LoginRepository repository) {
           this.repository = repository;
       }

       @NonNull
       @Override
       public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
           return (T) new LoginViewModel(repository);
       }
   }
}
