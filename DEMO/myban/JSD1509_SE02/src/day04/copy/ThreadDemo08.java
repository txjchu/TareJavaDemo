package day04.copy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ӱ�
 * ÿ�������һ�ε�ǰϵͳʱ�䣬��ʽHH:mm:ss
 * @author Administrator
 *
 */
public class ThreadDemo08 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		while(true){
			Date now = new Date();
			System.out.println(sdf.format(now));
			try {
				/*
				 * �˴���Thread�̵߳���������sleep���������ǵ���main������mian�̣߳�����1�ξ�����1�롣
				 */
				Thread.sleep(1000);//���һ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}















