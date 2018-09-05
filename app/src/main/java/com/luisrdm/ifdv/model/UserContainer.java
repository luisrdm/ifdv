package com.luisrdm.ifdv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class UserContainer {
    private final List<User> results;

    public UserContainer() {
        results = new ArrayList<>();
    }

    public List<User> getResults() {
        return results;
    }
}
