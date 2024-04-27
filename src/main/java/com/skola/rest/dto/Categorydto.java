package com.skola.rest.dto;

import java.util.UUID;

public class Categorydto {

    private UUID id;
    private String name;

    public UUID getId(String name) {
        return id;
    }

    public String getName(UUID id) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categorydto() {
    }

    public Categorydto(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
