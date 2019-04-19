package day03.hw03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/** ������ϰ */
public class CASE {
	
	//����1
	@Test
	public void testGetTime(){
		Date date = new Date();
		System.out.println(date);//Sat Jun 03 23:43:55 CST 2017
		
		long time = date.getTime();
		System.out.println(time);
	}
	@Test 
	public void testSetTime(){
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		time += 1000 * 60 * 60 * 24;
		date.setTime(time);
		System.out.println(date);
	}
	
	//����2
	@Test
	public void testFormat(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String str = sdf.format(date);
		System.out.println(str);
	}
	
	//����3
	@Test
	public void testParse() throws ParseException{
		String str = "2017-06-03 11-51-26";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = sdf.parse(str);
		System.out.println(date);
	}
	
	//����4
	@Test
	public void testGetInstance(){
		//����
		Calendar cal = Calendar.getInstance();//������
		System.out.println(cal.getClass().getName());//java.util.GregorianCalendarĬ�ϴ������������������
		//ת��ΪDate
		Date date = cal.getTime();//�����������ת��Ϊ������
		System.out.println(date);
		//����Ϊ2008-08-08
		cal.set(Calendar.YEAR, 2008);
		cal.set(Calendar.MONTH, Calendar.AUGUST);//August = 7,�·��Ǵ�0��ʼ��
		cal.set(Calendar.DAY_OF_MONTH, 8);//����һ�����еļ���
//		cal.set(Calendar.DATE, 8);//ͬ��һ������
		date = cal.getTime();
		System.out.println(date);
		
		GregorianCalendar gc = new GregorianCalendar(2008,Calendar.AUGUST,8);
		gc.set(Calendar.MINUTE, 41);//���÷�����
		date = gc.getTime();
		System.out.println(date);
		
		//����5
		date = new Date();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 22);
		cal.set(Calendar.DATE, 32);//6��32�գ���7��2��
		date = cal.getTime();
		System.out.println(date);
		
		//����6  ��ȡʱ����� int get(int field);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("�����еĵ�"+ dayOfWeek +"�죨����Ϊ��һ�죩��");
		
		//����7
		Calendar cal7 = Calendar.getInstance();
		cal7.set(Calendar.YEAR, 2008);//����
		cal7.set(Calendar.DAY_OF_MONTH, 1);//����Ϊ����1��
		for(int i = 0; i < 12; i ++){//�·��Ǵ�0��ʼ����1�µ�intֵΪ0
			cal7.set(Calendar.MONTH, i);
			int daysOfMonth = cal7.getActualMaximum(Calendar.DATE);
			System.out.println(i+1 +"�·���"+ daysOfMonth +"��");
		}
		
		//����8
		date = cal7.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		System.out.println(str);
		cal7.add(Calendar.YEAR, 1);//����1��
		cal7.add(Calendar.MONTH, -3);//��ȥ3����
		date = cal7.getTime();
		str = sdf.format(date);
		System.out.println(str);
		
	}
}











