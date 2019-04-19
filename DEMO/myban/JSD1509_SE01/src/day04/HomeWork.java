package day04;
//作业1
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 步骤
 * 1.创建Scanner，
 * 2.获取用户输入的生产日期，
 * 3.获取用户输入的保质天数，
 * 4.创建SimpleDateFormat用于将生产日期的字符串转换为Date，
 * 5.创建Calendar，并且表示为Date表示的生产日期，
 * 6.计算过期日，生产日期加上保质期的天数，
 * 7.从过去日期减去14天（两周前），
 * 8.设置为当周的周三即可。
 * 9.Calendar转换回Date
 * 10.将Date转换为String 然后输出
 * @author Administrator
 *
 */
public class HomeWork {
	public static void main(String[] args) throws ParseException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入生产日期（yyyy-MM-dd）:");
		
		String dateStr=scanner.nextLine();
		
		System.out.println("请输入保质期（天数）：");
		int days=Integer.parseInt(scanner.nextLine());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date date=sdf.parse(dateStr);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		
		//计算过期日
		calendar.add(Calendar.DAY_OF_YEAR, days);
		calendar.add(Calendar.DAY_OF_MONTH, -14);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		
		date=calendar.getTime();
		
		dateStr=sdf.format(date);
		
		System.out.println("促销日为："+dateStr);
		
		
		
		
		
		
		
		
		
	}
}
