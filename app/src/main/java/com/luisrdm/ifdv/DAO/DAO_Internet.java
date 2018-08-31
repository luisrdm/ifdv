package com.luisrdm.ifdv.DAO;

import com.luisrdm.Util.ResultListener;
import com.luisrdm.ifdv.model.User;
import com.luisrdm.ifdv.model.UserContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class DAO_Internet {

    private String baseURL;
    private Retrofit retrofit;
    private ServicesRandomUser servicesRandomUser;

    public DAO_Internet() {
        baseURL = "https://randomuser.me/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();
        servicesRandomUser = retrofit.create(ServicesRandomUser.class);

    }

    public void obtainRandomUsers(final ResultListener<List<User>> resultListener) {
        servicesRandomUser.getRandomUsers(50).enqueue(new Callback<UserContainer>() {
            @Override
            public void onResponse(Call<UserContainer> call, Response<UserContainer> response) {
                UserContainer userContainer = response.body();
                List<User> result = userContainer.getResults();
                resultListener.finish(result);
            }

            @Override
            public void onFailure(Call<UserContainer> call, Throwable t) {
                t.printStackTrace();
                resultListener.finish(null);
            }
        });
    }


}
