package day03.hw03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/** 作业一：计算商品促销日期（保质期结束日前的第14天所在周的周三）。 */
public class testDiscountDate {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);//创建扫描器对象
		System.out.println("请输入商品的生产日期（yyyy-MM-dd）：");
		String dateStr = sc.nextLine();//接收用户输入的日期，以字符串类型保存
		System.out.println("请输入商品的保质期（天数）：");
		int days = sc.nextInt();//接收用户输入的数字
		sc.close();//关闭扫描器
		
		//将字符串转为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//将Date类型转换为Calendar类型对象，用于时间分量的操作
		Calendar cal = Calendar.getInstance();//获取实例
		cal.setTime(date);
		//计算过期日前的第14天所在周的周三
		cal.add(Calendar.DAY_OF_YEAR, days);//计算过期日
		cal.add(Calendar.DAY_OF_YEAR, -14);//过期日前第14日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//设置为当日所在周的周三
		//输出
		date = cal.getTime();//获取最终日期
		String str = sdf.format(date);//转变为字符串
		System.out.println("促销日为："+ str);
		
		
		
		
		
		
	/**	
		//将生产日期字符串转变为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//将Date类型数据转换为Calendar类型用于操作时间分量
		Calendar cal = Calendar.getInstance();//获取实例
		cal.setTime(date);//设置为date表示的时间
		//计算过期日前的第14天所在周的周三
		cal.add(Calendar.DAY_OF_YEAR, days);//计算过期日
		cal.add(Calendar.DAY_OF_YEAR, -14);//过期日前的第14日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//设置为当日所在周的周三
		//输出
		date = cal.getTime();//将日历类对象转换为Date类型
		String str = sdf.format(date);//转换为字符串
		System.out.println("促销日为："+ str);
	*/
		
	/**
		//将生产日期字符串转变为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//将Date类型数据转换为Calendar类型用于操作时间分量
		Calendar cal = Calendar.getInstance();//获取实例
		cal.setTime(date);//将日历对象设置为date表示的时间
		//计算过期日前的第14天所在周的周三
		cal.add(Calendar.DAY_OF_YEAR, days);//计算过期日
		cal.add(Calendar.DAY_OF_YEAR, -14);//过期日前第14日
//		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, Calendar.SUNDAY);//DAY_OF_WEEK_IN_MONTH表示当月中的第几个星期
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//输出
		date = cal.getTime();
		String str = sdf.format(date);
		System.out.println("促销日为："+ str);
	*/
		
	/**	
		//将生产日期字符串转换为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//将date转变为日历类对象
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//计算过期日前的14天所在的周的周三
		cal.add(Calendar.DAY_OF_YEAR, days);//计算过期日
		cal.add(Calendar.DAY_OF_YEAR, -14);//计算过期日前的第14天
		cal.set(Calendar.DAY_OF_WEEK, 4);//设置当天所在周的周三
		//输出
		date = cal.getTime();//获取cal对象的Date类型数据
		String str = sdf.format(date);//将Date类型转换为String字符串
		System.out.println("促销日为："+ str);
	*/	
		
	/**	
		//将生产日期字符串转换为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//将Date类型转换为Calendar类型
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);//设置时间
		//计算过期日前的14天
		cal.add(Calendar.DAY_OF_YEAR, days);//计算过期日
		cal.add(Calendar.DAY_OF_YEAR, -14);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//设置其所在星期的星期三
		//输出
		date = cal.getTime();//获取日历对象的时间
		String str = sdf.format(date);
		System.out.println("促销日期为："+ str);
	*/	
	/**	
		//将生产日期字符串转变为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
		Date date = sdf.parse(dateStr);//调用sdf的Date parse(str)方法，将字符串转变为Date类型
		
		//将Date类型与Calendar类型互换
		Calendar cal = Calendar.getInstance();//创建日历对象
		cal.setTime(date);
		
		//*****计算促销日期
		cal.add(Calendar.DAY_OF_YEAR, days);//计算最终保质期
		cal.add(Calendar.DAY_OF_YEAR, -14);//计算保质期前的第14天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//设置为星期三
//		cal.set(Calendar.DAY_OF_WEEK, 4);//星期日=1，星期六=7
		int week = cal.get(Calendar.DAY_OF_WEEK);//获取日历对象的时间分量-星期
		//输出促销日期
		Date dt = cal.getTime();
		String marktDay = sdf.format(dt);
		System.out.println("促销日为："+ marktDay +"--"+ week);
	*/	


	}	
}