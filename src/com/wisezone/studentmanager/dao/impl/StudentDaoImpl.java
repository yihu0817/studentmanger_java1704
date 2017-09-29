package com.wisezone.studentmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wisezone.studentmanager.dao.StudentDao;
import com.wisezone.studentmanager.model.Student;
import com.wisezone.studentmanager.utils.DBConnection;


public class StudentDaoImpl extends DBConnection implements StudentDao {

	// 添加学生到数据库
	@Override
	public void addStudent(Student student) {
		String sql = "INSERT INTO student (gid,snumber,sname,datetime)VALUES(?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student.getGrade().getId());
			ps.setInt(2, student.getNumber());
			ps.setString(3, student.getName());
			ps.setTimestamp(4, student.getDateTime());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(ps, conn);
		}
	}

	@Override
	public void deleteStudent(Student student) {
		String sql = "DELETE FROM student WHERE snumber=?";
		Connection connection = getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, student.getNumber());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(ps, connection);
		}

	}

	@Override
	public Student findStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE snumber=?";
		Student student = null;
		Connection conn = getConnection();
		QueryRunner runner = new QueryRunner();
		try {
			Map<String, String> paramterMap = new HashMap<>();
			paramterMap.put("sname", "name");
			paramterMap.put("snumber", "number");
			paramterMap.put("datetime", "dateTime");

			student = runner.query(conn, sql,
					new BeanHandler<Student>(Student.class, new BasicRowProcessor(new BeanProcessor(paramterMap))),
					number);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return student;
	}

	@Override
	public void showStudentAll() {
		String sql = "SELECT * FROM student";
		Connection conn = getConnection();
		QueryRunner runner = new QueryRunner();
		try {
			Map<String, String> paramterMap = new HashMap<>();
			paramterMap.put("sname", "name");
			paramterMap.put("snumber", "number");
			paramterMap.put("datetime", "dateTime");
			
			List<Student> studentLists  = runner.query(conn, sql,
					new BeanListHandler<Student>(Student.class, new BasicRowProcessor(new BeanProcessor(paramterMap))));
			for(Student student :studentLists){
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}

	}

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();

		// Grade grade = new Grade(1,"java班","");
		// Student obj = new Student(grade,"test", 11, new
		// Timestamp(System.currentTimeMillis()));
		// studentDao.addStudent(obj);

		 studentDao.showStudentAll();

//		Student student = studentDao.findStudentByNumber(1001);
//		System.out.println(student);

		// studentDao.deleteStudent(obj);
	}
}
