package com.vikhi.pojo;

public class MobileNumber {
	
	private String countryCode = "1";
	
	private String number;

	public MobileNumber(String countryCode, String number) {
		this.countryCode = countryCode;
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String mobileNumber) {
		this.number = mobileNumber;
	}

	@Override
	public String toString() {
		return "+" + countryCode + "-" + number;
	}

}
