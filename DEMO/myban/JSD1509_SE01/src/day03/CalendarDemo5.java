package day03;

import java.util.Calendar;

/**
 * Calendar�ṩ��һ�����Լ���ʱ��ķ�����
 * void add(int field,int value)
 * �Ը�����ʱ������ۼӸ�����ֵ
 * @author Administrator
 *
 */
public class CalendarDemo5 {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		
		/*
		 * �鿴3������28���Ժ������죿
		 */
		//����3����
		calendar.add(Calendar.MONTH, 3);
		System.out.println(calendar.getTime());
		
		//����28��
		calendar.add(Calendar.DAY_OF_YEAR, 28);
		System.out.println(calendar.getTime());
		
		//��ȥ3��
		calendar.add(Calendar.YEAR, -3);//-----
		System.out.println(calendar.getTime());
		
	}
}
