package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** 重复练习 */
public class DEMO {
	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		
		
		
		
		
		/**
		//将Date对象按照SimpleDateFormat设定的格式转换为String类型，使用sdf类的String format(Date date)方法
		Date date = new Date();
		System.out.println(date);
		/*
		 * 2008-08-08 20:08:00
		 * yyyy-MM-dd hh:mm:ss
		 *=/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(date);
		System.out.println(time);
		*/
		
	/**
		//使用SimpleDateFormat从字符串转为Date.使用 其类的Date parse(String str)方法
		String str = "2008年08月08日 20:08:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		Date date = sdf.parse(str);
		System.out.println(date.toString());
		System.out.println(date);
	 */
	/**	
		Scanner sc = new Scanner(System.in);//创建扫描器对象
		System.out.println("请输入您的出生年月日：（如：1990-10-10）");
		String birthStr = sc.nextLine();//接收用户输入
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//创建sdf对象，并设定格式
		Date birth = sdf.parse(birthStr);//创建时间对象，用paise(str)方法，将sdf对象转换为时间类型
		Date now = new Date();//创建现在时间对象，存储的是现在的时间到1970年元旦之间的毫秒数
		
		sc.close();
		long time = now.getTime() - birth.getTime();//出生时间到现在的毫秒数
		System.out.println(time);
		long days = time / 60 / 60 / 24 / 1000;//将毫秒数转化为天数.
		System.out.println("您已经活了："+ days +"天了！请继续保持！");
		long years = time / 1000 / 60 /60 /24 / 365;//活了多少年
//		long n =  1000 * 60 * 60 * 24 * 365;
//		long andDays = time % n;//零多少天====错误算法
		long andDays = time / 1000 / 60 /60 /24 % 365;
		System.out.println("您已经活了"+ years +"年零"+ andDays +"天了！请继续保持！"); 
 */
	}
}












