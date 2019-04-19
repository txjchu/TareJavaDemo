package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * ������Ը���һ��������[���ڸ�ʽ�ַ���]��Date��String���ཻ����
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo01 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);//Fri Jun 02 00:11:48 CST 2017
		
		/*
		 * 2015-10-28 10:52:44
		 * yyyy-MM-dd HH:mm:ss	 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * String format(Date date)
		 * �����������ڰ���SimpleDateFormat����ʱָ�������ڸ�ʽ����ת��Ϊ�ַ�����
		 * Date-->String 
		 */
		String str = sdf.format(date);
		System.out.println(str);//2017-06-02 00:11:48
		
	}
}	


















