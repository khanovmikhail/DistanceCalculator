package com.khanovmikhail.distancecalculator.service;

import com.khanovmikhail.distancecalculator.controller.response.CityResponse;
import com.khanovmikhail.distancecalculator.dao.CityDAO;
import com.khanovmikhail.distancecalculator.entity.City;
import com.khanovmikhail.distancecalculator.exception.NoCityInDBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;

    public CityServiceImpl() {
    }

    @Override
    public List<CityResponse> getAllCitiesList() {

        List<CityResponse> cityResponseList = cityDAO.getAllCities()
                .stream()
                .map(CityResponse::new)
                .collect(Collectors.toList());

        if (cityResponseList.isEmpty()) {
            throw new NoCityInDBException("There is no cities in Database yet");
        }

        return cityResponseList;
    }
}
