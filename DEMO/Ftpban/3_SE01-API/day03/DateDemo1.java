package day03;

import java.util.Date;


/**
 * java.util.Date
 * Date��ÿһ��ʵ������ʾһ�������ʱ��㡣
 * �ڲ�ά��һ��longֵ����ֵ��ʾ���Ǵ�UTCʱ��1970��
 * Ԫ����������ʱ����������ĺ����
 * ����Date�������ȱ�ݣ����Դ󲿷ֲ���ʱ��ķ�����
 * �ѹ�ʱ�����ڽ���������ʾһ��ʱ��㼴�ɣ������ڲ���
 * ʱ�䡣
 * @author Administrator
 *
 */
public class DateDemo1 {
	public static void main(String[] args) {
		/*
		 * Ĭ�ϴ���������Date��ʾ��ǰϵͳʱ��
		 */
		Date date = new Date();
		/*
		 * Date��д��toString���ڷ�Ӣ��
		 * �������Բ��Ǻ��Ѻá�
		 */
		System.out.println(date);
		
		
		//��ȡ���ڲ�ά����longֵ
		long time = date.getTime();
		
		System.out.println(time);
		
		//����������һ�̵�ʱ��
		time += 1000*60*60*24;
		
		//ʹDate��ʾ��������ֵ����ʾ��ʱ��
		date.setTime(time);
		
		System.out.println(date);
		
	}
}







