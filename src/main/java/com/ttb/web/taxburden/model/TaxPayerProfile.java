package com.ttb.web.taxburden.model;

import java.util.ArrayList;
import java.util.List;

public class TaxPayerProfile {
	private String postalCode;
	private List<PoliticalDivision> politicalDivisions;
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
	public TaxPayerProfile(String postalCode, List<PoliticalDivision> politicalDivisionKeys) {
		super();
		this.postalCode = postalCode;
		this.politicalDivisions = politicalDivisionKeys;
	}

	/**
	 * @param postalCode
	 * @param politicalDivisionKeys
	 * @param annualIncome
	 * @param mortgageInterest
	 */
	public TaxPayerProfile(String postalCode, List<PoliticalDivision> politicalDivisionKeys, MonetaryAmount annualIncome,
						   MonetaryAmount mortgageInterest) {
		super();
		this.postalCode = postalCode;
		this.politicalDivisions = politicalDivisionKeys;
		this.annualIncome = annualIncome;
		this.mortgageInterest = mortgageInterest;
	}

	/**
	 * @param clientTaxPayerProfile
	 */
	public TaxPayerProfile(com.ttb.service.taxburden.domain.TaxPayerProfile clientTaxPayerProfile) {
		super();
		this.postalCode = clientTaxPayerProfile.getPostalCode();
		this.politicalDivisions = toWebPoliticalDivisions(clientTaxPayerProfile.getPoliticalDivisions());
		this.annualIncome = new MonetaryAmount(clientTaxPayerProfile.getAnnualIncome());
		this.mortgageInterest = new MonetaryAmount(clientTaxPayerProfile.getMortgageInterest());
	}

	/**
	 * @return com.ttb.service.taxburden.domain.TaxPayerProfile
	 */
	public com.ttb.service.taxburden.domain.TaxPayerProfile toClientTaxPayerProfile() {
		return new com.ttb.service.taxburden.domain.TaxPayerProfile(this.postalCode, toServicePoliticalDivisions(this.politicalDivisions),
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
					new com.ttb.service.taxburden.domain.PoliticalDivision(p.getFips(), p.getName(), p.getDescription(), p.getType()))
			);
		}
		return servicePoliticalDivisions;
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		TaxPayerProfile that = (TaxPayerProfile) object;
		return java.util.Objects.equals(postalCode, that.postalCode) &&
				java.util.Objects.equals(politicalDivisions, that.politicalDivisions) &&
				java.util.Objects.equals(annualIncome, that.annualIncome) &&
				java.util.Objects.equals(mortgageInterest, that.mortgageInterest) &&
				java.util.Objects.equals(realPropertyMarketValue, that.realPropertyMarketValue);
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), postalCode, politicalDivisions, annualIncome, mortgageInterest, realPropertyMarketValue);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "TaxPayerProfile{" +
				"postalCode='" + postalCode + '\'' +
				", politicalDivisions=" + politicalDivisions +
				", annualIncome=" + annualIncome +
				", mortgageInterest=" + mortgageInterest +
				", realPropertyMarketValue=" + realPropertyMarketValue +
				'}';
	}
}
