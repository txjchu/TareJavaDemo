package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类可以根据一个给定的[日期格式字符串]将Date
 * 与String相互转换。 
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo1 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		/*
		 * 2015-10-28 10:52:33
		 * yyyy-MM-dd HH:mm:ss
		 */
		
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
		/*
		 * String format(Date date)
		 * 将给定的日期按照SimpleDateFormat创建
		 * 时指定的日期格式将其转换为字符串
		 * Date-->String
		 */
		String str = sdf.format(date);
		
		System.out.println(str);
	}
}







