package com.khanovmikhail.distancecalculator.service;

public class CrowFlight {
    public final static double EARTH_RADIUS = 6_371D;

    public static double crowFlightDistance(double latitudeFrom, double longitudeFrom,
                                            double latitudeTo, double longitudeTo) {

        // convert from degrees to radians
        latitudeFrom = Math.toRadians(latitudeFrom);
        longitudeFrom = Math.toRadians(longitudeFrom);
        latitudeTo = Math.toRadians(latitudeTo);
        longitudeTo = Math.toRadians(longitudeTo);

        // implement Haversine formula
        double longitudeDiff = longitudeFrom - longitudeTo;
        double latitudeDiff = latitudeFrom - latitudeTo;
        double a = Math.pow(Math.sin(latitudeDiff / 2), 2)
                + Math.cos(latitudeFrom) * Math.cos(latitudeTo)
                * Math.pow(Math.sin(longitudeDiff / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // multiply on earth radius
        return c * EARTH_RADIUS;
    }
}
