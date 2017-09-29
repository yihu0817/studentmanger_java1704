package com.wisezone.studentmanager.dao;

import com.wisezone.studentmanager.model.User;

public interface UserDao {
	/**
	 * 添加一条用户记录
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 根据用户名和密码从数据库查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	User getUser(String username,String password);
	/**
	 * 检查用户是否存在
	 * @param username
	 * @return
	 */
	boolean checkUser(String username);
}
