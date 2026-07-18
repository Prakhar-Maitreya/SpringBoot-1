package com.prakhar.demo;

import com.prakhar.demo.StudentServer.Entity.Student;
import com.prakhar.demo.StudentServer.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private StudentService studentService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateStudentSuccess() {
		Student student = new Student();
		student.setId(101);
		student.setName("Alice");
		student.setAge(20);
		student.setDepartment("Computer Science");

		Student saved = studentService.studentValidate(student);
		assertNotNull(saved);
		assertEquals(101, saved.getId());
		assertEquals("Alice", saved.getName());
	}

}
