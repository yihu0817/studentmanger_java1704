package com.wisezone.studentmanager.action;

import com.wisezone.studentmanager.server.UserServer;
import com.wisezone.studentmanager.server.impl.UserServerImpl;
import com.wisezone.studentmanager.utils.Utils;

public class UserAction {
	/**用户注册*/
	public static final int USER_REGETER = 1;
	/**用户登录*/
	public static final int USER_LOGIN = 2;
	
	private UserServer userServer = new UserServerImpl();
	
	/**
	 * 启动用户管理
	 */
	public void startUserManger() {
		System.out.println("==========进入用户管理==============");
		while (true) {
			System.out.println("<请输入命令  1. 用户注册    2. 用户登录>");
			int common =  Utils.readInt();
			switch (common) {
			case USER_REGETER:	
				userServer.register();
				break;
			case USER_LOGIN:
				userServer.login();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		UserAction userAction = new UserAction();
		userAction.startUserManger();
	}
}
