package day05.case05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����1	
 * @author Administrator
 *
 */
public class TestExecutorService {
	public static void main(String[] args) {
		//�����̳߳أ�ָ���߳�����Ϊ2
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 5; i ++){
			Handler handler = new Handler();//����һ���������̶߳���
			pool.execute(handler);//��Handler�̵߳Ķ����ύ���̳߳�
		}
		pool.shutdown();//�ر��̳߳�
	}
}
/*
 * �������߳�	ִ��ÿһ�����һ�ε�ǰ�̵߳�����
 */
class Handler implements Runnable{
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("ִ�е�ǰ������߳���"+ name);
		for(int i = 0; i < 10; i ++){
			try {
				System.out.println("�߳�"+ name +"��������..."+ i);			
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(name +"������!");
				e.printStackTrace();
			}		
		}
		System.out.println("������ɣ�");
	}
}
