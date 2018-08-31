package com.luisrdm.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class CheckInternet {

    public static boolean isNetworkingOnline(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeConnection = null;
        if (connectivityManager != null) {
            activeConnection = connectivityManager.getActiveNetworkInfo();
        }
        return (activeConnection != null) && activeConnection.isConnected();

    }

}
