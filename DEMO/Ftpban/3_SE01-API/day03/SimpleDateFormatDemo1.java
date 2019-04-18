package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * ������Ը���һ��������[���ڸ�ʽ�ַ���]��Date
 * ��String�໥ת���� 
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo1 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		/*
		 * 2015-10-28 10:52:33
		 * yyyy-MM-dd HH:mm:ss
		 */
		
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
		/*
		 * String format(Date date)
		 * �����������ڰ���SimpleDateFormat����
		 * ʱָ�������ڸ�ʽ����ת��Ϊ�ַ���
		 * Date-->String
		 */
		String str = sdf.format(date);
		
		System.out.println(str);
	}
}







