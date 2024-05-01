package com.skola.rest.dto;

import java.util.UUID;

public class Admindto {

    private UUID id;
    private String name;
    private String email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String toString() {
        return "Admin: { " +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Admindto(String name, String email, String password) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = true;


    }

}
