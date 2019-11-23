package com.vikhi.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vikhi.dao.StudentDao;
import com.vikhi.dao.TempStudentDao;
import com.vikhi.exercise.string.StringFunctions;
import com.vikhi.pojo.Student;
import com.vikhi.pojo.TempStudent;

public class StudentService {
	
	private StudentDao studentDao;
	private TempStudentDao tempStudentDao;
	private StringFunctions stringFunctions;
	
	public StudentService() {
		// TODO Inject this via DI container
		studentDao = new StudentDao();
		tempStudentDao = new TempStudentDao(studentDao);
		stringFunctions = new StringFunctions();
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
		return getEldestStudentFromList(getStudentsWithName(name));
	}
	
	public Student getEldestStudentWithZipCode(final String zipCode) {
		return getEldestStudentFromList(getStudentWithZipCode(zipCode));
	}
	
	public List<TempStudent> getTempStudents (final List<Student> students) {
		return students
				.stream()
				.map(TempStudent::new)
				.collect(Collectors.toList());
	}
	
	public List<TempStudent> getAllTempStudents () {
		return tempStudentDao.getAllTempStudents();
	}
	
	public List<String> getStudentNameList(List<Student> students) {
		return students
				.stream()
				.sorted()
				.map(Student::getName)
				.collect(Collectors.toList());
	}
	
	public String getStudentsNameList(List<Student> students) {
		return stringFunctions.getListAsString(getStudentNameList(students));
	}
	
	private Student getEldestStudentFromList(final List<Student> students) {
		Optional<Student> optionalStudent = students
				.stream()
				.sorted(Comparator.comparing(Student::getAge).reversed())
				.findFirst();
		
		return optionalStudent.isPresent() ? optionalStudent.get() : null;
	}
}
