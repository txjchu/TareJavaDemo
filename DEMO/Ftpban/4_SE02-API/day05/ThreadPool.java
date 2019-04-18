package day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳أ�
 * ��Ҫ�����������
 * 1:�����߳�����
 * 2:�����߳�
 * 
 * �������д���������Ҫ����ʱ����Ҫ����ʹ���̳߳�
 * �����ǵĳ���Ƶ���Ĵ����߳������߳�ʱ��ҲҪʹ���̳߳�
 * 
 * 
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		//����һ������2���̵߳Ĺ̶��̳߳�
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"����ִ������..");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("�̱߳��ж���!");
					}
					System.out.println(t+"�����������!");
				}
			};
			//������ָ�ɸ��̳߳�
			threadPool.execute(runn);
		}
		//��������ָ�����
		System.out.println("��������ָ�����");
		
		System.out.println("�ر��̳߳�...");
		threadPool.shutdownNow();
		
	}
}







