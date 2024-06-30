package com.example.foodwise.Domain;

public class Location {

    private int id;

    private String location;

    @Override
    public String toString() {
        return location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Location (int id_num, String loc){
        id = id_num;
        location = loc;
    }

    public Location(){

    }


}
