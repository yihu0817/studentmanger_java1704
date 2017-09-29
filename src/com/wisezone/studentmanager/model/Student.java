package com.wisezone.studentmanager.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * 学生类   grade   -   student
 * 表结构 一对多
 *    一端主键作为多端外键
 * 
 * 类结构
 *   多端拥有一端实例
 *   一端拥有多端集合
 * 
 */
public class Student{
	private int number;  //学号
	private String name; //姓名
	private Timestamp dateTime; //入学时间
	private Grade grade; //班级
	
	public Student() {
		super();
	}

	public Student(String name, int number, Timestamp dateTime) {
		this.name = name;
		this.number = number;
		this.dateTime = dateTime;
	}

	public Student(Grade grade,String name, int number, Timestamp dateTime) {
		this.grade = grade;
		this.name = name;
		this.number = number;
		this.dateTime = dateTime;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(this.getDateTime());
		return this.getName() + "\t" + this.getNumber() + "\t" + date;
	}
	
}
