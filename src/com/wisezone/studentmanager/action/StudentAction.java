package com.wisezone.studentmanager.action;

import com.wisezone.studentmanager.server.StudentServer;
import com.wisezone.studentmanager.server.impl.StudentServerImpl;
import com.wisezone.studentmanager.utils.Utils;

/**
 * 
 * 控制层
 *
 * @author zhousir
 * @创建时间 2017年9月5日
 */
public class StudentAction {
	private StudentServer studentServer = new StudentServerImpl();

	/**
	 * 启动学生管理系统
	 */
	public void startStudentManger() {
		System.out.println("=====  欢迎进入《学生信息管理系统》！ ======");
		System.out.println("1 添加学生,2 显示学生列表,3 删除学生,4 查找学生,5 退出");

		// 解压学生压缩文件
		while (true) {
			System.out.println("<输 入操作命令:>");
			int common = Utils.readInt();
			switch (common) {
			case 1:
				studentServer.addStudent();
				break;
			case 2:
				studentServer.showAllStudent();
				break;
			case 3:
				studentServer.deleteStudent();
				break;
			case 4:
				studentServer.findStudentByNumber();
				break;
			case 5:
				exit();
				break;
			}
		}
	}

	/**
	 * 退出
	 */
	public void exit() {
		// 压缩所有学生文件，删除所有学生文件
		System.out.println("退出学生管理系统成功!");
		System.exit(0);
	}

	public static void main(String[] args) {
		StudentAction studentAction = new StudentAction();
		studentAction.startStudentManger();
	}

}
