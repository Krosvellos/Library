package com.skola.rest.dto;

import java.util.UUID;

public class Userdto {


    private String name;
    private String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Userdto(String name, String password) {

        this.name = name;
        this.password = password;

    }

}