package com.rlard.tubelighttestingrack.services;


import com.rlard.tubelighttestingrack.retrofit.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sudhakar on 5/16/17.
 */

public interface apiInterface {
    @GET("307691/feeds.json?results=1&api_key=E1ZQF2LGGRFATRVK")
    Call<MyPojo>getThingSpeakData();

    @GET("307691/feeds.json?results=24&api_key=E1ZQF2LGGRFATRVK")
    Call<MyPojo>getThingSpeak24Data();

    @GET("307691/feeds.json?results=1&api_key=E1ZQF2LGGRFATRVK")
    Call<MyPojo>getThingSpeak1Data();

}
