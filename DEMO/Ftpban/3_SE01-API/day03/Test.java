package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Ҫ���û������Լ�������:1992-10-21
 * �����������:������Ϊֹ��������xxxx��
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scanner 
			= new Scanner(System.in);
		
		System.out.println("��������������:");
		String birthStr = scanner.nextLine();
		
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd"	
			);
		Date birth = sdf.parse(birthStr);
		
		Date now = new Date();
		
		long time = now.getTime()-birth.getTime();
		
		long days = time/1000/60/60/24;
		
		System.out.println(
			"��ϲ�����Ѿ�����"+days+"�죬���������!"
		);
		
	}
}




