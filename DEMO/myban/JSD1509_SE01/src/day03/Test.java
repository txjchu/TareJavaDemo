package day03;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Ҫ���û������Լ������գ�1992-10-21
 * �������������������Ϊֹ��������xxxx��
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] arge) throws ParseException{
		Scanner scan=new Scanner(System.in);
		System.out.println("�������Լ�������:");
		String str=scan.next();
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date inputdate=sdf.parse(str);
		long a=inputdate.getTime();
		Date sysdate=new Date();
			long b=sysdate.getTime();
			long c=b-a;
			long days=c/1000/60/60/24;
			System.out.println("���Ѿ����ˣ�"+days+"���ˣ�");
		
		
		
		
	}
}
