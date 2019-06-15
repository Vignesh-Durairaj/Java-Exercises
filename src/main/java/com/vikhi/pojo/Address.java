package com.vikhi.pojo;

public class Address {

	private String City;
	
	private String zipCode;

	public Address(String city, String zipCode) {
		super();
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
