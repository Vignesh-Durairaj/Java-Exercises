package com.vikhi.pojo;

public class Student {

	private String name;
	
	private int age;
	
	private Address address;
	
	private MobileNumber mobileNumber;

	public Student(String name, int age, Address address, MobileNumber mobileNumber) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MobileNumber getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(MobileNumber mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ "]";
	}
	
}
