package com.ttb.service.taxburden;

import java.util.List;

import com.ttb.service.taxburden.domain.MonetaryAmount;
import com.ttb.service.taxburden.domain.TaxBurdenReport;
import com.ttb.service.taxburden.domain.TaxPayerProfile;

public interface TaxBurdenService {
	public List<String> findAllPoliticalDivisionsByPostalCode(String postalCode);
	public List<String> findAllPoliticalDivisionsByLatitudeLongitude(String latitude, String longitude);
	public TaxBurdenReport createReport(TaxPayerProfile taxPayerProfile);
	public TaxPayerProfile createTaxPayerProfile(String postalCode, List<String> politicalDivisionKeys, MonetaryAmount annualIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue);
	public TaxPayerProfile findTaxPayerProfileByKey(String taxPayerProfileKey);
}
