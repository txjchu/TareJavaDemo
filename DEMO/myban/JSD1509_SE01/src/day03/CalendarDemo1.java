package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 抽象类，定义了日历类应有的操作时间的相关方法。最常用的实现类是公历立法；
 * @author Administrator
 *
 */
public class CalendarDemo1 {
	public static void main(String[] arge){
		/*
		 * 默认情况下表示当前系统时间
		 * 当前方法会根据系统所在地区获取对应的Calendar实现类。通常返回的都是
		 * 公历：格里高利历法
		 * GregorianCalendar
		 */
		Calendar calendar=Calendar.getInstance();
		/*
		 * toString()返回的字符串不能直观的看出时间。
		 */
		
		System.out.println(calendar);
		
		/*
		 * Calendar-->Date
		 * 
		 * Calendar提供了一个方法：
		 * Date getTime()
		 * 该方法可以将其表示的日期以Date形式返回。
		 */
		Date date=calendar.getTime();
		System.out.println(date);
		
		/*
		 * Date-->Calendar
		 * 
		 * Calendar提供了另一个方法：
		 * void setTime(Date date)
		 * 使当前Calendar表示给定的Date对象所表示的时间。
		 */
		calendar.setTime(date);
		System.out.println(calendar);
		
		
	}
}
