package day03;

import java.util.Calendar;

/**
 * 为Calendar的不同时间分量设置值
 * @author Administrator
 *
 */
public class CalendarDemo2 {
	public static void main(String[] arge){
		//当前系统时间
		Calendar cal=Calendar.getInstance();
		
		/*
		 * 通过设置不同时间分量，使其表示
		 * 2008-08-08 20:08:08
		 * 
		 * Calendar设置不同时间分量的值的方法
		 * 是统一的：
		 * void set(int field,int value)
		 * 对给定的时间分量设置给定的值
		 */
		//设置年
		cal.set(Calendar.YEAR,2008);
		
		/*
		 * 设置月，月份从0开始，即：0表示1月，1表示2月。
		 * 月份的值也有常量对应。
		 */
		cal.set(Calendar.MONTH,7);
		System.out.println(cal.getTime());
		
		/*
		 * 设置日，日的时间分量：
		 * DAY_OF_YEAR:年中的天
		 * DAY_OF_MONTH:月中的天
		 * DAY_OF_WEEK:周几
		 * DATE:与DAY_OF_MONTH一致	------？
		 * 
		 * 当我们设置某一个时间分量后，可能某些其他的时间分量对应的值也会相应的改变，
		 * 比如设置了不同的月份后，对应的周几就可能改变。
		 */
		cal.set(Calendar.DAY_OF_MONTH, 8);
		
		/*
		 * 设置时
		 */
		cal.set(Calendar.HOUR_OF_DAY,20);
		
		cal.set(Calendar.MINUTE, 8);
		
		cal.set(Calendar.SECOND,8);
		
		/*
		 * 不同的时间分量都有不同的取值范围，不过超过的话会自动进位，例如
		 * calendar.set(Calendar.SECOND,60);
		 * Calendar会向分进位，上面的例子就会变为
		 * 2008-08-08 20:09:00
		 */
		
		System.out.println(cal.getTime());
	}
}
