package com.wisezone.studentmanager.server.impl;

import java.sql.Timestamp;
import java.util.List;

import com.wisezone.studentmanager.dao.GradeDao;
import com.wisezone.studentmanager.dao.StudentDao;
import com.wisezone.studentmanager.dao.impl.GradeDaoImpl;
import com.wisezone.studentmanager.dao.impl.StudentDaoImpl;
import com.wisezone.studentmanager.model.Grade;
import com.wisezone.studentmanager.model.Student;
import com.wisezone.studentmanager.server.StudentServer;
import com.wisezone.studentmanager.utils.Utils;

/**
 * 学生管理业务层类
 *
 * @author zhousir
 * @创建时间 2017年8月16日
 */
public class StudentServerImpl implements StudentServer {
	private StudentDao studentDao = new StudentDaoImpl();
	private GradeDao gradeDao = new GradeDaoImpl();

	/**
	 * 添加学生
	 */
	public void addStudent() {
		System.out.println("请输入姓名:");
		String name = Utils.readString();
		System.out.println("请输入学号");
		int number = Utils.readInt();
		System.out.println("请选择班级号：" + getGrades());
		int gradeId = Utils.readInt();

		Grade grade = gradeDao.getGradeByID(gradeId);
		Student student = new Student(grade, name, number, new Timestamp(System.currentTimeMillis()));

		if (studentDao.findStudentByNumber(number) != null) {
			System.out.println("添加的学生已存在，不允许有重名学生,请重新输入!");
			return;
		}

		studentDao.addStudent(student);
		System.out.println("添加学生" + name + "成功!");
	}

	/**
	 * "1 java班,2 ui 班,3 Android"
	 * 
	 * @return
	 */
	public String getGrades() {
		List<Grade> gradeLists = gradeDao.getAllGrade();
		if(gradeLists.size() == 0){
			return "没有班级";
		}
		StringBuilder sb = new StringBuilder();
		for (Grade grade : gradeLists) {
			sb.append(grade.getId());
			sb.append(" ");
			sb.append(grade.getName());
			sb.append(",");
		}
		String gradeStr = sb.toString();
		String str = gradeStr.substring(0, gradeStr.length() - 1);
		return str;
	}

	/**
	 * 显示学生
	 */
	public void showAllStudent() {
		studentDao.showStudentAll();
	}

	/**
	 * 根据学号删除学生对象
	 * 
	 * @param number
	 */
	public void deleteStudent() {
		System.out.println("请输入删除学生学号");
		int number = Utils.readInt();

		Student student = studentDao.findStudentByNumber(number);
		if (student == null) {
			System.out.println("学生不存在！");
			return;
		}
		studentDao.deleteStudent(student);
		System.out.println("删除学生成功!");
	}

	/**
	 * 查找学生对象
	 * 
	 * @param number
	 * @return
	 */
	public void findStudentByNumber() {
		System.out.println("请输入查找学生学号");
		int number = Utils.readInt();

		Student student = studentDao.findStudentByNumber(number);

		if (student == null) {
			System.out.println("学号为" + number + "的学生不存在!");
			return;
		}
		System.out.println(student);
	}

	public static void main(String[] args) {
		StudentServer studentServer = new StudentServerImpl();
//		studentServer.addStudent();

		// studentServer.findStudentByNumber();
		
//		studentServer.deleteStudent();
		studentServer.showAllStudent();
	}
}
