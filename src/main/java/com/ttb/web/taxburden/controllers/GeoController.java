package com.ttb.web.taxburden.controllers;

import java.util.*;

import com.ttb.web.taxburden.model.*;
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

@Controller
@SessionAttributes("taxPayerProfile")
public class GeoController {
	private static final Logger logger = LoggerFactory.getLogger(GeoController.class);
    private static String COUNTY_TYPE = "COUNTY";
    private static String CITY_TYPE = "CITY";
    private static String STATE_TYPE = "STATE";

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
        List<com.ttb.service.taxburden.domain.PoliticalDivision> servicePoliticalDivisions = null;
        if (location.getPostalCode() != null) {
            // Location - Postal Code
            servicePoliticalDivisions = taxBurdenServiceClient.politicalDivisionLookupByPostalCode(location.getPostalCode());
        } else if (location.getCoordinate() != null) {
            // Location - Coordinate
            Coordinate coordinate = location.getCoordinate();
            String latitude = Double.toString(coordinate.getLatitude());
            String longitude = Double.toString(coordinate.getLongitude());
            servicePoliticalDivisions = taxBurdenServiceClient.politicalDivisionLookupByLatitudeLongitude(latitude, longitude);
        }
        List<PoliticalDivision> webPoliticalDivisions = TaxPayerProfile.toWebPoliticalDivisions(servicePoliticalDivisions);
        taxPayerProfile.setPoliticalDivisions(webPoliticalDivisions);

        // Multiples per type?
        Map<String, List<PoliticalDivision>> typeMap = toTypeMultiplesMap(webPoliticalDivisions);
        if (typeMap != null) {
            // Add list for each type to model
            for (String politicalDivisionType : typeMap.keySet()) {
                model.addAttribute(politicalDivisionType, typeMap.get(politicalDivisionType));
            }
            model.addAttribute("politicalDivisionSelectForm", new PoliticalDivisionSelectForm());
            return "geo-multiple";
        } else {
            return "geo-confirm";
        }
    }

    @PostMapping("/geomultiple")
    public String geoMultiple(@ModelAttribute("politicalDivisionSelectForm") PoliticalDivisionSelectForm politicalDivisionSelectForm,
                              @ModelAttribute("taxPayerProfile") TaxPayerProfile taxPayerProfile, Model model) {
        logger.debug("politicalDivisionSelectForm: " + politicalDivisionSelectForm);
        logger.debug("taxPayerProfile: " + taxPayerProfile);
        // Update taxPayerProfile with selected politicalDivisions
        if (politicalDivisionSelectForm.getSelectedCounty() != null) {
            taxPayerProfile.getPoliticalDivisions().removeIf(pd -> pd.getType().equals(COUNTY_TYPE) && !pd.getFips().equals(politicalDivisionSelectForm.getSelectedCounty()));
        }
        if (politicalDivisionSelectForm.getSelectedCity() != null) {
            taxPayerProfile.getPoliticalDivisions().removeIf(pd -> pd.getType().equals(CITY_TYPE) && !pd.getFips().equals(politicalDivisionSelectForm.getSelectedCity()));
        }
        if (politicalDivisionSelectForm.getSelectedState() != null) {
            taxPayerProfile.getPoliticalDivisions().removeIf(pd -> pd.getType().equals(STATE_TYPE) && !pd.getFips().equals(politicalDivisionSelectForm.getSelectedState()));
        }
        return "geo-confirm";
    }

    /*
        Create a map of PoliticalDivision Lists by type for types with more than one PoliticalDivision
        @param List<PoliticalDivision> politicalDivisions
        @return Map or null if no multiples
     */
    private Map<String, List<PoliticalDivision>> toTypeMultiplesMap(List<PoliticalDivision> politicalDivisions) {
        Map<String, List<PoliticalDivision>> typeMap = new HashMap<String, List<PoliticalDivision>>();
        boolean multiples = false;
        for (PoliticalDivision politicalDivision : politicalDivisions) {
            if (!typeMap.containsKey(politicalDivision.getType())) {
                List<PoliticalDivision> pdList = new ArrayList<PoliticalDivision>();
                pdList.add(politicalDivision);
                typeMap.put(politicalDivision.getType(), pdList);
            } else {
                typeMap.get(politicalDivision.getType()).add(politicalDivision);
                multiples = true;
            }
        }
        if (!multiples) {
            typeMap = null;
        } else {
            // remove non multiples
            Iterator<String> iterator = typeMap.keySet().iterator();
            while(iterator.hasNext()) {
                String type = iterator.next();
                if (typeMap.get(type).size() <= 1) {
                    iterator.remove();
                }
            }
        }
        return typeMap;
    }
}