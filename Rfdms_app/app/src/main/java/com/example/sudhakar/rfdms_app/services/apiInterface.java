package com.example.sudhakar.rfdms_app.services;

import com.example.sudhakar.rfdms_app.retrofit.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sudhakar on 5/16/17.
 */

public interface apiInterface {
    @GET("298925/feeds.json?results=5&api_key=9SG2PUT1ZQUYJ6GN")
    Call<MyPojo>getThingSpeakData();

    @GET("298925/feeds.json?results=24&api_key=9SG2PUT1ZQUYJ6GN")
    Call<MyPojo>getThingSpeak24Data();

    @GET("298925/feeds.json?results=3&api_key=9SG2PUT1ZQUYJ6GN")
    Call<MyPojo>getThingSpeak1Data();

}
