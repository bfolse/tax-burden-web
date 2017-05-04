package com.ttb.web.taxburden.model;

import java.util.List;

public class TaxPayerProfile {
	private String postalCode;
	private List<String> politicalDivisionKeys;
	private MonetaryAmount annualIncome;
	private MonetaryAmount mortgageInterest;
	
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

	public TaxPayerProfile(com.ttb.service.taxburden.domain.TaxPayerProfile clientTaxPayerProfile) {
		super();
		this.postalCode = clientTaxPayerProfile.getPostalCode();
		this.politicalDivisionKeys = clientTaxPayerProfile.getPoliticalDivisionKeys();
		this.annualIncome = new MonetaryAmount(clientTaxPayerProfile.getAnnualIncome());
		this.mortgageInterest = new MonetaryAmount(clientTaxPayerProfile.getMortgageInterest());
	}
	
	public com.ttb.service.taxburden.domain.TaxPayerProfile toClientTaxPayerProfile() {
		return new com.ttb.service.taxburden.domain.TaxPayerProfile(this.postalCode, this.politicalDivisionKeys, 
				this.annualIncome.toClientMonetaryAmount(), this.mortgageInterest.toClientMonetaryAmount());
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annualIncome == null) ? 0 : annualIncome.hashCode());
		result = prime * result + ((mortgageInterest == null) ? 0 : mortgageInterest.hashCode());
		result = prime * result + ((politicalDivisionKeys == null) ? 0 : politicalDivisionKeys.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxPayerProfile other = (TaxPayerProfile) obj;
		if (annualIncome == null) {
			if (other.annualIncome != null)
				return false;
		} else if (!annualIncome.equals(other.annualIncome))
			return false;
		if (mortgageInterest == null) {
			if (other.mortgageInterest != null)
				return false;
		} else if (!mortgageInterest.equals(other.mortgageInterest))
			return false;
		if (politicalDivisionKeys == null) {
			if (other.politicalDivisionKeys != null)
				return false;
		} else if (!politicalDivisionKeys.equals(other.politicalDivisionKeys))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaxPayerProfile [postalCode=" + postalCode + ", politicalDivisionKeys=" + politicalDivisionKeys
				+ ", annualIncome=" + annualIncome + ", mortgageInterest=" + mortgageInterest + "]";
	}

}
