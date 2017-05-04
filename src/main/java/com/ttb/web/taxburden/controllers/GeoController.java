package com.ttb.web.taxburden.controllers;

import java.util.List;

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

@Controller
@SessionAttributes("taxPayerProfile")
public class GeoController {
	private static final Logger logger = LoggerFactory.getLogger(GeoController.class);

	@Autowired
	TaxBurdenServiceClient taxBurdenServiceClient;
	
    @GetMapping("/geo")
    public String geoForm(Model model) {
    	model.addAttribute("taxPayerProfile", new TaxPayerProfile());
        return "geo-select";
    }
    
    @PostMapping("/geo")
    public String geoSubmit(@ModelAttribute("taxPayerProfile") TaxPayerProfile taxPayerProfile, Model model) {
    	logger.debug("taxPayerProfile: " + taxPayerProfile);
    	String postalCode = taxPayerProfile.getPostalCode();
    	List<String> politicalDivisionKeys = taxBurdenServiceClient.politicalDivisionLookup(postalCode);
    	taxPayerProfile.setPoliticalDivisionKeys(politicalDivisionKeys);
    	
        return "geo-confirm";
    }
}