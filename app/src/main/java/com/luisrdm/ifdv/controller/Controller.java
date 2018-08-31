package com.luisrdm.ifdv.controller;

import android.content.Context;

import com.luisrdm.Util.CheckInternet;
import com.luisrdm.Util.ResultListener;
import com.luisrdm.ifdv.DAO.DAO_Internet;
import com.luisrdm.ifdv.model.User;

import java.util.List;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class Controller {

    private Context context;

    public Controller(Context context) {
        this.context = context;
    }

    public void obtainRandomUsers(final ResultListener<List<User>> resultListener) {
        DAO_Internet dao = new DAO_Internet();
        if(checkInternet()) {
            dao.obtainRandomUsers(new ResultListener<List<User>>() {
                @Override
                public void finish(List<User> result) {
                    resultListener.finish(result);
                }
            });
        } else {
            resultListener.finish(null);
        }
    }

    private boolean checkInternet() {
        return CheckInternet.isNetworkingOnline(context);
    }
}
