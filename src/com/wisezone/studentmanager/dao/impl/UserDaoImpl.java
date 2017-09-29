package com.wisezone.studentmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wisezone.studentmanager.dao.UserDao;
import com.wisezone.studentmanager.model.User;
import com.wisezone.studentmanager.utils.DBConnection;

public class UserDaoImpl extends DBConnection implements  UserDao {

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO user (username,password)VALUES (?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(ps, conn);
		}
	}

	@Override
	public User getUser(String username, String password) {
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				user = new User(userName,passWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(ps, conn);
		}
		
		return user;
	}
	/**
	 * 查检用户是否存在
	 */
	@Override
	public boolean checkUser(String username) {
		String sql = "SELECT * FROM user WHERE username=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isCheck = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				isCheck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(ps, conn);
		}
		
		return isCheck;
	}

}
