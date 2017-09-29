package com.wisezone.studentmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 加载数据库驱动管理连接
 *
 * @author zhousir
 * @创建时间 2017年9月5日
 */
public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/studentdb";
	private static final String user = "root";
	private static final String password = "123";

	/**
	 * 加载数据库驱动
	 */
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立数据库连接
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public void closeConnection(PreparedStatement ps, Connection conn) {
		closeConnection(null, ps, conn);
	}
	public void closeConnection( Connection conn) {
		closeConnection(null, null, conn);
	}
	/**
	 * 关闭数据库连接
	 * 
	 * @param connection
	 */
	public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
