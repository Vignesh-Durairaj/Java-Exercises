package com.vikhi.dao;

import static com.vikhi.util.ConstantsHelper.SYMBOL_BLANK;

import java.util.Arrays;
import java.util.List;

import com.vikhi.pojo.Student;

public class StudentDao {
	
	private AddressDao addressDao;
	private MobileNumberDao mobileNumberDao;
	
	public StudentDao() {
		addressDao = new AddressDao();
		mobileNumberDao = new MobileNumberDao();
	}

	public List<Student> getAllStudents() {
		return Arrays.asList(
				new Student(1, "Kumar", 25, addressDao.getAddressByZipCode("641005"), mobileNumberDao.getMobileNumberByCountry("91")), 
				new Student(2, "Patel", 50, addressDao.getAddressByZipCode("600100"), Arrays.asList(mobileNumberDao.getMobileNumber("91", "9443990380"))), 
				new Student(3, "Singh", 34, addressDao.getAddressByZipCode(SYMBOL_BLANK), mobileNumberDao.getMobileNumberByCountry(""), false));
	}
}
