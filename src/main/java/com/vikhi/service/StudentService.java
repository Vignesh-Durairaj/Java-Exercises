package com.vikhi.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vikhi.dao.StudentDao;
import com.vikhi.pojo.Student;

public class StudentService {
	
	private StudentDao studentDao;
	
	public StudentService() {
		// TODO Inject this via DI container
		studentDao = new StudentDao();
	}

	public List<Student> getStudentsWithName(final String name) {
		return studentDao.getAllStudents()
				.stream()
				.filter(student -> name.equals(student.getName()))
				.collect(Collectors.toList());
	}
	
	public List<Student> getStudentWithZipCode(final String zipCode) {
		return studentDao.getAllStudents()
				.stream()
				.filter(stud -> zipCode.equalsIgnoreCase(stud.getAddress().getZipCode()))
				.collect(Collectors.toList());
	}
	
	public Student getEldestStudentWithName(final String name) {
		Optional<Student> optionalStudent = getStudentsWithName(name)
				.stream()
				.sorted(Comparator.comparing(Student::getAge).reversed())
				.findFirst();
		
		return optionalStudent.isPresent() ? optionalStudent.get() : null;
	}
}
