package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用SimpleDateFormat从字符串转换为Date
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		String str = "2008年08月08日 20:08:00";
		/*
		 * String-->Date
		 * 
		 * Date parse(String str)
		 * SimpleDateFormat的该方法用于将
		 * 给定的字符串按照创建SimpleDateFormat
		 * 时指定的日期格式解析为Date对象。
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy年MM月dd日 HH:mm:ss"	
			);
		
		Date date = sdf.parse(str);
		
		System.out.println(date);
	}
}







