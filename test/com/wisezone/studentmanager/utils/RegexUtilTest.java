package com.wisezone.studentmanager.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RegexUtilTest {

	@Test
	public void testMatch() {
		String content = "abdc123rtryt432asf456sdf";
		String regex = "\\d+";
		boolean mathchFalg = RegexUtil.match(content, regex);
		assertTrue(mathchFalg);
	}
	
	@Test
	public void testMultiExtract(){
		String content = "2017-09-29 2018-07-30";
		String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
		List<String> lists =  RegexUtil.multiExtract(content, regex, 2);
		assertNotNull(lists);
		for(String item:lists){
			System.out.println(item);
		}
	}
	
	@Test
	public void testMultiGroupExtract(){
		String content = "2017-09-29";
		String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
		List<String> lists =  RegexUtil.multiGroupExtract(content, regex);
		
		for(String item:lists){
			System.out.println(item);
		}
	}
	
	

}
