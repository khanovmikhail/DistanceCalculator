package com.khanovmikhail.distancecalculator.controller.response;

import com.khanovmikhail.distancecalculator.entity.City;

public class CityResponse {

    private int id;
    private String name;

    public CityResponse() {
    }

    public CityResponse(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
