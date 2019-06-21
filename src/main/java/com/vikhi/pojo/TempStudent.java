package com.vikhi.pojo;

import java.util.List;

public class TempStudent {

	public String name;
    public int age;
    public Address address;
    public List<MobileNumber> mobileNumbers;
    
	public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}
	
	public TempStudent(final Student student) {
		this.name = student.getName();
		this.age = student.getAge();
		this.address = student.getAddress();
		this.mobileNumbers = student.getMobileNumber();
	}

	public String getName() {
		return name;
	}
	
}
