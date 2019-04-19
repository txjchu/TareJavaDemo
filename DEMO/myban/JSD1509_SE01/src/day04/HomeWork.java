package day04;
//��ҵ1
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ����
 * 1.����Scanner��
 * 2.��ȡ�û�������������ڣ�
 * 3.��ȡ�û�����ı���������
 * 4.����SimpleDateFormat���ڽ��������ڵ��ַ���ת��ΪDate��
 * 5.����Calendar�����ұ�ʾΪDate��ʾ���������ڣ�
 * 6.��������գ��������ڼ��ϱ����ڵ�������
 * 7.�ӹ�ȥ���ڼ�ȥ14�죨����ǰ����
 * 8.����Ϊ���ܵ��������ɡ�
 * 9.Calendarת����Date
 * 10.��Dateת��ΪString Ȼ�����
 * @author Administrator
 *
 */
public class HomeWork {
	public static void main(String[] args) throws ParseException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("�������������ڣ�yyyy-MM-dd��:");
		
		String dateStr=scanner.nextLine();
		
		System.out.println("�����뱣���ڣ���������");
		int days=Integer.parseInt(scanner.nextLine());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date date=sdf.parse(dateStr);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		
		//���������
		calendar.add(Calendar.DAY_OF_YEAR, days);
		calendar.add(Calendar.DAY_OF_MONTH, -14);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		
		date=calendar.getTime();
		
		dateStr=sdf.format(date);
		
		System.out.println("������Ϊ��"+dateStr);
		
		
		
		
		
		
		
		
		
	}
}
