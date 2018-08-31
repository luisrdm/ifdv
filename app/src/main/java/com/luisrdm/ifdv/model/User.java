package com.luisrdm.ifdv.model;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class User {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private String phone;
    private String cell;
    private Picture picture;

    //Choose not to model Login, Dob, Registered, ID


    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return name.getTitle() + " " + name.getFirst() + " " + name.getLast() + "\n";
    }
}
