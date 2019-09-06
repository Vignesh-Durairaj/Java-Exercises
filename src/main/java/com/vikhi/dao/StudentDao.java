package com.vikhi.dao;

import java.util.Arrays;
import java.util.List;

import com.vikhi.pojo.Student;

public class StudentDao {
	
	private AddressDao addressDao;
	private MobileNumberDao mobileNumberDao;
	
	public StudentDao() {
		// TODO: Future plan - Get them injected via DI container
		addressDao = new AddressDao();
		mobileNumberDao = new MobileNumberDao();
	}

	public List<Student> getAllStudents() {
		return Arrays.asList(
				new Student("Kumar", 25, addressDao.getAddressByZipCode("641005"), mobileNumberDao.getMobileNumberByCountry("91")), 
				new Student("Patel", 50, addressDao.getAddressByZipCode("600100"), Arrays.asList(mobileNumberDao.getMobileNumber("91", "9443990380"))), 
				new Student("Singh", 34, addressDao.getAddressByZipCode(""), mobileNumberDao.getMobileNumberByCountry("")));
	}
}
