package com.ttb.service.taxburden;

import java.util.List;

import com.ttb.service.taxburden.domain.PoliticalDivision;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttb.service.taxburden.domain.TaxBurdenReport;
import com.ttb.service.taxburden.domain.TaxPayerProfile;

public interface TaxBurdenServiceREST {
    @RequestMapping(path="/political-division-lookup/postal-code", method=RequestMethod.GET)
    public @ResponseBody List<PoliticalDivision> politicalDivisionLookupByPostalCode(@RequestParam(value = "postalCode") String postalCode);

    @RequestMapping(path="/political-division-lookup/latitude-longitude", method=RequestMethod.GET)
    public @ResponseBody List<PoliticalDivision> politicalDivisionLookupByLatitudeLongitude(@RequestParam(value = "latitude") String latitude, @RequestParam(value = "longitude") String longitude);

    @RequestMapping(path="/tax-burden", method=RequestMethod.GET)
    public @ResponseBody TaxBurdenReport getReport(@RequestParam(value="key", required=true) String key);

    @RequestMapping(path="/tax-burden", method=RequestMethod.POST, consumes="application/json", produces="application/json")
    public @ResponseBody TaxBurdenReport createReport(@RequestBody TaxPayerProfile taxPayerProfile);

    @RequestMapping(path="/tax-payer-profile", method=RequestMethod.GET)
    public @ResponseBody TaxPayerProfile getTaxPayerProfile(@RequestParam(value="key", required=true) String key);

}
