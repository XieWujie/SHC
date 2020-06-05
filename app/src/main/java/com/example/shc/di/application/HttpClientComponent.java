package com.example.shc.di.application;

import android.content.Context;

import com.example.shc.di.LoginComponent;
import com.example.shc.di.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = HttpClientModule.class)
@Singleton
public interface HttpClientComponent {
    void inject(LoginModule loginModule);
}
