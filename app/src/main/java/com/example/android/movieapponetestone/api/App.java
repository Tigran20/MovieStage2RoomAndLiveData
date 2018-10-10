package com.example.android.movieapponetestone.api;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static MovieApi api;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(MovieApi.class);
    }

    public static MovieApi getApi() { return api; }
}
