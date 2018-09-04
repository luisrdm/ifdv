package com.luisrdm.ifdv.model;

import java.io.Serializable;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class Location implements Serializable{
    private String street;
    private String city;
    private String state;
    private String postcode;
    //Choose not to model Coordinates and Timezone
}
