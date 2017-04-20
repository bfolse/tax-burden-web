package com.ttb.web.taxburden.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttb.TaxBurdenServiceClient;
import com.ttb.service.taxburden.domain.PostalCodePoliticalDivision;

@Controller
public class GeoController {
	private static final Logger logger = LoggerFactory.getLogger(GeoController.class);

	@Autowired
	TaxBurdenServiceClient taxBurdenServiceClient;
	
    @RequestMapping("/geo")
    public String greeting(@RequestParam(value="postalCode", required=true) String postalCode, Model model) {
    	logger.debug("postalCode: " + postalCode);
    	List<PostalCodePoliticalDivision> politicalDivisions = taxBurdenServiceClient.politicalDivisionLookup(postalCode);
    	model.addAttribute("politicalDivisions", politicalDivisions);
        model.addAttribute("postalCode", postalCode);
        // TODO Retrieve from geo-service
        return "geo";
    }
}