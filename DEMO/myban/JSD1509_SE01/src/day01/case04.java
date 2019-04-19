package day01;

import org.junit.Test;

/**
 * 在一个字符串中检索另一个字符串
 * @author Administrator
 *
 */
public class case04 {
	
	/** 案例4 */
	@Test
	public void testIndexOf(){
		String str = "I can because i think i can";
		int index = str.indexOf("can");
		System.out.println(index);//2
		
		index = str.lastIndexOf("can");
		System.out.println(index);//24
		
		index = str.indexOf("can", 6);
		System.out.println(index);//24
		
		index = str.indexOf("Can");
		System.out.println(index);//检索的字符串不存在，则返回-1
	}
	
	/** 案例5 */
	@Test
	public void testSubString(){
		String str = "http://www.oracle.com";
		int beginIndex = str.indexOf('.');//获取字符在字符串中第一次出现的位置
		int endIndex = str.indexOf('.', beginIndex + 1);//获取字符在字符串中从给定位置开始第一次出现的位置
		System.out.println(beginIndex +","+ endIndex);//
		String subStr = str.substring(beginIndex + 1, endIndex);//若beginIndex与endIndex相等，则会出现异常。
		System.out.println(subStr);//oracle
	}
	
	/** 案例6 */
	@Test
	public void testTrim(){
		String userName = "  good man  ";
		int length = userName.length();//获取字符串的长度
		System.out.println(length);//12
		userName = userName.trim();
		length = userName.length();
		System.out.println(length);//8
		System.out.println(userName);//good man
	}
	
	/**  案例7 */
	@Test
	public void testCharAt(){
		String str = "Whatisjava?";
		for(int i = 0; i < str.length(); i ++){
			char c = str.charAt(i);
			System.out.print(c + " ");//W h a t i s j a v a ? 
		}
	}
	
	/** 案例8 */
	@Test
	public void testStartWithAndEndWith(){
		System.out.println();
		String str = "Thinking in Java";
		System.out.println(str.startsWith("T"));//true
		System.out.println(str.endsWith("ava"));//true
		System.out.println(str.startsWith("think"));//false
	}
	
	/** 案例13 */
	@Test
	public void testDelete(){
		StringBuilder sb = new StringBuilder("javaoraclecppc#php");
		sb.insert(9, "FOX");//插入字符串，（含头不含尾）即从给定下标开始插入，后续字符顺序退后。
		System.out.println(sb);//javaoraclFOXecppc#php
		
		sb.delete(9, 9 + 3);//删除字符串，从给定位置开始，到给定位置结束（含头不含尾）
		System.out.println(sb);//javaoraclecppc#php
	}
}







