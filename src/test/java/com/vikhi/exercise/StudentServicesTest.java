package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.pojo.Student;
import com.vikhi.service.StudentService;

public class StudentServicesTest {
	
	private StudentService studentService;
	
	@Before
	public void init() {
		studentService = new StudentService();
	}

	@Test
	public void getStudentsWithName() {
		List<Student> studentsList = studentService.getStudentsWithName("Kumar");
		assertNotNull(studentsList);
		assertTrue(studentsList.size() == 1);
		assertEquals(Long.valueOf(studentsList.get(0).getId()), Long.valueOf(1));
	}
	
	@Test
	public void getStudentsWithZipCode() {
		List<Student> studentsList = studentService.getStudentWithZipCode("600100");
		assertNotNull(studentsList);
		assertTrue(studentsList.size() == 1);
		assertEquals(Long.valueOf(studentsList.get(0).getId()), Long.valueOf(2));
		assertEquals(studentsList.get(0).getName(), "Patel");
	}
}
