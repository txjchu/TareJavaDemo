package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日:1992-10-21
 * 经过计算输出:到今天为止，您活了xxxx天
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scanner 
			= new Scanner(System.in);
		
		System.out.println("请输入您的生日:");
		String birthStr = scanner.nextLine();
		
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd"	
			);
		Date birth = sdf.parse(birthStr);
		
		Date now = new Date();
		
		long time = now.getTime()-birth.getTime();
		
		long days = time/1000/60/60/24;
		
		System.out.println(
			"恭喜您，已经活了"+days+"天，请继续保持!"
		);
		
	}
}




