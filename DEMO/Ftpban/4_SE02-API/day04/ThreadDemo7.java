package day04;
/**
 * static void sleep(long ms)
 * ʹ���е�ǰ�������߳�����ָ�����룬��ʱ��
 * ���̻߳��Զ��ص�runnable״̬�ȴ��ٴα�
 * ����ʱ��Ƭ���С�
 * @author Administrator
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			/*
			 * �����ʹmain�߳�����5���ӡ�
			 * �ڴ˹������������̵߳�����main�߳�
			 * ��interrupt������ͼ�ж�main�߳�
			 * ʱ��sleep�������׳��쳣��
			 */
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("���������");
	}
}






