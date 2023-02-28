package com.khanovmikhail.distancecalculator.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistanceResponse {

    @JsonProperty(value = "city_from")
    private String cityFrom;
    @JsonProperty(value = "city_to")
    private String cityTo;
    @JsonProperty(value = "distance_crow_fright")
    private Double distanceCrowFright;
    @JsonProperty(value = "distance_matrix")
    private Double distanceMatrix;

    public DistanceResponse() {
    }

    public DistanceResponse(String cityFrom, String cityTo, Double distanceCrowFright, Double distanceMatrix) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.distanceCrowFright = distanceCrowFright;
        this.distanceMatrix = distanceMatrix;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public Double getDistanceCrowFright() {
        return distanceCrowFright;
    }

    public void setDistanceCrowFright(Double distanceCrowFright) {
        this.distanceCrowFright = distanceCrowFright;
    }

    public Double getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(Double distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }
}
