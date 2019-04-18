package homework03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ��ҵ1
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) throws ParseException {
		/*
		 * ����:
		 * 1:����Scanner
		 * 2:��ȡ�û��������������
		 * 3:��ȡ�û�����ı���������
		 * 4:����SimpleDateFormat���ڽ�
		 *   �������ڵ��ַ���ת��ΪDate
		 * 5:����Calendar�����ұ�ʾΪDate��ʾ��
		 *   ��������
		 * 6:���������,�������ڼ��ϱ����ڵ�����
		 * 7:�ӹ����ռ�ȥ14�죨����ǰ��
		 * 8:����Ϊ���ܵ���������
		 * 9:��Calendarת����Date
		 * 10:��Dateת��ΪStringȻ�����    
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println(
			"��������������(yyyy-MM-dd):");
		
		String dateStr = scanner.nextLine();
		
		System.out.println("�����뱣����(����):");
		int days = Integer.parseInt(
			scanner.nextLine()
		);
		
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd"
		);
		
		Date date = sdf.parse(dateStr);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		//���������
		calendar.add(Calendar.DAY_OF_YEAR, days);
		
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		
		date = calendar.getTime();
		
		dateStr = sdf.format(date);
		
		System.out.println("������Ϊ:"+dateStr);
		
		
		
		
		
	}
}







