package com.vikhi.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

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
		student.setMobileNumber(Arrays.asList(
				new MobileNumber("91", "123456"), 
				new MobileNumber("91", "634578"), 
				new MobileNumber("92", "989224"), 
				new MobileNumber(null, "123456"), 
				new MobileNumber("91", null)));
	}

	@Test
	public void isStudentHasMobileNumber() {
		assertTrue(mobileNumberService.isStudentHasNumber(student, 
				new MobileNumber("91", "123456")));
		
		assertTrue(mobileNumberService.isStudentHasNumbers(student, 
				new MobileNumber("91", "123456"), new MobileNumber("92", "989224")));
		
		assertFalse(mobileNumberService.isStudentHasNumbers(student, 
				new MobileNumber("91", "123456"), new MobileNumber("92", "634578")));
	}
	
	@Test
	public void isStudentMobileNumberDetailsAreCorrect() {
		List<MobileNumber> mobileNumbers = student.getMobileNumber();
		assertNotNull(mobileNumbers);
		mobileNumbers
			.stream()
			.filter(mobileNumber -> mobileNumber.getCountryCode() != null && mobileNumber.getNumber() != null)
			.forEach(mobileNumber -> {
			assertNotNull(mobileNumber.getNumber());
			assertNotNull(mobileNumber.hashCode());
			assertTrue("91".equals(mobileNumber.getCountryCode()) || "92".equals(mobileNumber.getCountryCode()));
			assertNotNull(mobileNumber.equals(new MobileNumber("91", "123456")));
			
		});
	}
	
	@Test
	public void isStudentHasNoMobileNumber() {
		assertNull(mobileNumberService.getMobileNumber("", ""));
	}
	
	@Test
	public void isObjectsAreEqual() {
		MobileNumber mobileNumber = student.getMobileNumber().get(0);
		assertTrue(mobileNumber.equals(student.getMobileNumber().get(0)));
		assertTrue(mobileNumber.equals(new MobileNumber("91", "123456")));
		assertFalse(mobileNumber.equals(new MobileNumber("92", "989224")));
		assertFalse(mobileNumber.equals(new MobileNumber(null, "123456")));
		assertFalse(mobileNumber.equals(new MobileNumber("91", null)));
		assertFalse(mobileNumber.equals(null));
		assertFalse(mobileNumber.equals(new MobileNumber(null, null)));
		assertFalse(mobileNumber.equals(new Student()));
		
		mobileNumber = student.getMobileNumber().get(3);
		assertTrue(mobileNumber.equals(new MobileNumber(null, "123456")));
		
		mobileNumber = student.getMobileNumber().get(4);
		assertTrue(mobileNumber.equals(new MobileNumber("91", null)));
	}
	
	@Test
	public void testHashCode() {
		assertNotNull(new MobileNumber("", "").hashCode());
		assertNotNull(new MobileNumber(null, null).hashCode());
		assertNotNull(new MobileNumber("91", "123456").hashCode());
	}
}
