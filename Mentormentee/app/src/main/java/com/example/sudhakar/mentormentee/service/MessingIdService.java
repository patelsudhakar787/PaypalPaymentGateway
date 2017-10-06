package com.example.sudhakar.mentormentee.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


//fcm instance id service for push notification
public class MessingIdService  extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
        String refreshToken= FirebaseInstanceId.getInstance().getToken();
   Log.e("TokenId",""+refreshToken);
      //        Toast.makeText(MessingIdService.this,"TokenId"+refreshToken,Toast.LENGTH_LONG).show();
        super.onTokenRefresh();
    }



}
