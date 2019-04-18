package day03;

import java.util.Calendar;

/**
 * 获取某一个时间分量所允许的最大值
 * 参照时间为Calendar当前表示的时间。
 * 例如:
 * Calendar现在表示8月，那么获取月中的天所允许的最大值
 * 时就是看8月总共多少天。
 * @author Administrator
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		
		//查看今年总共多少天?
		int days = calendar.getActualMaximum(
			Calendar.DAY_OF_YEAR
		);
		System.out.println("今年总共:"+days+"天");
		
		
	}
}




