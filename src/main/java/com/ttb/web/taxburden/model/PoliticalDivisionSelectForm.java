package com.ttb.web.taxburden.model;

public class PoliticalDivisionSelectForm {
    String selectedCounty;
    String selectedCity;
    String selectedState;

    public PoliticalDivisionSelectForm() {
    }

    public String getSelectedCounty() {
        return selectedCounty;
    }

    public void setSelectedCounty(String selectedCounty) {
        this.selectedCounty = selectedCounty;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(String selectedState) {
        this.selectedState = selectedState;
    }

    @Override
    public String toString() {
        return "PoliticalDivisionSelectForm{" +
                "selectedCounty='" + selectedCounty + '\'' +
                ", selectedCity='" + selectedCity + '\'' +
                ", selectedState='" + selectedState + '\'' +
                '}';
    }
}
