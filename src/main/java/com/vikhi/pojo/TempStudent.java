package com.vikhi.pojo;

import java.util.List;

public class TempStudent {

	private long id;
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumbers;
    
	public TempStudent(long id, String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}
	
	public TempStudent(final Student student) {
		this(student.getId(), student.getName(), student.getAge(), 
				student.getAddress(), student.getMobileNumber());
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

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}
	
}
