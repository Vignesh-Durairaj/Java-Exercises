package com.vikhi.dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.vikhi.pojo.Student;
import com.vikhi.pojo.TempStudent;

public class TempStudentDao {

	private StudentDao studentDao;
	
	public TempStudentDao(final StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public List<TempStudent> getAllTempStudents() {
		return getTempStudentsFromList(studentDao.getAllStudents());
	}
	
	private List<TempStudent> getTempStudentsFromList(final List<Student> students) {
		return students
				.stream()
				.filter(Student::isTemp)
				.map(TempStudent::new)
				.sorted(Comparator.comparing(TempStudent::getName))
				.collect(Collectors.toList());
	}
}
