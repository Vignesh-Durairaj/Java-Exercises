package com.vikhi.service;

import java.util.Arrays;

import com.vikhi.pojo.MobileNumber;
import com.vikhi.pojo.Student;

public class MobileNumberService {

	public Boolean isStudentWithMobileNumber(Student student, MobileNumber... mobileNumbers) {
		return Arrays.stream(mobileNumbers)
				.allMatch(mobileNumber -> student.getMobileNumber().contains(mobileNumber));
	}
	
	protected Boolean isStudentHasNumber(Student student, MobileNumber mobileNumber) {
		return isStudentWithMobileNumber(student, mobileNumber);
	}
	
	protected Boolean isStudentHasNumbers(Student student, MobileNumber number1, MobileNumber number2) {
		return isStudentWithMobileNumber(student, number1, number2);
	}
}
