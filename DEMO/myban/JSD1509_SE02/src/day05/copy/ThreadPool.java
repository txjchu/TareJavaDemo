package day05.copy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳أ�
 * ����	1.�����߳�����
 * 		2.�����߳�
 * 
 * �������д���������Ҫ����ʱ����Ҫ����ʹ���̳߳ء�
 * �����ǵĳ���Ƶ���Ĵ����߳������߳�ʱ��ҲҪʹ���̳߳ء�
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		//����һ������2���̵߳Ĺ̶��ֳ���
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 5; i ++){
			Runnable runn = new Runnable(){
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println("�߳�"+ t +"����ִ������...");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("�̱߳��ж��ˣ�");
					}
					System.out.println("�߳�"+ t +"����������ϣ�");
				}				
			};
			//������ָ�ɸ��̳߳�
			threadPool.execute(runn);
			System.out.println("���߳�"+ runn +"�ύ�����̳߳�...");
		}
		//��������ָ�����
		System.out.println("��������ָ�ɸ��̳߳���ϣ�");
		
		System.out.println("�ر��̳߳�....");
		threadPool.shutdownNow();//�����ر��̳߳أ������Ƿ�������Runnable��Running���̡߳�
//		threadPool.shutdown();//�ر��̳߳أ�����Runningִ�е��̻߳����ִ�����
	}
}






















