package com.skola.rest.dto;

import java.util.UUID;

public class Categorydto {

    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Category: { " +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Categorydto() {
        this.id = UUID.randomUUID();

    }

    public Categorydto(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
