package day03;

import java.util.Date;

/**
 * java.util.Date
 * Date��ÿһ��ʵ������ʾһ�������ʱ��㡣
 * �ڲ�ά��һ��longֵ����ֵ��ʾ����UTCʱ��1970��Ԫ����������ʱ����������ĺ���
 * ����Date�������ȱ�ݣ����Դ󲿷ֲ���ʱ��ķ������ѹ�ʱ�����ڽ���������ʾһ��ʱ��㼴�ɣ������ڲ���ʱ�䡣
 * @author Administrator
 *
 */
public class DateDemo01 {
	public static void main(String[] args) {
		Date date = new Date();//Ĭ�ϴ���������Date��ʾ��ǰϵͳʱ��
		System.out.println(date);//Date��д��toString�������ڷ�Ӣ��������Բ��Ǻ��Ѻá�//Fri Jun 02 00:04:07 CST 2017
		
		//��ȡ���ڲ�ά����longֵ
		long time = date.getTime();
		System.out.println(time);//1496333047974
		
		//����������һ�̵�ʱ��
		time += 1000 * 60 * 60 * 24;
		System.out.println(time);//1496419447974
		//ʹDate��ʾ��������ֵ����ʾ��ʱ��
		date.setTime(time);
		System.out.println(date);//Sat Jun 03 00:04:07 CST 2017
	}
}













