package day04.copy;
/**
 * static void sleep(long ms)
 * ʹ���е�ǰ�������߳�����ָ�����룬��ʱ�󣬸��̻߳��Զ��ص�runnable״̬�ȴ��ٴα�����ʱ��Ƭ���С�
 * @author Administrator
 *
 */
public class ThreadDemo07 {
	public static void main(String[] args) {
		System.out.println("����ʼ��!");
		try {
			Thread.sleep(5000);//����5000����
			/*
			 * �����ʹmain�߳�����5000���룬�ڴι������������̵߳�����main�̵߳�interrupt������ͼ�ж�
			 * main�߳�ʱ��sleep�������׳��쳣��
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��������ˣ�");
	}
}















