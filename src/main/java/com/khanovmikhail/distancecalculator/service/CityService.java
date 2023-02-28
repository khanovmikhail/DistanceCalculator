package com.khanovmikhail.distancecalculator.service;

import com.khanovmikhail.distancecalculator.controller.response.CityResponse;
import com.khanovmikhail.distancecalculator.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<CityResponse> getAllCitiesList();
}
