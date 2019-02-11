package com.ttb.web.taxburden.model;

import com.ttb.service.taxburden.domain.TaxFilingStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaxPayerProfile {

	public static final String BASIC_CONSUMER_EXPENDITURE_PROFILE_KEY = "BASIC";

	private String taxPayerProfileKey;
	private List<PoliticalDivision> politicalDivisions;
	private MonetaryAmount annualIncome;
	private MonetaryAmount mortgageInterest;
	private MonetaryAmount realPropertyMarketValue;
	private String consumerExpenditureProfileKey = BASIC_CONSUMER_EXPENDITURE_PROFILE_KEY;
	private TaxFilingStatus taxFilingStatus = TaxFilingStatus.SINGLE;
	private MonetaryAmount preTaxContributions;
	private MonetaryAmount otherItemizedDeductions;
	private Integer dependents;

	/**
	 * 
	 */
	public TaxPayerProfile() {
		super();
	}

	/**
	 * @param politicalDivisionKeys
	 */
	public TaxPayerProfile(List<PoliticalDivision> politicalDivisionKeys) {
		super();
		this.politicalDivisions = politicalDivisionKeys;
	}

	/**
	 * @param politicalDivisions
	 * @param annualIncome
	 * @param mortgageInterest
	 */
	public TaxPayerProfile(List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome,
						   MonetaryAmount mortgageInterest) {
		super();
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
	}

	public TaxPayerProfile(List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue, TaxFilingStatus taxFilingStatus, MonetaryAmount preTaxContributions, MonetaryAmount otherItemizedDeductions, Integer dependents) {
		super();
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
		this.realPropertyMarketValue = realPropertyMarketValue;
		this.taxFilingStatus = taxFilingStatus;
		this.preTaxContributions = preTaxContributions;
		this.otherItemizedDeductions = otherItemizedDeductions;
		this.dependents = dependents;
	}

	public TaxPayerProfile(String taxPayerProfileKey, List<PoliticalDivision> politicalDivisions, MonetaryAmount annualIncome, MonetaryAmount mortgageInterest, MonetaryAmount realPropertyMarketValue, String consumerExpenditureProfileKey, TaxFilingStatus taxFilingStatus, MonetaryAmount preTaxContributions, MonetaryAmount otherItemizedDeductions, Integer dependents) {		super();
		this.taxPayerProfileKey = taxPayerProfileKey;
		this.politicalDivisions = politicalDivisions;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
		this.realPropertyMarketValue = realPropertyMarketValue;
		this.consumerExpenditureProfileKey = consumerExpenditureProfileKey;
		this.taxFilingStatus = taxFilingStatus;
		this.preTaxContributions = preTaxContributions;
		this.otherItemizedDeductions = otherItemizedDeductions;
		this.dependents = dependents;
	}

	/**
	 * @param clientTaxPayerProfile
	 */
	public TaxPayerProfile(com.ttb.service.taxburden.domain.TaxPayerProfile clientTaxPayerProfile) {
		super();
		this.taxPayerProfileKey = clientTaxPayerProfile.getTaxPayerProfileKey();
		this.politicalDivisions = toWebPoliticalDivisions(clientTaxPayerProfile.getPoliticalDivisions());
		this.annualIncome = new MonetaryAmount(clientTaxPayerProfile.getAnnualIncome());
		this.mortgageInterest = new MonetaryAmount(clientTaxPayerProfile.getMortgageInterest());
		this.realPropertyMarketValue = new MonetaryAmount(clientTaxPayerProfile.getRealPropertyMarketValue());
		this.consumerExpenditureProfileKey = clientTaxPayerProfile.getConsumerExpenditureProfileKey();
		this.taxFilingStatus = clientTaxPayerProfile.getTaxFilingStatus();
		this.preTaxContributions = new MonetaryAmount(clientTaxPayerProfile.getPreTaxContributions());
		this.otherItemizedDeductions = new MonetaryAmount(clientTaxPayerProfile.getOtherItemizedDeductions());
		this.dependents = clientTaxPayerProfile.getDependents();
	}

	/**
	 * @return com.ttb.service.taxburden.domain.TaxPayerProfile
	 */
	public com.ttb.service.taxburden.domain.TaxPayerProfile toClientTaxPayerProfile() {
		// Handle nulls
		if (this.annualIncome == null) {
			this.annualIncome = new MonetaryAmount(BigDecimal.ZERO);
		}
		if (this.mortgageInterest == null) {
			this.mortgageInterest = new MonetaryAmount(BigDecimal.ZERO);
		}
		if (this.realPropertyMarketValue == null) {
			this.realPropertyMarketValue = new MonetaryAmount(BigDecimal.ZERO);
		}
		if (this.preTaxContributions == null) {
			this.preTaxContributions = new MonetaryAmount(BigDecimal.ZERO);
		}
		if (this.otherItemizedDeductions == null) {
			this.otherItemizedDeductions = new MonetaryAmount(BigDecimal.ZERO);
		}
		return new com.ttb.service.taxburden.domain.TaxPayerProfile(this.getTaxPayerProfileKey(),
				null,
				toServicePoliticalDivisions(this.politicalDivisions),
				this.annualIncome.toClientMonetaryAmount(),
				this.mortgageInterest.toClientMonetaryAmount(),
				this.realPropertyMarketValue.toClientMonetaryAmount(),
				this.getConsumerExpenditureProfileKey(),
				this.getTaxFilingStatus(),
				this.getPreTaxContributions().toClientMonetaryAmount(),
				this.getOtherItemizedDeductions().toClientMonetaryAmount(),
				this.getDependents());
	}

	public String getTaxPayerProfileKey() {
		return taxPayerProfileKey;
	}

	public void setTaxPayerProfileKey(String taxPayerProfileKey) {
		this.taxPayerProfileKey = taxPayerProfileKey;
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

	public String getConsumerExpenditureProfileKey() {
		return consumerExpenditureProfileKey;
	}

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

	public static List<PoliticalDivision> toWebPoliticalDivisions(List<com.ttb.service.taxburden.domain.PoliticalDivision> servicePoliticalDivisions) {
		List<PoliticalDivision> webPoliticalDivisions = new ArrayList<PoliticalDivision>();
		if (servicePoliticalDivisions != null) {
			servicePoliticalDivisions.forEach(p -> webPoliticalDivisions.add(new PoliticalDivision(p)));
		}
		return webPoliticalDivisions;
	}

	public static List<com.ttb.service.taxburden.domain.PoliticalDivision> toServicePoliticalDivisions(List<PoliticalDivision> webPoliticalDivisions) {
		List<com.ttb.service.taxburden.domain.PoliticalDivision> servicePoliticalDivisions = new ArrayList<com.ttb.service.taxburden.domain.PoliticalDivision>();
		if (webPoliticalDivisions != null) {
			webPoliticalDivisions.forEach(p -> servicePoliticalDivisions.add(
					new com.ttb.service.taxburden.domain.PoliticalDivision(p.getFips(), p.getName(), p.getDescription(), com.ttb.service.taxburden.domain.PoliticalDivisionType.valueOf(p.getType().name())))
			);
		}
		return servicePoliticalDivisions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TaxPayerProfile)) return false;
		TaxPayerProfile that = (TaxPayerProfile) o;
		return Objects.equals(taxPayerProfileKey, that.taxPayerProfileKey) &&
				Objects.equals(politicalDivisions, that.politicalDivisions) &&
				Objects.equals(annualIncome, that.annualIncome) &&
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
		return Objects.hash(taxPayerProfileKey, politicalDivisions, annualIncome, mortgageInterest, realPropertyMarketValue, consumerExpenditureProfileKey, taxFilingStatus, preTaxContributions, otherItemizedDeductions, dependents);
	}

	@Override
	public String toString() {
		return "TaxPayerProfile{" +
				"taxPayerProfileKey='" + taxPayerProfileKey + '\'' +
				", politicalDivisions=" + politicalDivisions +
				", annualIncome=" + annualIncome +
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
