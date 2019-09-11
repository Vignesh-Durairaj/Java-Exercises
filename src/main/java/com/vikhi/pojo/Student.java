package com.vikhi.pojo;

import java.util.List;

public class Student {

	private long id;
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumber;

	public Student() {
		// Dummy implementation
	}
	
	public Student(long id, String name, int age, Address address, List<MobileNumber> mobileNumber) {
		setId(id);
		setName(name);
		setAge(age);
		setAddress(address);
		setMobileNumber(mobileNumber);
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
}
