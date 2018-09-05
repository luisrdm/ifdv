package com.luisrdm.ifdv.DAO;

import com.luisrdm.ifdv.model.UserContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
interface ServicesRandomUser {

    //the same "seed" generates the same set of users always
    @GET("api/?seed=ifdv")
    Call<UserContainer> getRandomUsers(@Query("results") Integer quantity);
}
