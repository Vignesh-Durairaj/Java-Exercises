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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobileNumber other = (MobileNumber) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number)) {
			return false;
		}
		return true;
	}

}
