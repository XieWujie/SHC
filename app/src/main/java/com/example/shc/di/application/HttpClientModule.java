package com.example.shc.di.application;

import com.example.shc.http.HeaderInterceptor;
import com.example.shc.respository.LoginRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpClientModule {

    private static String BASE_URL = "https://UdF887jw.api.lncld.net";
    private Retrofit retrofit;;

    public HttpClientModule() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return retrofit;
    }



}
