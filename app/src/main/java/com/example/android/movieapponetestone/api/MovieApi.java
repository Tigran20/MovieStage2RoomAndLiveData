package com.example.android.movieapponetestone.api;

import com.example.android.movieapponetestone.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/popular")
    Call<Result> getPopularMovies(
            @Query("api_key") String key);

    @GET("movie/top_rated")
    Call<Result> getTopRatedMovies(
            @Query("api_key") String key);
}
