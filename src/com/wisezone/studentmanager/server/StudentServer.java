package com.wisezone.studentmanager.server;

/**
 * 学生管理上层类
 *
 * @author zhousir
 * @创建时间 2017年8月16日
 */
public interface StudentServer {
	/**
	 * 添加学生
	 */
	public void addStudent();

	/**
	 * 显示学生
	 */
	public void showAllStudent();

	/**
	 * 根据学号删除学生对象
	 * 
	 * @param number
	 */
	public void deleteStudent();

	/**
	 * 查找学生对象
	 * 
	 * @param number
	 * @return
	 */
	public void findStudentByNumber();
}
