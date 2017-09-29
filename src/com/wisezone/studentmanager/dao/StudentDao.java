package com.wisezone.studentmanager.dao;

import com.wisezone.studentmanager.model.Student;

public interface StudentDao {
	void addStudent(Student student);//添加学生
	
	void deleteStudent(Student student);//删除学生
	
	Student findStudentByNumber(int number);//根据学号查找学生
	
	void showStudentAll();//显示所有学生
	
}
