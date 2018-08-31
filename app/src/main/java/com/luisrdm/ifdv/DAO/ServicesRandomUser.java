package com.luisrdm.ifdv.DAO;

import com.luisrdm.ifdv.model.UserContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public interface ServicesRandomUser {

    @GET("api/")
    Call<UserContainer> getRandomUsers(@Query("results") Integer quantity);
}
