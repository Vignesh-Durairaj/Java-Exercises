package com.vikhi.pojo;

public class Address {

	private String City;
	private String zipCode;

	public Address() {
		// Dummy constructor
	}
	
	public Address(String city, String zipCode) {
		City = city;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
