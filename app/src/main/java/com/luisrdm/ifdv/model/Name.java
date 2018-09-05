package com.luisrdm.ifdv.model;

import java.io.Serializable;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class Name implements Serializable{
    private String title;
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
