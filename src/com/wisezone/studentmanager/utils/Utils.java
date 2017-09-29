package com.wisezone.studentmanager.utils;

import java.util.Scanner;
/**
 * 
 * 
 *
 * @author zhousir
 * @创建时间 2017年8月15日
 */
public class Utils {
	public static Scanner scanner = new Scanner(System.in); // 成员变量初始化是在StudenManger对象实例化时

	public static void main(String[] args) {
		System.out.println("请输入数字：");
		int str = Utils.readInt();
		System.out.println(str);
	}
	
	/**
	 * 从键盘读取整数
	 */
	public static int readInt() {
		int number = 1;
		boolean isFlag = true;
		while (isFlag) {
			try {
				String s = scanner.next();
				number = Integer.parseInt(s);
				break;
			} catch (NumberFormatException e) {
				System.out.println("请输入正确数字:");
			} 
		}
		
		return number;
	}
	
	/**
	 * 从键盘读字符串
	 * @return
	 */
	public static String readString() {
		String str = "";
		boolean isFlag = true;
		while (isFlag) {
			try {
				str = scanner.next();
				
//				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//				str = br.readLine();
				break;
			} catch (NumberFormatException e) {
				System.out.println("请输入正确数字:");
			} 
		}
		
		return str;

	}
}
