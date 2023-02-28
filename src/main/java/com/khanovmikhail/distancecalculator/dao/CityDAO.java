package com.khanovmikhail.distancecalculator.dao;

import com.khanovmikhail.distancecalculator.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();
    City getCityByName(String name);
    void saveAllCities(List<City> cityList);
}
