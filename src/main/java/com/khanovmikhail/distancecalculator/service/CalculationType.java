package com.khanovmikhail.distancecalculator.service;

public enum CalculationType {

    CROW_FLIGHT("crow_flight"),
    DISTANCE_MATRIX("distance_matrix"),
    ALL("all");

    private final String type;

    CalculationType(String type) {
        this.type = type;
    }
}
