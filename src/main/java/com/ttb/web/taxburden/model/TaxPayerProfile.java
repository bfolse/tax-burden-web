package com.ttb.web.taxburden.model;

import java.util.List;

public class TaxPayerProfile {
	private String postalCode;
	private List<String> politicalDivisionKeys;
	private MonetaryAmount annualIncome;
	private MonetaryAmount mortgageInterest;
	private MonetaryAmount realPropertyMarketValue;

	/**
	 * 
	 */
	public TaxPayerProfile() {
		super();
	}

	/**
	 * @param postalCode
	 */
	public TaxPayerProfile(String postalCode) {
		super();
		this.postalCode = postalCode;
	}

	/**
	 * @param postalCode
	 * @param politicalDivisionKeys
	 */
	public TaxPayerProfile(String postalCode, List<String> politicalDivisionKeys) {
		super();
		this.postalCode = postalCode;
		this.politicalDivisionKeys = politicalDivisionKeys;
	}

	/**
	 * @param postalCode
	 * @param politicalDivisionKeys
	 * @param annualIncome
	 * @param mortgageInterest
	 */
	public TaxPayerProfile(String postalCode, List<String> politicalDivisionKeys, MonetaryAmount annualIncome,
			MonetaryAmount mortgageInterest) {
		super();
		this.postalCode = postalCode;
		this.politicalDivisionKeys = politicalDivisionKeys;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
	}

	/**
	 * @param taxPayerProfile
	 */
	public TaxPayerProfile(com.ttb.service.taxburden.domain.TaxPayerProfile clientTaxPayerProfile) {
		super();
		this.postalCode = clientTaxPayerProfile.getPostalCode();
		this.politicalDivisionKeys = clientTaxPayerProfile.getPoliticalDivisionKeys();
		this.annualIncome = new MonetaryAmount(clientTaxPayerProfile.getAnnualIncome());
		this.mortgageInterest = new MonetaryAmount(clientTaxPayerProfile.getMortgageInterest());
	}

	/**
	 * @return com.ttb.service.taxburden.domain.TaxPayerProfile
	 */
	public com.ttb.service.taxburden.domain.TaxPayerProfile toClientTaxPayerProfile() {
		return new com.ttb.service.taxburden.domain.TaxPayerProfile(this.postalCode, this.politicalDivisionKeys, 
				this.annualIncome.toClientMonetaryAmount(), this.mortgageInterest.toClientMonetaryAmount(), this.realPropertyMarketValue.toClientMonetaryAmount());
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the politicalDivisionKeys
	 */
	public List<String> getPoliticalDivisionKeys() {
		return politicalDivisionKeys;
	}

	/**
	 * @param politicalDivisionKeys the politicalDivisionKeys to set
	 */
	public void setPoliticalDivisionKeys(List<String> politicalDivisionKeys) {
		this.politicalDivisionKeys = politicalDivisionKeys;
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

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		TaxPayerProfile that = (TaxPayerProfile) object;
		return java.util.Objects.equals(postalCode, that.postalCode) &&
				java.util.Objects.equals(politicalDivisionKeys, that.politicalDivisionKeys) &&
				java.util.Objects.equals(annualIncome, that.annualIncome) &&
				java.util.Objects.equals(mortgageInterest, that.mortgageInterest) &&
				java.util.Objects.equals(realPropertyMarketValue, that.realPropertyMarketValue);
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), postalCode, politicalDivisionKeys, annualIncome, mortgageInterest, realPropertyMarketValue);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "TaxPayerProfile{" +
				"postalCode='" + postalCode + '\'' +
				", politicalDivisionKeys=" + politicalDivisionKeys +
				", annualIncome=" + annualIncome +
				", mortgageInterest=" + mortgageInterest +
				", realPropertyMarketValue=" + realPropertyMarketValue +
				'}';
	}
}
