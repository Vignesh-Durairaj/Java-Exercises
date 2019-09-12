package com.vikhi.service;

import java.util.Arrays;

import com.vikhi.dao.MobileNumberDao;
import com.vikhi.pojo.MobileNumber;
import com.vikhi.pojo.Student;

public class MobileNumberService {
	
	private MobileNumberDao mobileNumberDao;
	
	public MobileNumberService() {
		//TODO: Inject this from DI container in future.
		mobileNumberDao = new MobileNumberDao();
	}

	private Boolean isStudentWithMobileNumber(Student student, MobileNumber... mobileNumbers) {
		return Arrays.stream(mobileNumbers)
				.allMatch(mobileNumber -> student.getMobileNumber().contains(mobileNumber));
	}
	
	public Boolean isStudentHasNumber(Student student, MobileNumber mobileNumber) {
		return isStudentWithMobileNumber(student, mobileNumber);
	}
	
	public Boolean isStudentHasNumbers(Student student, MobileNumber number1, MobileNumber number2) {
		return isStudentWithMobileNumber(student, number1, number2);
	}
	
	public MobileNumber getMobileNumber(final String countryCode, final String number) {
		return mobileNumberDao.getMobileNumber(countryCode, number);
	}
}
