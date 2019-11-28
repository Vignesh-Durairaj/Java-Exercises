package com.vikhi.pojo;

public class Address {

	private String city;
	private String zipCode;

	public Address() {
		// Dummy constructor
	}
	
	public Address(String city, String zipCode) {
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
