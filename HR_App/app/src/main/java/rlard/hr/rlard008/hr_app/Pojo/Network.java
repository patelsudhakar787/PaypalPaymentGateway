package rlard.hr.rlard008.hr_app.Pojo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by rlard008 on 08-05-2017.
 */

public class Network {

    public static boolean isNetworkConnected(Context context) {

        if (context ==null) {
            return true;
        }

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }

        return  false;


    }
}
