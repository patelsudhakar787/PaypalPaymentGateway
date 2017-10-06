package com.example.rlard008.monitoringapp.interfaceretrofit;




import com.example.rlard008.monitoringapp.pojo.MyPojo;
import com.example.rlard008.monitoringapp.pojo.NotificationResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApIInterface {

  //thingspeakurl for injection data
  @GET("247626/feeds.json?results=20&api_key=2UZKLIXOKSZ4RE99")
  Call<MyPojo> getDataInjuction();

  //thingspeakurl for refil data
  @GET("250560/feeds.json?results=20&api_key=ZZW4TMKBAM7SBJ5X")
  Call<MyPojo> getDataRefill();

  //thingspeakurl for cycle data
  @GET("255976/feeds.json?results=1&api_key=938XR1K4RUK19OT4")
  Call<MyPojo> getCycleData();

  //thingspeakurl  for rejection data
  @GET("247623/feeds.json?results=5&api_key=DVDG77CFUS5UUCF2")
  Call<MyPojo> getRejectedData();

  //thingspeakurl for 20 cycle data
  @GET("255976/feeds.json?results=12&api_key=938XR1K4RUK19OT4")
  Call<MyPojo> getCycle12Data();

  //thingspeak data for 20 rejection data and downtime data
  @GET("247623/feeds.json?results=20&api_key=DVDG77CFUS5UUCF2")
    Call<MyPojo> get20RandDdata();

  @GET("SendGCMToUser?id=A1001&msg=ExcessCycleTime")
  Call<NotificationResponse>getNotofication();




}
