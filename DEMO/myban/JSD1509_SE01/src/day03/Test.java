package day03;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日：1992-10-21
 * 经过计算输出：到今天为止，您活了xxxx天
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] arge) throws ParseException{
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入自己的生日:");
		String str=scan.next();
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date inputdate=sdf.parse(str);
		long a=inputdate.getTime();
		Date sysdate=new Date();
			long b=sysdate.getTime();
			long c=b-a;
			long days=c/1000/60/60/24;
			System.out.println("您已经活了："+days+"天了！");
		
		
		
		
	}
}
