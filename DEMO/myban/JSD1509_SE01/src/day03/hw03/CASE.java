package day03.hw03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/** 案例练习 */
public class CASE {
	
	//案例1
	@Test
	public void testGetTime(){
		Date date = new Date();
		System.out.println(date);//Sat Jun 03 23:43:55 CST 2017
		
		long time = date.getTime();
		System.out.println(time);
	}
	@Test 
	public void testSetTime(){
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		time += 1000 * 60 * 60 * 24;
		date.setTime(time);
		System.out.println(date);
	}
	
	//案例2
	@Test
	public void testFormat(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String str = sdf.format(date);
		System.out.println(str);
	}
	
	//案例3
	@Test
	public void testParse() throws ParseException{
		String str = "2017-06-03 11-51-26";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = sdf.parse(str);
		System.out.println(date);
	}
	
	//案例4
	@Test
	public void testGetInstance(){
		//创建
		Calendar cal = Calendar.getInstance();//日历类
		System.out.println(cal.getClass().getName());//java.util.GregorianCalendar默认创建公历格里高利历法
		//转换为Date
		Date date = cal.getTime();//将日历类对象转换为日期类
		System.out.println(date);
		//设置为2008-08-08
		cal.set(Calendar.YEAR, 2008);
		cal.set(Calendar.MONTH, Calendar.AUGUST);//August = 7,月份是从0开始的
		cal.set(Calendar.DAY_OF_MONTH, 8);//设置一个月中的几号
//		cal.set(Calendar.DATE, 8);//同上一个方法
		date = cal.getTime();
		System.out.println(date);
		
		GregorianCalendar gc = new GregorianCalendar(2008,Calendar.AUGUST,8);
		gc.set(Calendar.MINUTE, 41);//设置分钟数
		date = gc.getTime();
		System.out.println(date);
		
		//案例5
		date = new Date();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 22);
		cal.set(Calendar.DATE, 32);//6月32日，即7月2日
		date = cal.getTime();
		System.out.println(date);
		
		//案例6  获取时间分量 int get(int field);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("本周中的第"+ dayOfWeek +"天（周日为第一天）。");
		
		//案例7
		Calendar cal7 = Calendar.getInstance();
		cal7.set(Calendar.YEAR, 2008);//闰年
		cal7.set(Calendar.DAY_OF_MONTH, 1);//设置为当月1号
		for(int i = 0; i < 12; i ++){//月份是从0开始，即1月的int值为0
			cal7.set(Calendar.MONTH, i);
			int daysOfMonth = cal7.getActualMaximum(Calendar.DATE);
			System.out.println(i+1 +"月份有"+ daysOfMonth +"天");
		}
		
		//案例8
		date = cal7.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		System.out.println(str);
		cal7.add(Calendar.YEAR, 1);//增加1年
		cal7.add(Calendar.MONTH, -3);//减去3个月
		date = cal7.getTime();
		str = sdf.format(date);
		System.out.println(str);
		
	}
}











