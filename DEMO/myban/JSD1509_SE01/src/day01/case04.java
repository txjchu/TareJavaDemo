package day01;

import org.junit.Test;

/**
 * ��һ���ַ����м�����һ���ַ���
 * @author Administrator
 *
 */
public class case04 {
	
	/** ����4 */
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
		System.out.println(index);//�������ַ��������ڣ��򷵻�-1
	}
	
	/** ����5 */
	@Test
	public void testSubString(){
		String str = "http://www.oracle.com";
		int beginIndex = str.indexOf('.');//��ȡ�ַ����ַ����е�һ�γ��ֵ�λ��
		int endIndex = str.indexOf('.', beginIndex + 1);//��ȡ�ַ����ַ����дӸ���λ�ÿ�ʼ��һ�γ��ֵ�λ��
		System.out.println(beginIndex +","+ endIndex);//
		String subStr = str.substring(beginIndex + 1, endIndex);//��beginIndex��endIndex��ȣ��������쳣��
		System.out.println(subStr);//oracle
	}
	
	/** ����6 */
	@Test
	public void testTrim(){
		String userName = "  good man  ";
		int length = userName.length();//��ȡ�ַ����ĳ���
		System.out.println(length);//12
		userName = userName.trim();
		length = userName.length();
		System.out.println(length);//8
		System.out.println(userName);//good man
	}
	
	/**  ����7 */
	@Test
	public void testCharAt(){
		String str = "Whatisjava?";
		for(int i = 0; i < str.length(); i ++){
			char c = str.charAt(i);
			System.out.print(c + " ");//W h a t i s j a v a ? 
		}
	}
	
	/** ����8 */
	@Test
	public void testStartWithAndEndWith(){
		System.out.println();
		String str = "Thinking in Java";
		System.out.println(str.startsWith("T"));//true
		System.out.println(str.endsWith("ava"));//true
		System.out.println(str.startsWith("think"));//false
	}
	
	/** ����13 */
	@Test
	public void testDelete(){
		StringBuilder sb = new StringBuilder("javaoraclecppc#php");
		sb.insert(9, "FOX");//�����ַ���������ͷ����β�����Ӹ����±꿪ʼ���룬�����ַ�˳���˺�
		System.out.println(sb);//javaoraclFOXecppc#php
		
		sb.delete(9, 9 + 3);//ɾ���ַ������Ӹ���λ�ÿ�ʼ��������λ�ý�������ͷ����β��
		System.out.println(sb);//javaoraclecppc#php
	}
}







