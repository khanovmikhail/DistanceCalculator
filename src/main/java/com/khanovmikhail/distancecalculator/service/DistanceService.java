package com.khanovmikhail.distancecalculator.service;


import com.khanovmikhail.distancecalculator.controller.request.DistanceRequest;
import com.khanovmikhail.distancecalculator.controller.response.DistanceResponse;
import com.khanovmikhail.distancecalculator.entity.Distance;

import java.util.List;

public interface DistanceService {
    List<DistanceResponse> calculateDistance(DistanceRequest distanceRequest);
}
