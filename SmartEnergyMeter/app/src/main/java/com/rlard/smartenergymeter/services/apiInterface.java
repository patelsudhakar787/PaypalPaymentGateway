package com.rlard.smartenergymeter.services;


import com.rlard.smartenergymeter.retrofit.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sudhakar on 5/16/17.
 */

public interface apiInterface {
    @GET("275174/feeds.json?results=5&api_key=AKIXS529751ICFZN")
    Call<MyPojo>getThingSpeakData();

}
