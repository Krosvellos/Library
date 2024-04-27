package com.skola.rest.dto;

import java.util.UUID;

public class Bookdto {

    private UUID id;
    private String name;
    private boolean reserved;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String toString() {
        return "Book: { " +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Bookdto() {
        this.id = UUID.randomUUID();
    }

    public Bookdto(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.reserved = false;

    }

}
