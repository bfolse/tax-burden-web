package com.ttb.web.taxburden.controllers;

import java.util.List;

import com.ttb.web.taxburden.model.Coordinate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ttb.TaxBurdenServiceClient;
import com.ttb.web.taxburden.model.TaxPayerProfile;
import com.ttb.web.taxburden.model.Location;

@Controller
@SessionAttributes("taxPayerProfile")
public class GeoController {
	private static final Logger logger = LoggerFactory.getLogger(GeoController.class);

	@Autowired
	TaxBurdenServiceClient taxBurdenServiceClient;
	
    @GetMapping("/geo")
    public String geoForm(Model model) {
    	model.addAttribute("location", new Location());
        return "geo-select";
    }
    
    @PostMapping("/geo")
    public String geoSubmit(@ModelAttribute("location") Location location, Model model) {
        TaxPayerProfile taxPayerProfile = new TaxPayerProfile();
        model.addAttribute("taxPayerProfile", taxPayerProfile);
        List<String> politicalDivisionKeys = null;
        if (location.getPostalCode() != null) {
            // Location - Postal Code
            politicalDivisionKeys = taxBurdenServiceClient.politicalDivisionLookupByPostalCode(location.getPostalCode());
        } else if (location.getCoordinate() != null) {
            // Location - Coordinate
            Coordinate coordinate = location.getCoordinate();
            String latitude = Double.toString(coordinate.getLatitude());
            String longitude = Double.toString(coordinate.getLongitude());
            politicalDivisionKeys = taxBurdenServiceClient.politicalDivisionLookupByLatitudeLongitude(latitude, longitude);
        }
    	taxPayerProfile.setPoliticalDivisionKeys(politicalDivisionKeys);
    	
        return "geo-confirm";
    }
}