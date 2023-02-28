package com.khanovmikhail.distancecalculator.service;

import com.khanovmikhail.distancecalculator.controller.request.DistanceRequest;
import com.khanovmikhail.distancecalculator.controller.response.DistanceResponse;
import com.khanovmikhail.distancecalculator.dao.CityDAO;
import com.khanovmikhail.distancecalculator.dao.DistanceDAO;
import com.khanovmikhail.distancecalculator.entity.City;
import com.khanovmikhail.distancecalculator.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.khanovmikhail.distancecalculator.service.CalculationType.*;

@Service
public class DistanceServiceImpl implements DistanceService{

    @Autowired
    private DistanceDAO distanceDAO;

    @Autowired
    private CityDAO cityDAO;

    @Override
    public List<DistanceResponse> calculateDistance(DistanceRequest distanceRequest) {
        CalculationType calculationType = distanceRequest.getCalculationType();
        List<String> fromCities = distanceRequest.getFromCityList();
        List<String> toCities = distanceRequest.getToCityList();

        if (fromCities.isEmpty() || toCities.isEmpty()) {
            throw new BadRequestException("The cities list is empty");
        }

        if(toCities.size() != fromCities.size()){
            throw new BadRequestException("Incompatible city_from and city_to lists sizes");
        }

        List<DistanceResponse> distanceResponseList = new ArrayList<>();

        for (int i = 0; i < fromCities.size(); i++) {
            String cityFrom = fromCities.get(i);
            String cityTo = toCities.get(i);

            DistanceResponse distanceResponse = new DistanceResponse();
            distanceResponse.setCityFrom(cityFrom);
            distanceResponse.setCityTo(cityTo);
            if(calculationType == ALL || calculationType == DISTANCE_MATRIX){
                distanceResponse.setDistanceMatrix(distanceDAO.findMatrixDistanceByCitiesNames(cityFrom, cityTo));
            }
            if(calculationType == ALL || calculationType == CROW_FLIGHT){
                distanceResponse.setDistanceCrowFright(calculateCrowFlight(cityFrom, cityTo));
            }

            distanceResponseList.add(distanceResponse);
        }
        return distanceResponseList;
    }

    private double calculateCrowFlight(String fromCity, String toCity){
        City cityFrom = cityDAO.getCityByName(fromCity);
        City cityTo = cityDAO.getCityByName(toCity);

        return CrowFlight.crowFlightDistance(cityFrom.getLatitude(), cityFrom.getLongitude(),
                cityTo.getLatitude(), cityTo.getLongitude());
    }
}
