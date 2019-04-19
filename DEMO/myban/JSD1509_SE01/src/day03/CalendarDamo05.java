package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar提供了一个可以计算时间分量的方法
 * void add(int field, int amount)
 * @author Administrator
 *
 */
public class CalendarDamo05 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		/*
		 * 查看3个月零28天以后是哪一天
		 */
		//加3个月
		cal.add(Calendar.MONTH, 3);
		//再加28天
		cal.add(Calendar.DAY_OF_YEAR, 28);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		String str = sdf.format(date);
		System.out.println(str);
		
		//减3年
		cal.add(Calendar.YEAR, -3);
		System.out.println(cal.getTime());
	}
}















