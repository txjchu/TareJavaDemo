package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʹ��SimpleDateFormat���ַ���ת��ΪDate			format:ʹ��ʽ����n.��ʽ���汾
 * Date parse(String source)����
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo02 {
	public static void main(String[] args) throws ParseException {
		String str = "2008��08��08��  20:08:00";
		/*
		 * String --> Date
		 * Date parse(String str)����
		 * SimpleDateFormat�ĸ÷������ڽ��������ַ������մ���SimpleDateFormatʱ���������ڸ�ʽ����ΪDate���� 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");//:����ʹ������״̬�µ�ð�š�
		Date date = sdf.parse(str);
		System.out.println(date);//Fri Aug 08 20:08:00 CST 2008
	}
}










