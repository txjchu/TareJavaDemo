package day03;

import java.util.Calendar;

/**
 * ��ȡĳһ��ʱ���������������ֵ
 * ����ʱ��ΪCalendar��ǰ��ʾ��ʱ�䡣
 * ����:
 * Calendar���ڱ�ʾ8�£���ô��ȡ���е�������������ֵ
 * ʱ���ǿ�8���ܹ������졣
 * @author Administrator
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		
		//�鿴�����ܹ�������?
		int days = calendar.getActualMaximum(
			Calendar.DAY_OF_YEAR
		);
		System.out.println("�����ܹ�:"+days+"��");
		
		
	}
}




