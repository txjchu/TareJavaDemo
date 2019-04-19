package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用SimpleDateFormat从字符串转换为Date			format:使格式化，n.格式，版本
 * Date parse(String source)方法
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo02 {
	public static void main(String[] args) throws ParseException {
		String str = "2008年08月08日  20:08:00";
		/*
		 * String --> Date
		 * Date parse(String str)方法
		 * SimpleDateFormat的该方法用于将给定的字符串按照创建SimpleDateFormat时给定的日期格式解析为Date对象。 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//:不能使用中文状态下的冒号。
		Date date = sdf.parse(str);
		System.out.println(date);//Fri Aug 08 20:08:00 CST 2008
	}
}










