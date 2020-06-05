package com.example.shc;

import android.app.Application;
import android.content.Context;

import com.example.shc.di.application.DaggerHttpClientComponent;
import com.example.shc.di.application.HttpClientComponent;

import retrofit2.Retrofit;


public class App extends Application {

    private static HttpClientComponent httpClientComponent;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        httpClientComponent = DaggerHttpClientComponent.create();
        context = getApplicationContext();
    }

    public static HttpClientComponent getHttpClientComponent(){
        return httpClientComponent;
    }

    public static Context getContext() {
        return context;
    }
}
