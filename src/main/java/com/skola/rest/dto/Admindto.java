package com.skola.rest.dto;

import java.util.UUID;

public class Admindto {

    private UUID id;
    private String name;
    private String password;
    private boolean admin;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Admindto(String name, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.password = password;
        this.admin = true;


    }

}
