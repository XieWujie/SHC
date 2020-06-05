package com.example.shc.http;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request
                .newBuilder()
                .addHeader("X-LC-Id", "UdF887jwDoPNofCYOs9Mavww-gzGzoHsz")
                .addHeader("X-LC-Key", "rLI4zSMp0SDWRnykVzPXaR5v")
                .build();
        return chain.proceed(newRequest);
    }
}
