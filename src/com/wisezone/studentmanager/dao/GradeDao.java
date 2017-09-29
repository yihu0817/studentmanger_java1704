package com.wisezone.studentmanager.dao;

import java.util.List;

import com.wisezone.studentmanager.model.Grade;

public interface GradeDao {
	void addGrade(Grade grade); //添加班级
	void deleteGrade(Grade grade);//删除班级
	Grade getGrade(String name); //根据班级名获取班级对象
	Grade getGradeByID(int id); //根据ID班级对象
	List<Grade> getAllGrade(); //获取所有班级
}
