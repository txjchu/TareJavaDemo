package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar�ṩ��һ�����Լ���ʱ������ķ���
 * void add(int field, int amount)
 * @author Administrator
 *
 */
public class CalendarDamo05 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		/*
		 * �鿴3������28���Ժ�����һ��
		 */
		//��3����
		cal.add(Calendar.MONTH, 3);
		//�ټ�28��
		cal.add(Calendar.DAY_OF_YEAR, 28);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		String str = sdf.format(date);
		System.out.println(str);
		
		//��3��
		cal.add(Calendar.YEAR, -3);
		System.out.println(cal.getTime());
	}
}















