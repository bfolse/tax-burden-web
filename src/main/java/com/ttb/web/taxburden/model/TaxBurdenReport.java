package com.ttb.web.taxburden.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class TaxBurdenReport {
	private String reportKey;
    private Date timestamp;
    private TaxPayerProfile taxPayerProfile;
    private List<TaxEntry> taxEntries;

	private static final Logger logger = LoggerFactory.getLogger(TaxBurdenReport.class);

    /**
	 * 
	 */
	public TaxBurdenReport() {
		super();
	}

	/**
	 * @param reportKey
	 * @param timestamp
	 * @param taxPayerProfile
	 * @param taxEntries
	 */
	public TaxBurdenReport(String reportKey, Date timestamp, TaxPayerProfile taxPayerProfile,
			List<TaxEntry> taxEntries) {
		super();
		this.reportKey = reportKey;
		this.timestamp = timestamp;
		this.taxPayerProfile = taxPayerProfile;
		this.taxEntries = taxEntries;
	}

	public TaxBurdenReport(com.ttb.service.taxburden.domain.TaxBurdenReport clientTaxBurdenReport) {
		super();
		this.reportKey = clientTaxBurdenReport.getReportKey();
		this.timestamp = clientTaxBurdenReport.getTimestamp();
		this.taxPayerProfile = new TaxPayerProfile(clientTaxBurdenReport.getTaxPayerProfile());
		this.taxEntries = TaxBurdenReport.clientTaxEntryListToTaxEntryList(clientTaxBurdenReport.getTaxEntries());
		
	}
	
	private static List<TaxEntry> clientTaxEntryListToTaxEntryList(List<com.ttb.service.taxburden.domain.TaxEntry> clientTaxEntries) {
		List<TaxEntry> taxEntries = new ArrayList<TaxEntry>();
		for (com.ttb.service.taxburden.domain.TaxEntry clientTaxEntry : clientTaxEntries) {
			taxEntries.add(new TaxEntry(clientTaxEntry));
		}
		return taxEntries;
	}

	/**
	 * @return the reportKey
	 */
	public String getReportKey() {
		return reportKey;
	}

	/**
	 * @param reportKey the reportKey to set
	 */
	public void setReportKey(String reportKey) {
		this.reportKey = reportKey;
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
	 * @return the taxPayerProfile
	 */
	public TaxPayerProfile getTaxPayerProfile() {
		return taxPayerProfile;
	}

	/**
	 * @param taxPayerProfile the taxPayerProfile to set
	 */
	public void setTaxPayerProfile(TaxPayerProfile taxPayerProfile) {
		this.taxPayerProfile = taxPayerProfile;
	}

	/**
	 * @return the taxEntries
	 */
	public List<TaxEntry> getTaxEntries() {
		return taxEntries;
	}

	public List<TaxEntry> getSortedTaxEntries() {
		List<TaxEntry> sortedTaxEntries = taxEntries;
		Collections.sort(sortedTaxEntries, new TaxEntrySortComparator());
		return sortedTaxEntries;
	}

	private class TaxEntrySortComparator implements Comparator<TaxEntry> {
		@Override
		public int compare(TaxEntry te1, TaxEntry te2) {
			return te1.getTaxType().getLevel() - te2.getTaxType().getLevel();
		}
	}

	/**
	 * @param taxEntries the taxEntries to set
	 */
	public void setTaxEntries(List<TaxEntry> taxEntries) {
		this.taxEntries = taxEntries;
	}

	public MonetaryAmount getTaxEntriesTotal() {
		BigDecimal total = new BigDecimal(0.0);
		Currency currency = Currency.getInstance(MonetaryAmount.DEFAULT_CURRENCY_CODE);
		logger.debug("taxEntries.size: " + taxEntries.size());
		if (taxEntries != null && taxEntries.size() > 0) {
			for (TaxEntry taxEntry : taxEntries) {
				total = total.add(taxEntry.getAmount().getAmount());
			}
			currency = taxEntries.get(0).getAmount().getCurrency();
		}
		logger.debug("taxEntriesTotal: " + total);
		return new MonetaryAmount(currency, total);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reportKey == null) ? 0 : reportKey.hashCode());
		result = prime * result + ((taxEntries == null) ? 0 : taxEntries.hashCode());
		result = prime * result + ((taxPayerProfile == null) ? 0 : taxPayerProfile.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		TaxBurdenReport other = (TaxBurdenReport) obj;
		if (reportKey == null) {
			if (other.reportKey != null)
				return false;
		} else if (!reportKey.equals(other.reportKey))
			return false;
		if (taxEntries == null) {
			if (other.taxEntries != null)
				return false;
		} else if (!taxEntries.equals(other.taxEntries))
			return false;
		if (taxPayerProfile == null) {
			if (other.taxPayerProfile != null)
				return false;
		} else if (!taxPayerProfile.equals(other.taxPayerProfile))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaxBurdenReport [reportKey=" + reportKey + ", timestamp=" + timestamp + ", taxPayerProfile="
				+ taxPayerProfile + ", taxEntries=" + taxEntries + "]";
	}
}
