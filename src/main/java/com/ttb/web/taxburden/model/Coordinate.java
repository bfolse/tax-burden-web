package com.ttb.web.taxburden.model;

import java.util.Objects;

public class Coordinate {
    private double latitude;
    private double longitude;

    /**
     * The minimum allowed latitude
     */
//    public static double MIN_LATITUDE = Double.valueOf("-90.0000");
    public static double MIN_LATITUDE = -90.0d;

    /**
     * The maximum allowed latitude
     */
    public static double MAX_LATITUDE = 90.0d;

    /**
     * The minimum allowed longitude
     */
    public static double MIN_LONGITUDE = -180.0d;

    /**
     * The maximum allowed longitude
     */
    public static double MAX_LONGITUDE = 180.0d;

    public Coordinate() {
    }

    public Coordinate(double latitude, double longitude) {
        if (!isValidLatitude(latitude) || !isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid latitude and/or longitude");
        } else {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (!isValidLatitude(latitude)) {
            throw new IllegalArgumentException("Invalid latitude");
        } else {
            this.latitude = latitude;
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (!isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid longitude");
        } else {
            this.longitude = longitude;
        }
    }

    public boolean isValidLatitude(double latitude) {
        if(latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidLongitude(double longitude) {
        if(longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
