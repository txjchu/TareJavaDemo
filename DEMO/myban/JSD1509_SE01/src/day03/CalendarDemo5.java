package day03;

import java.util.Calendar;

/**
 * Calendar提供了一个可以计算时间的方法：
 * void add(int field,int value)
 * 对给定的时间分量累加给定的值
 * @author Administrator
 *
 */
public class CalendarDemo5 {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		
		/*
		 * 查看3个月零28天以后是哪天？
		 */
		//加上3个月
		calendar.add(Calendar.MONTH, 3);
		System.out.println(calendar.getTime());
		
		//加上28天
		calendar.add(Calendar.DAY_OF_YEAR, 28);
		System.out.println(calendar.getTime());
		
		//减去3年
		calendar.add(Calendar.YEAR, -3);//-----
		System.out.println(calendar.getTime());
		
	}
}
