package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʹ��SimpleDateFormat���ַ���ת��ΪDate
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		String str = "2008��08��08�� 20:08:00";
		/*
		 * String-->Date
		 * 
		 * Date parse(String str)
		 * SimpleDateFormat�ĸ÷������ڽ�
		 * �������ַ������մ���SimpleDateFormat
		 * ʱָ�������ڸ�ʽ����ΪDate����
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy��MM��dd�� HH:mm:ss"	
			);
		
		Date date = sdf.parse(str);
		
		System.out.println(date);
	}
}







