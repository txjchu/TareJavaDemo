package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * �����࣬������������Ӧ�еĲ���ʱ�����ط�������õ�ʵ�����ǹ���������
 * @author Administrator
 *
 */
public class CalendarDemo1 {
	public static void main(String[] arge){
		/*
		 * Ĭ������±�ʾ��ǰϵͳʱ��
		 * ��ǰ���������ϵͳ���ڵ�����ȡ��Ӧ��Calendarʵ���ࡣͨ�����صĶ���
		 * �����������������
		 * GregorianCalendar
		 */
		Calendar calendar=Calendar.getInstance();
		/*
		 * toString()���ص��ַ�������ֱ�۵Ŀ���ʱ�䡣
		 */
		
		System.out.println(calendar);
		
		/*
		 * Calendar-->Date
		 * 
		 * Calendar�ṩ��һ��������
		 * Date getTime()
		 * �÷������Խ����ʾ��������Date��ʽ���ء�
		 */
		Date date=calendar.getTime();
		System.out.println(date);
		
		/*
		 * Date-->Calendar
		 * 
		 * Calendar�ṩ����һ��������
		 * void setTime(Date date)
		 * ʹ��ǰCalendar��ʾ������Date��������ʾ��ʱ�䡣
		 */
		calendar.setTime(date);
		System.out.println(calendar);
		
		
	}
}
