package com.wisezone.studentmanager.server.impl;

import com.wisezone.studentmanager.action.StudentAction;
import com.wisezone.studentmanager.dao.UserDao;
import com.wisezone.studentmanager.dao.impl.UserDaoImpl;
import com.wisezone.studentmanager.model.User;
import com.wisezone.studentmanager.server.UserServer;
import com.wisezone.studentmanager.utils.Utils;

public class UserServerImpl implements UserServer {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void register() {
		System.out.println("请输入用户名:");
		String userName = Utils.readString();
		System.out.println("请输入密码:");
		String passWord = Utils.readString();

		// 检查用户是否已经注册
		boolean isCheck = userDao.checkUser(userName);
		if (isCheck) {
			System.out.println("用户已经注册!");
			return;
		}
		// 注册新用户
		User user = new User(userName, passWord);
		userDao.addUser(user);
		System.out.println("注册成功！");
	}

	@Override
	public void login() {
		System.out.println("请输入用户名:");
		String userName = Utils.readString();
		System.out.println("请输入密码:");
		String passWord = Utils.readString();

		User user = userDao.getUser(userName, passWord);
		if (user == null) {
			System.out.println("用户名或密码出错!");
			return;
		}
		System.out.println("登录成功!");
		// 进入学生管理
		StudentAction studentAction = new StudentAction();
		studentAction.startStudentManger();
	}

}
