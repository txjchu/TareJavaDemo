package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Ҫ���û������Լ������գ�1990-10-21
 * �������������������Ϊֹ��������xxxx��
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);//����ɨ��������
		System.out.println("���������ĳ��������գ����磺1990-10-21��");
		String birthStr = scan.nextLine();//��¼�û���������	//����1991-09-09
		
		SimpleDateFormat sdf = new 	SimpleDateFormat("yyyy-MM-dd"); 
		Date birthDate = sdf.parse(birthStr);
		long birthDateLong = birthDate.getTime();
		Date now = new Date();//��ǰʱ��
		long dateLong = now.getTime();
		long live = (dateLong - birthDateLong) / 24 / 60 / 60 / 1000; 
		System.out.println("�����ˣ�"+ live +"���ˣ�");//�����ˣ�9398���ˣ�
		long liveYear = live / 365;
		long liveDay = live % 365;
		System.out.println("�����ˣ�"+ liveYear +"��"+ liveDay +"���ˣ�");//�����ˣ�25��273���ˣ�
		scan.close();
		
	}
}














