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
		this.id = student.getId();
		this.name = student.getName();
		this.age = student.getAge();
		this.address = student.getAddress();
		this.mobileNumbers = student.getMobileNumber();
	}

	public String getName() {
		return name;
	}
	
}
