package com.vikhi.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.pojo.MobileNumber;
import com.vikhi.pojo.Student;
import com.vikhi.service.MobileNumberService;

public class MobileNumberServiceTest {
	
	private MobileNumberService mobileNumberService;
	private Student student;
	
	@Before
	public void init() {
		mobileNumberService = new MobileNumberService();
		student = new Student();
	}

	@Test
	public void isStudentHasMobileNumber() {
		
		student.setMobileNumber(Arrays.asList(
				new MobileNumber("91", "123456"), 
				new MobileNumber("91", "634578"), 
				new MobileNumber("92", "989224")));
		
		assertTrue(mobileNumberService.isStudentHasNumber(student, 
				new MobileNumber("91", "123456")));
		
		assertTrue(mobileNumberService.isStudentHasNumbers(student, 
				new MobileNumber("91", "123456"), new MobileNumber("92", "989224")));
		
		assertFalse(mobileNumberService.isStudentHasNumbers(student, 
				new MobileNumber("91", "123456"), new MobileNumber("92", "634578")));
	}
}
