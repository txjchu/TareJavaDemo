package day03.hw03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/** ��ҵһ��������Ʒ�������ڣ������ڽ�����ǰ�ĵ�14�������ܵ��������� */
public class testDiscountDate {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);//����ɨ��������
		System.out.println("��������Ʒ���������ڣ�yyyy-MM-dd����");
		String dateStr = sc.nextLine();//�����û���������ڣ����ַ������ͱ���
		System.out.println("��������Ʒ�ı����ڣ���������");
		int days = sc.nextInt();//�����û����������
		sc.close();//�ر�ɨ����
		
		//���ַ���תΪDate����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//��Date����ת��ΪCalendar���Ͷ�������ʱ������Ĳ���
		Calendar cal = Calendar.getInstance();//��ȡʵ��
		cal.setTime(date);
		//���������ǰ�ĵ�14�������ܵ�����
		cal.add(Calendar.DAY_OF_YEAR, days);//���������
		cal.add(Calendar.DAY_OF_YEAR, -14);//������ǰ��14��
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//����Ϊ���������ܵ�����
		//���
		date = cal.getTime();//��ȡ��������
		String str = sdf.format(date);//ת��Ϊ�ַ���
		System.out.println("������Ϊ��"+ str);
		
		
		
		
		
		
	/**	
		//�����������ַ���ת��ΪDate����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//��Date��������ת��ΪCalendar�������ڲ���ʱ�����
		Calendar cal = Calendar.getInstance();//��ȡʵ��
		cal.setTime(date);//����Ϊdate��ʾ��ʱ��
		//���������ǰ�ĵ�14�������ܵ�����
		cal.add(Calendar.DAY_OF_YEAR, days);//���������
		cal.add(Calendar.DAY_OF_YEAR, -14);//������ǰ�ĵ�14��
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//����Ϊ���������ܵ�����
		//���
		date = cal.getTime();//�����������ת��ΪDate����
		String str = sdf.format(date);//ת��Ϊ�ַ���
		System.out.println("������Ϊ��"+ str);
	*/
		
	/**
		//�����������ַ���ת��ΪDate����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//��Date��������ת��ΪCalendar�������ڲ���ʱ�����
		Calendar cal = Calendar.getInstance();//��ȡʵ��
		cal.setTime(date);//��������������Ϊdate��ʾ��ʱ��
		//���������ǰ�ĵ�14�������ܵ�����
		cal.add(Calendar.DAY_OF_YEAR, days);//���������
		cal.add(Calendar.DAY_OF_YEAR, -14);//������ǰ��14��
//		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, Calendar.SUNDAY);//DAY_OF_WEEK_IN_MONTH��ʾ�����еĵڼ�������
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//���
		date = cal.getTime();
		String str = sdf.format(date);
		System.out.println("������Ϊ��"+ str);
	*/
		
	/**	
		//�����������ַ���ת��ΪDate����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//��dateת��Ϊ���������
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//���������ǰ��14�����ڵ��ܵ�����
		cal.add(Calendar.DAY_OF_YEAR, days);//���������
		cal.add(Calendar.DAY_OF_YEAR, -14);//���������ǰ�ĵ�14��
		cal.set(Calendar.DAY_OF_WEEK, 4);//���õ��������ܵ�����
		//���
		date = cal.getTime();//��ȡcal�����Date��������
		String str = sdf.format(date);//��Date����ת��ΪString�ַ���
		System.out.println("������Ϊ��"+ str);
	*/	
		
	/**	
		//�����������ַ���ת��ΪDate����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//��Date����ת��ΪCalendar����
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);//����ʱ��
		//���������ǰ��14��
		cal.add(Calendar.DAY_OF_YEAR, days);//���������
		cal.add(Calendar.DAY_OF_YEAR, -14);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//�������������ڵ�������
		//���
		date = cal.getTime();//��ȡ���������ʱ��
		String str = sdf.format(date);
		System.out.println("��������Ϊ��"+ str);
	*/	
	/**	
		//�����������ַ���ת��ΪDate����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
		Date date = sdf.parse(dateStr);//����sdf��Date parse(str)���������ַ���ת��ΪDate����
		
		//��Date������Calendar���ͻ���
		Calendar cal = Calendar.getInstance();//������������
		cal.setTime(date);
		
		//*****�����������
		cal.add(Calendar.DAY_OF_YEAR, days);//�������ձ�����
		cal.add(Calendar.DAY_OF_YEAR, -14);//���㱣����ǰ�ĵ�14��
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//����Ϊ������
//		cal.set(Calendar.DAY_OF_WEEK, 4);//������=1��������=7
		int week = cal.get(Calendar.DAY_OF_WEEK);//��ȡ���������ʱ�����-����
		//�����������
		Date dt = cal.getTime();
		String marktDay = sdf.format(dt);
		System.out.println("������Ϊ��"+ marktDay +"--"+ week);
	*/	


	}	
}