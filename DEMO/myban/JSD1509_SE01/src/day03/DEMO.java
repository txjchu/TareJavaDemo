package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** �ظ���ϰ */
public class DEMO {
	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		
		
		
		
		
		/**
		//��Date������SimpleDateFormat�趨�ĸ�ʽת��ΪString���ͣ�ʹ��sdf���String format(Date date)����
		Date date = new Date();
		System.out.println(date);
		/*
		 * 2008-08-08 20:08:00
		 * yyyy-MM-dd hh:mm:ss
		 *=/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(date);
		System.out.println(time);
		*/
		
	/**
		//ʹ��SimpleDateFormat���ַ���תΪDate.ʹ�� �����Date parse(String str)����
		String str = "2008��08��08�� 20:08:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
		Date date = sdf.parse(str);
		System.out.println(date.toString());
		System.out.println(date);
	 */
	/**	
		Scanner sc = new Scanner(System.in);//����ɨ��������
		System.out.println("���������ĳ��������գ����磺1990-10-10��");
		String birthStr = sc.nextLine();//�����û�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//����sdf���󣬲��趨��ʽ
		Date birth = sdf.parse(birthStr);//����ʱ�������paise(str)��������sdf����ת��Ϊʱ������
		Date now = new Date();//��������ʱ����󣬴洢�������ڵ�ʱ�䵽1970��Ԫ��֮��ĺ�����
		
		sc.close();
		long time = now.getTime() - birth.getTime();//����ʱ�䵽���ڵĺ�����
		System.out.println(time);
		long days = time / 60 / 60 / 24 / 1000;//��������ת��Ϊ����.
		System.out.println("���Ѿ����ˣ�"+ days +"���ˣ���������֣�");
		long years = time / 1000 / 60 /60 /24 / 365;//���˶�����
//		long n =  1000 * 60 * 60 * 24 * 365;
//		long andDays = time % n;//�������====�����㷨
		long andDays = time / 1000 / 60 /60 /24 % 365;
		System.out.println("���Ѿ�����"+ years +"����"+ andDays +"���ˣ���������֣�"); 
 */
	}
}












