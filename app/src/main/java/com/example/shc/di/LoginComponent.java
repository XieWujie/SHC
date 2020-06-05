package com.example.shc.di;

import com.example.shc.view.LoginActivity;

import dagger.Component;
import dagger.Module;

@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
