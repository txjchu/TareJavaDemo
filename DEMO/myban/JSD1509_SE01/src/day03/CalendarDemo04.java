package day03;

import java.util.Calendar;

/**
 * 获取某一个时间分量所允许的最大值
 * 
 * @author Administrator
 *
 */
public class CalendarDemo04 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//查看今年总共有多少天
		int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("今年总共有："+ days);
	}
}













