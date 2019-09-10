package com.vikhi.service;

import java.util.Arrays;

import com.vikhi.pojo.MobileNumber;
import com.vikhi.pojo.Student;

public class MobileNumberService {

	public Boolean isStudentWithMobileNumber(Student student, MobileNumber... mobileNumbers) {
		return Arrays.stream(mobileNumbers)
				.allMatch(mn -> student.getMobileNumber().contains(mn));
	}
}
