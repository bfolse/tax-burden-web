package com.ttb.service.taxburden.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TaxPayerProfile {

	public static final String BASIC_CONSUMER_EXPENDITURE_PROFILE_KEY = "BASIC";
	
	private String taxPayerProfileKey;
	private Date timestamp;
	private List<PoliticalDivision> politicalDivisions;
	private MonetaryAmount annualIncome;
	private MonetaryAmount selfEmployedIncome;
	private MonetaryAmount capitalGainsIncome;
	private MonetaryAmount mortgageInterest;
	private MonetaryAmount realPropertyMarketValue;
	private String consumerExpenditureProfileKey;
	private TaxFilingStatus taxFilingStatus;
	private MonetaryAmount preTaxContributions;
	private MonetaryAmount otherItemizedDeductions;
	private Integer dependents;

	/**
	 * 
	 */
	public TaxPayerProfile() {
		super();
		this.timestamp = new Date();
		this.taxPayerProfileKey = UUID.randomUUID().toString();
		this.consumerExpenditureProfileKey = BASIC_CONSUMER_EXPENDITURE_PROFILE_KEY;
	}

	/**
	 * @param politicalDivisions
	 * @param annualIncome
	 * @param mortgageInterest
	 */
	public TaxPayerProfile(List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue) {
		super();
		this.timestamp = new Date();
		this.taxPayerProfileKey = UUID.randomUUID().toString();
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
		this.realPropertyMarketValue = realPropertyMarketValue;
		this.consumerExpenditureProfileKey = BASIC_CONSUMER_EXPENDITURE_PROFILE_KEY;
	}

	/**
	 * @param politicalDivisions
	 * @param annualIncome
	 * @param mortgageInterest
	 */
	public TaxPayerProfile(List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue, String consumerExpenditureProfileKey) {
		super();
		this.timestamp = new Date();
		this.taxPayerProfileKey = UUID.randomUUID().toString();
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
		this.realPropertyMarketValue = realPropertyMarketValue;
		this.consumerExpenditureProfileKey = consumerExpenditureProfileKey;
	}

	/**
	 * @param taxPayerProfileKey
	 * @param timestamp
	 * @param politicalDivisions
	 * @param annualIncome
	 * @param mortgageInterest
	 */
	public TaxPayerProfile(String taxPayerProfileKey, Date timestamp, List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue, String consumerExpenditureProfileKey) {
		super();
		if (taxPayerProfileKey == null) {
			this.taxPayerProfileKey = UUID.randomUUID().toString();
		} else {
			this.taxPayerProfileKey = taxPayerProfileKey;
		}
		if (timestamp == null) {
			this.timestamp = new Date();
		} else {
			this.timestamp = timestamp;
		}
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
		this.realPropertyMarketValue = realPropertyMarketValue;
		this.consumerExpenditureProfileKey = consumerExpenditureProfileKey;
	}

	public TaxPayerProfile(String taxPayerProfileKey, Date timestamp, List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome, MonetaryAmount selfEmployedIncome, MonetaryAmount capitalGainsIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue, String consumerExpenditureProfileKey, TaxFilingStatus taxFilingStatus, MonetaryAmount preTaxContributions, MonetaryAmount otherItemizedDeductions, Integer dependents) {
		if (taxPayerProfileKey == null) {
			this.taxPayerProfileKey = UUID.randomUUID().toString();
		} else {
			this.taxPayerProfileKey = taxPayerProfileKey;
		}
		if (timestamp == null) {
			this.timestamp = new Date();
		} else {
			this.timestamp = timestamp;
		}
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.selfEmployedIncome = selfEmployedIncome;
		this.capitalGainsIncome = capitalGainsIncome;
		this.mortgageInterest = mortgageInterest;
		this.realPropertyMarketValue = realPropertyMarketValue;
		this.consumerExpenditureProfileKey = consumerExpenditureProfileKey;
		this.taxFilingStatus = taxFilingStatus;
		this.preTaxContributions = preTaxContributions;
		this.otherItemizedDeductions = otherItemizedDeductions;
		this.dependents = dependents;
	}

	/**
	 * @return the taxPayerProfileKey
	 */
	public String getTaxPayerProfileKey() {
		return taxPayerProfileKey;
	}

	/**
	 * @param taxPayerProfileKey the taxPayerProfileKey to set
	 */
	public void setTaxPayerProfileKey(String taxPayerProfileKey) {
		this.taxPayerProfileKey = taxPayerProfileKey;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the politicalDivisions
	 */
	public List<PoliticalDivision> getPoliticalDivisions() {
		return politicalDivisions;
	}

	/**
	 * @param politicalDivisions the politicalDivisions to set
	 */
	public void setPoliticalDivisions(List<PoliticalDivision> politicalDivisions) {
		this.politicalDivisions = politicalDivisions;
	}

	/**
	 * @return the annualIncome
	 */
	public MonetaryAmount getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * @param annualIncome the annualIncome to set
	 */
	public void setAnnualIncome(MonetaryAmount annualIncome) {
		this.annualIncome = annualIncome;
	}

	public MonetaryAmount getSelfEmployedIncome() {
		return selfEmployedIncome;
	}

	public void setSelfEmployedIncome(MonetaryAmount selfEmployedIncome) {
		this.selfEmployedIncome = selfEmployedIncome;
	}

	public MonetaryAmount getCapitalGainsIncome() {
		return capitalGainsIncome;
	}

	public void setCapitalGainsIncome(MonetaryAmount capitalGainsIncome) {
		this.capitalGainsIncome = capitalGainsIncome;
	}

	/**
	 * @return the mortgageInterest
	 */
	public MonetaryAmount getMortgageInterest() {
		return mortgageInterest;
	}

	/**
	 * @param mortgageInterest the mortgageInterest to set
	 */
	public void setMortgageInterest(MonetaryAmount mortgageInterest) {
		this.mortgageInterest = mortgageInterest;
	}

	/**
	 * @return the realPropertyMarketValue
	 */
	public MonetaryAmount getRealPropertyMarketValue() {
		return realPropertyMarketValue;
	}

	/**
	 * @param realPropertyMarketValue the realPropertyMarketValue to set
	 */
	public void setRealPropertyMarketValue(MonetaryAmount realPropertyMarketValue) {
		this.realPropertyMarketValue = realPropertyMarketValue;
	}

	/**
	 * @return the consumerExpenditureProfileKey
	 */
	public String getConsumerExpenditureProfileKey() {
		return consumerExpenditureProfileKey;
	}

	/**
	 * @param consumerExpenditureProfileKey the consumerExpenditureProfileKey to set
	 */
	public void setConsumerExpenditureProfileKey(String consumerExpenditureProfileKey) {
		this.consumerExpenditureProfileKey = consumerExpenditureProfileKey;
	}

	public TaxFilingStatus getTaxFilingStatus() {
		return taxFilingStatus;
	}

	public void setTaxFilingStatus(TaxFilingStatus taxFilingStatus) {
		this.taxFilingStatus = taxFilingStatus;
	}

	public MonetaryAmount getPreTaxContributions() {
		return preTaxContributions;
	}

	public void setPreTaxContributions(MonetaryAmount preTaxContributions) {
		this.preTaxContributions = preTaxContributions;
	}

	public MonetaryAmount getOtherItemizedDeductions() {
		return otherItemizedDeductions;
	}

	public void setOtherItemizedDeductions(MonetaryAmount otherItemizedDeductions) {
		this.otherItemizedDeductions = otherItemizedDeductions;
	}

	public Integer getDependents() {
		return dependents;
	}

	public void setDependents(Integer dependents) {
		this.dependents = dependents;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TaxPayerProfile)) return false;
		TaxPayerProfile that = (TaxPayerProfile) o;
		return Objects.equals(taxPayerProfileKey, that.taxPayerProfileKey) &&
				Objects.equals(timestamp, that.timestamp) &&
				Objects.equals(politicalDivisions, that.politicalDivisions) &&
				Objects.equals(annualIncome, that.annualIncome) &&
				Objects.equals(selfEmployedIncome, that.selfEmployedIncome) &&
				Objects.equals(capitalGainsIncome, that.capitalGainsIncome) &&
				Objects.equals(mortgageInterest, that.mortgageInterest) &&
				Objects.equals(realPropertyMarketValue, that.realPropertyMarketValue) &&
				Objects.equals(consumerExpenditureProfileKey, that.consumerExpenditureProfileKey) &&
				taxFilingStatus == that.taxFilingStatus &&
				Objects.equals(preTaxContributions, that.preTaxContributions) &&
				Objects.equals(otherItemizedDeductions, that.otherItemizedDeductions) &&
				Objects.equals(dependents, that.dependents);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taxPayerProfileKey, timestamp, politicalDivisions, annualIncome, selfEmployedIncome, capitalGainsIncome, mortgageInterest, realPropertyMarketValue, consumerExpenditureProfileKey, taxFilingStatus, preTaxContributions, otherItemizedDeductions, dependents);
	}

	@Override
	public String toString() {
		return "TaxPayerProfile{" +
				"taxPayerProfileKey='" + taxPayerProfileKey + '\'' +
				", timestamp=" + timestamp +
				", politicalDivisions=" + politicalDivisions +
				", annualIncome=" + annualIncome +
				", selfEmployedIncome=" + selfEmployedIncome +
				", capitalGainsIncome=" + capitalGainsIncome +
				", mortgageInterest=" + mortgageInterest +
				", realPropertyMarketValue=" + realPropertyMarketValue +
				", consumerExpenditureProfileKey='" + consumerExpenditureProfileKey + '\'' +
				", taxFilingStatus=" + taxFilingStatus +
				", preTaxContributions=" + preTaxContributions +
				", otherItemizedDeductions=" + otherItemizedDeductions +
				", dependents=" + dependents +
				'}';
	}
}
