package com.khanovmikhail.distancecalculator.dao;

import com.khanovmikhail.distancecalculator.entity.City;
import com.khanovmikhail.distancecalculator.entity.Distance;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistanceDAO {
    List<Distance> getAllDistanceList();
    double findMatrixDistanceByCitiesNames(String cityFrom, String cityTo);
    void saveAllDistances(List<Distance> distanceList);
}
