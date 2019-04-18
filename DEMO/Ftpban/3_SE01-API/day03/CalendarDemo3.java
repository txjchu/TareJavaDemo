package day03;

import java.util.Calendar;

/**
 * 获取一个Calendar时间分量对应的值
 * @author Administrator
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		
		/*
		 * int get(int field)
		 * 获取给定时间分量所对应的值
		 */
		//获取年
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		
		System.out.println(
			year+"-"+month+"-"+day
		);
		
		//获取时分秒
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		
		System.out.println(
			hour+":"+minute+":"+sec
		);
		
		//获取星期几
		/*
		 * 星期中，1表示周日，2表示周一。
		 */
		int dow = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(
			"周"+(dow==1?7:dow-1)
		);
		
		//查看今天是今年的第几天？
		int days = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(
			"今天是今年的第"+days+"天"
		);
		
		
	}
}




