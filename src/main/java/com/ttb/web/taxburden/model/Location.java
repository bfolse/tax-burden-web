package com.ttb.web.taxburden.model;

import java.util.Objects;

public class Location {
    private String postalCode;
    private Coordinate coordinate;

    public Location(String postalCode) {
        this.postalCode = postalCode;
    }

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Location() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.coordinate = null;
        this.postalCode = postalCode;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.postalCode = null;
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(postalCode, location.postalCode) &&
                Objects.equals(coordinate, location.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, coordinate);
    }

    @Override
    public String toString() {
        return "Location{" +
                "postalCode='" + postalCode + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
