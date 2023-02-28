package com.khanovmikhail.distancecalculator.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.khanovmikhail.distancecalculator.service.CalculationType;

import java.util.List;

public class DistanceRequest {

    @JsonProperty("calculation_type")
    private CalculationType calculationType;
    @JsonProperty("from_city_list")
    private List<String> fromCityList;
    @JsonProperty("to_city_list")
    private List<String> toCityList;

    public DistanceRequest() {
    }

    public DistanceRequest(CalculationType calculationType, List<String> fromCityList, List<String> toCityList) {
        this.calculationType = calculationType;
        this.fromCityList = fromCityList;
        this.toCityList = toCityList;
    }

    public List<String> getToCityList() {
        return toCityList;
    }

    public void setToCityList(List<String> toCityList) {
        this.toCityList = toCityList;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationType calculationType) {
        this.calculationType = calculationType;
    }

    public List<String> getFromCityList() {
        return fromCityList;
    }

    public void setFromCityList(List<String> fromCityList) {
        this.fromCityList = fromCityList;
    }

    @Override
    public String toString() {
        return "DistanceRequest{" +
                "calculationType=" + calculationType +
                ", fromCityList=" + fromCityList +
                ", toCityList=" + toCityList +
                '}';
    }
}
