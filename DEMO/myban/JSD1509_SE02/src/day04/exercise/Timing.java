package day04.exercise;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �κ�ϰ��5	���ӱ�
 * ���ʱ��	
 * @author Administrator
 *
 */
public class Timing {
	public static void main(String[] args) {
		Thread d = new Thread(){
			public void run(){
				while(true){//�������
					Date date = new Date();//ʱ�����
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");//���ڸ�ʽ����
					System.out.println("ʱ�䣺"+ sdf.format(date));//�����ʽ���������
					try {
						Thread.sleep(1000);//��������
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			}
		};
		d.setDaemon(true);//����Ϊ�ػ��߳�
		d.start();//�����߳�
		try {
			Thread.sleep(5000);//��ǰ�߳̽�������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//ģ������ǰ̨�߳̽��������Թ۲�����̵߳�״̬
		System.out.println("main�������߳̽�����");
	}
}
