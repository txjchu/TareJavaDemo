package day03;

import java.util.Calendar;

/**
 * ΪCalendar�Ĳ�ͬʱ���������ֵ
 * @author Administrator
 *
 */
public class CalendarDemo2 {
	public static void main(String[] arge){
		//��ǰϵͳʱ��
		Calendar cal=Calendar.getInstance();
		
		/*
		 * ͨ�����ò�ͬʱ�������ʹ���ʾ
		 * 2008-08-08 20:08:08
		 * 
		 * Calendar���ò�ͬʱ�������ֵ�ķ���
		 * ��ͳһ�ģ�
		 * void set(int field,int value)
		 * �Ը�����ʱ��������ø�����ֵ
		 */
		//������
		cal.set(Calendar.YEAR,2008);
		
		/*
		 * �����£��·ݴ�0��ʼ������0��ʾ1�£�1��ʾ2�¡�
		 * �·ݵ�ֵҲ�г�����Ӧ��
		 */
		cal.set(Calendar.MONTH,7);
		System.out.println(cal.getTime());
		
		/*
		 * �����գ��յ�ʱ�������
		 * DAY_OF_YEAR:���е���
		 * DAY_OF_MONTH:���е���
		 * DAY_OF_WEEK:�ܼ�
		 * DATE:��DAY_OF_MONTHһ��	------��
		 * 
		 * ����������ĳһ��ʱ������󣬿���ĳЩ������ʱ�������Ӧ��ֵҲ����Ӧ�ĸı䣬
		 * ���������˲�ͬ���·ݺ󣬶�Ӧ���ܼ��Ϳ��ܸı䡣
		 */
		cal.set(Calendar.DAY_OF_MONTH, 8);
		
		/*
		 * ����ʱ
		 */
		cal.set(Calendar.HOUR_OF_DAY,20);
		
		cal.set(Calendar.MINUTE, 8);
		
		cal.set(Calendar.SECOND,8);
		
		/*
		 * ��ͬ��ʱ��������в�ͬ��ȡֵ��Χ�����������Ļ����Զ���λ������
		 * calendar.set(Calendar.SECOND,60);
		 * Calendar����ֽ�λ����������Ӿͻ��Ϊ
		 * 2008-08-08 20:09:00
		 */
		
		System.out.println(cal.getTime());
	}
}
