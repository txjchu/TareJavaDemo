package day02;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author Administrator
 *
 */
public class case01 {
	public static void main(String[] args) {
		/*
		 * case01	�����ַ��֤
		 *  public boolean matches(regex) 
		 */
		String mail = "bjliyi@tarena.com.cn";
		String mailRegex = "^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]{2,}$";
		System.out.println(mail.matches(mailRegex));//true
	}
	
	/*
	 * case02	spilt()��������ַ���
	 */
	@Test
	public void testSpilt(){
		String str = "java cpp php c# objective-c";
		String[] strArr = str.split("\\s");
		System.out.println(Arrays.toString(strArr));//[java, cpp, php, c#, objective-c]
		
		String line = "100+200-150=150";
		strArr = line.split("[\\+\\-\\=]");
		System.out.println(Arrays.toString(strArr));//[100, 200, 150, 150]
	}
	
	/*
	 * case 06 	����xxxValue()����
	 */
	@Test
	public void testXXXValue(){
		Number d = 123.45;
		Number n = 123;
		//���d,n����������
		System.out.println(d.getClass().toString());//class java.lang.Double
		System.out.println(d.getClass().getName());//java.lang.Double
		System.out.println(n.getClass().getName());//java.lang.Integer
		
		int intValue = d.intValue();
		double doubleValue = d.doubleValue();
		System.out.println(intValue +","+ doubleValue);//123,123.45
		
		intValue = n.intValue();
		doubleValue = n.doubleValue();
		System.out.println(intValue +","+ doubleValue);//123,123.0
	}
	
	/*
	 * case07 	����Integer parseInt()����
	 */
	@Test
	public void testParseInt(){
		String str = "123";
		
		int intValue = Integer.parseInt(str);
		System.out.println(intValue);//123
		
		str = "Ҽ��������";
		
		int value = Integer.parseInt(str);//�쳣��NumberFormatException
		System.out.println(value);
	}
	
	/*
	 * case08 ����double parseDouble(String str)����
	 * 
	 */
	@Test
	public void testParseDouble(){
		String str = "12345.00";
		double value = Double.parseDouble(str);
		System.out.println(value);//12345.0
		
		str = "��12345.00";
		value = Double.parseDouble(str);//�쳣��NumberFormatException
		System.out.println(value);
	}
}









