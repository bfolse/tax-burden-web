package com.ttb.web.taxburden.model;

public enum TaxType {
	INCOME_FEDERAL(1),
	INCOME_STATE(2),
	INCOME_CITY(3),
	INCOME_COUNTY(4),
	CAPITAL_GAINS_FEDERAL(5),
	PAYROLL_FEDERAL(6),
	PAYROLL_SELF_EMP_FEDERAL(7),
	PAYROLL_COUNTY(8),
	PAYROLL_CITY(9),
	PROPERTY_STATE(10),
	PROPERTY_COUNTY(11),
	PROPERTY_CITY(12),
	SALES_STATE(13),
	SALES_COUNTY(14),
	SALES_CITY(15),
	FUEL_FEDERAL(16),
	FUEL_STATE(17)
	;

	private int level;

	TaxType(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}