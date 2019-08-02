package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.pojo.Student;
import com.vikhi.pojo.TempStudent;
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
		assertEquals(Long.valueOf(1), Long.valueOf(studentsList.get(0).getId()));
		assertEquals("Kumar", studentsList.get(0).getName());
	}
	
	@Test
	public void getStudentsWithZipCode() {
		List<Student> studentsList = studentService.getStudentWithZipCode("600100");
		assertNotNull(studentsList);
		assertTrue(studentsList.size() == 1);
		assertEquals(Long.valueOf(2), Long.valueOf(studentsList.get(0).getId()));
		assertEquals("Patel", studentsList.get(0).getName());
		assertEquals("600100", studentsList.get(0).getAddress().getZipCode());
	}
	
	@Test
	public void getEldestStudentWithName() {
		Student eldestStudent = studentService.getEldestStudentWithName("Kumar");
		assertNotNull(eldestStudent);
		assertEquals(Long.valueOf(1), Long.valueOf(eldestStudent.getId()));
		assertEquals("Kumar", eldestStudent.getName());
		assertNotNull(eldestStudent.toString());
		
		eldestStudent = studentService.getEldestStudentWithName("Ravi");
		assertNull(eldestStudent);
	}
	
	@Test
	public void getEldestStudentWithZipCode() {
		Student eldestStudent = studentService.getEldestStudentWithZipCode("600100");
		assertNotNull(eldestStudent);
		assertEquals(Long.valueOf(2), Long.valueOf(eldestStudent.getId()));
		assertEquals("Patel", eldestStudent.getName());
	}
	
	@Test
	public void getAllTempStudents() {
		List<TempStudent> tempStudents = studentService.getAllTempStudents();
		assertNotNull(tempStudents);
		assertTrue(tempStudents.size() > 0);
	}
	
	@Test
	public void getTempStudentsFromList() {
		List<TempStudent> tempStudents = studentService.getTempStudents(
				studentService.getStudentsWithName("Kumar"));
		assertNotNull(tempStudents);
		assertTrue(tempStudents.size() > 0);
	}
}
