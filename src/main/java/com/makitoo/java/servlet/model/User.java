package com.makitoo.java.servlet.model;

/**
 * Created by mclement on 5/17/2016.
 */
public class User {

    private String id;
    private String lastname;
    private String firstname;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
