package day03;

import java.util.Calendar;

/**
 * ��ȡĳһ��ʱ���������������ֵ
 * 
 * @author Administrator
 *
 */
public class CalendarDemo04 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//�鿴�����ܹ��ж�����
		int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("�����ܹ��У�"+ days);
	}
}













