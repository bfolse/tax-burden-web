package com.ttb.web.taxburden.model;

public enum TaxType {
	INCOME_FEDERAL(1),
	INCOME_STATE(2),
	INCOME_CITY(3),
	CAPITAL_GAINS_FEDERAL(4),
	PAYROLL_FEDERAL(5),
	PAYROLL_SELF_EMP_FEDERAL(6),
	PROPERTY_STATE(7),
	PROPERTY_COUNTY(8),
	PROPERTY_CITY(9),
	SALES_STATE(10),
	SALES_COUNTY(11),
	SALES_CITY(12),
	FUEL_FEDERAL(13),
	FUEL_STATE(14)
	;

	private int level;

	TaxType(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}