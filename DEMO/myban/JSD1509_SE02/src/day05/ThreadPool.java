package day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳أ�
 * ��Ҫ����������⣺
 * 1.�����߳�������		2.�����̡߳�
 * 
 * �������д���������Ҫ����ʱ������Ҫ����ʹ���̳߳ء�
 * �����ǵĳ���Ƶ���Ĵ����߳������߳�ʱ��ҲҪʹ���̳߳ء�
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
					System.out.println(t+"����ִ������...");
					try{
						Thread.sleep(3000);
					}catch(InterruptedException e){
						System.out.println("�̱߳��ж���~~~");
					}
					System.out.println(t+"����������ϣ�");
				}
			};
			//������ֽ�Ƹ��̳߳�
			threadPool.execute(runn);
		}
		//���е�����ָ�����
		System.out.println("��������ָ����ϣ�");
		
		System.out.println("�ر��̳߳�...");
		threadPool.shutdown();
//		threadPool.shutdownNow();
	}
}
