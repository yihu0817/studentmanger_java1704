package com.wisezone.studentmanager.model;

import java.util.List;
/**
 *  一端拥有多端集合
 *
 * @author zhousir
 * @创建时间 2017年9月12日
 */
public class Grade {
	private int id;  //班级ID
	private String name; //班级名
	private String description; //班级描述
	private List<Student> studentLists; //班级对应用所有学生
	
	public Grade() {
	}
	public Grade(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Grade(int gid,String name, String description) {
		this.id = gid;
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Student> getStudentLists() {
		return studentLists;
	}
	public void setStudentLists(List<Student> studentLists) {
		this.studentLists = studentLists;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Grade [name=" + name + ", description=" + description + ", studentLists=" + studentLists + "]";
	}
	
	
}
