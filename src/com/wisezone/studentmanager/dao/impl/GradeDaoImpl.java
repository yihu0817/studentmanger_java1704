package com.wisezone.studentmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wisezone.studentmanager.dao.GradeDao;
import com.wisezone.studentmanager.model.Grade;
import com.wisezone.studentmanager.utils.DBConnection;

public class GradeDaoImpl extends DBConnection implements GradeDao {

	@Override
	public Grade getGrade(String name) {
		String sql = "SELECT * FROM grade WHERE gname=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Grade grade = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				String gname = rs.getString("gname");
				String descrip = rs.getString("description");
				grade = new Grade(gname,descrip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}
	
	@Override
	public Grade getGradeByID(int id) {
		String sql = "SELECT * FROM grade WHERE gid=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Grade grade = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				int gid = rs.getInt("gid");
				String gname = rs.getString("gname");
				String descrip = rs.getString("description");
				grade = new Grade(gid,gname,descrip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}

	@Override
	public List<Grade> getAllGrade() {
		String sql = "SELECT * FROM grade";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> gradeLists = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int gid = rs.getInt("gid");
				String gname = rs.getString("gname");
				String descrip = rs.getString("description");
				Grade grade = new Grade(gid,gname,descrip);
				gradeLists.add(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gradeLists;
	}

	@Override
	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGrade(Grade grade) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		GradeDao gradeDao = new GradeDaoImpl();
//		Grade grade = gradeDao.getGrade("java班");
		List<Grade> lists = gradeDao.getAllGrade();
		System.out.println(lists);
	}


}
