package com.vikhi.pojo;

import java.util.List;

public class TempStudent extends Student{

	public TempStudent(long id, String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		super(id, name, age, address, mobileNumbers, true);
	}
	
	public TempStudent(final Student student) {
		this(student.getId(), student.getName(), student.getAge(), 
				student.getAddress(), student.getMobileNumber());
	}
	
}
