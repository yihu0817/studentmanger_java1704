package com.wisezone.studentmanager.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wisezone.studentmanager.dao.StudentDao;
import com.wisezone.studentmanager.model.Student;

public class StudentDaoImplTest {
	StudentDao studentDao;

	@Before
	public void setUp() throws Exception {
		studentDao = new StudentDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindStudentByNumber() {
		Student student = studentDao.findStudentByNumber(5003);
		System.out.println(student);
	}

	@Test
	public void testShowStudentAll() {
		studentDao.showStudentAll();
	}

}
