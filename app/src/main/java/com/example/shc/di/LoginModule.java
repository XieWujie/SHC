package com.example.shc.di;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.shc.App;
import com.example.shc.di.application.HttpClientComponent;
import com.example.shc.http.api.LoginService;
import com.example.shc.respository.LoginRepository;
import com.example.shc.respository.RLoginRepository;
import com.example.shc.respository.UserLocalRepository;
import com.example.shc.view.LoginActivity;
import com.example.shc.viewmodel.LoginViewModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class LoginModule {

    @Inject
    Retrofit retrofit;
    private LoginActivity activity;

    public LoginModule(LoginActivity activity) {
        this.activity = activity;
        App.getHttpClientComponent().inject(this);
    }


    @Provides public LoginViewModel provideViewModel(){
        UserLocalRepository iRepository = new UserLocalRepository(App.getContext().getSharedPreferences("SHC", Context.MODE_PRIVATE));
        RLoginRepository rLoginRepository = new RLoginRepository(retrofit.create(LoginService.class));
        LoginRepository repository = new LoginRepository(iRepository,rLoginRepository);
        return new ViewModelProvider(activity,new LoginViewModel.LoginViewModelFactory(repository)).get(LoginViewModel.class);
    }
}
