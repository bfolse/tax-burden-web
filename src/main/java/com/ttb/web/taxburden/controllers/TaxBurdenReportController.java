package com.ttb.web.taxburden.controllers;

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
import com.ttb.web.taxburden.model.TaxBurdenReport;
import com.ttb.web.taxburden.model.TaxPayerProfile;

@Controller
@SessionAttributes("taxPayerProfile")
public class TaxBurdenReportController {
	private static final Logger logger = LoggerFactory.getLogger(TaxBurdenReportController.class);
	private static final String TAX_PAYER_PROFILE_MODEL_ATTRIBUTE = "taxPayerProfile";
	
	@Autowired
	TaxBurdenServiceClient taxBurdenServiceClient;

    @GetMapping("/report")
    public String reportForm(@ModelAttribute(TAX_PAYER_PROFILE_MODEL_ATTRIBUTE) TaxPayerProfile taxPayerProfile, Model model) {
    	logger.debug("taxPayerProfile: " + taxPayerProfile + " model: " + model);
    	if (!model.containsAttribute(TAX_PAYER_PROFILE_MODEL_ATTRIBUTE)) {
    		model.addAttribute(TAX_PAYER_PROFILE_MODEL_ATTRIBUTE, taxPayerProfile);
    	}
    	
        return "report-select";
    }
    
    @PostMapping("/report")
    public String reportSubmit(@ModelAttribute TaxPayerProfile taxPayerProfile, Model model) {
    	logger.debug("taxPayerProfile: " + taxPayerProfile + " model: " + model);
    	com.ttb.service.taxburden.domain.TaxBurdenReport clientTaxBurdenReport = taxBurdenServiceClient.createReport(taxPayerProfile.toClientTaxPayerProfile());
    	model.addAttribute("taxBurdenReport", new TaxBurdenReport(clientTaxBurdenReport));
        return "report-confirm";
    }
}
