package com.vikhi.pojo;

public class MobileNumber {
	
	private String countryCode = "1";
	
	private String mobileNumber;

	public MobileNumber(String countryCode, String mobileNumber) {
		this.countryCode = countryCode;
		this.mobileNumber = mobileNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "+" + countryCode + "-" + mobileNumber;
	}

}
