package com.wisezone.studentmanager.model;
/**
 * 用户实体
 *
 * @author zhousir
 * @创建时间 2017年9月5日
 */
public class User {
	private String userName; //用户名
	private String passWord; //密码
	public User() {
	}
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
}
