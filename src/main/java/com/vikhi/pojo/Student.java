package com.vikhi.pojo;

import java.util.List;

public class Student {

	private long id;
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumber;
	private boolean isTemp;

	public Student() {
		// Dummy implementation
	}
	
	public Student(long id, String name, int age, Address address, List<MobileNumber> mobileNumber) {
		setId(id);
		setName(name);
		setAge(age);
		setAddress(address);
		setMobileNumber(mobileNumber);
		setTemp(true);
	}
	
	public Student(long id, String name, int age, Address address, List<MobileNumber> mobileNumber, boolean isTemp) {
		this(id, name, age, address, mobileNumber);
		this.isTemp = isTemp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<MobileNumber> getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(List<MobileNumber> mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isTemp() {
		return isTemp;
	}

	public void setTemp(boolean isTemp) {
		this.isTemp = isTemp;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
}
