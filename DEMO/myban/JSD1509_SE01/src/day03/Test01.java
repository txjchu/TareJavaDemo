package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日：1990-10-21
 * 经过计算输出：到今天为止，您活了xxxx天
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);//创建扫描器对象
		System.out.println("请输入您的出生年月日：（如：1990-10-21）");
		String birthStr = scan.nextLine();//记录用户出生年月	//输入1991-09-09
		
		SimpleDateFormat sdf = new 	SimpleDateFormat("yyyy-MM-dd"); 
		Date birthDate = sdf.parse(birthStr);
		long birthDateLong = birthDate.getTime();
		Date now = new Date();//当前时间
		long dateLong = now.getTime();
		long live = (dateLong - birthDateLong) / 24 / 60 / 60 / 1000; 
		System.out.println("您活了："+ live +"天了！");//您活了：9398天了！
		long liveYear = live / 365;
		long liveDay = live % 365;
		System.out.println("您活了："+ liveYear +"年"+ liveDay +"天了！");//您活了：25年273天了！
		scan.close();
		
	}
}














