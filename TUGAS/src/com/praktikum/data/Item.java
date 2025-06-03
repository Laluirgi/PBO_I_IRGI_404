package com.praktikum.data;

public class Item {
    private String name, description, location, status;

    public Item(String name, String description, String location, String status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}