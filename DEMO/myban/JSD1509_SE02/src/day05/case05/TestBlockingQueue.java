package day05.case05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ����2	BlockingQueue
 * @author Administrator
 *
 */
public class TestBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);//����˫�˻������
		for(int i = 0; i < 20; i ++){
			try {
				boolean b = queue.offer(i, 5, TimeUnit.SECONDS);//ÿ5������������һ��Ԫ�� 
				System.out.println("��"+ i +"�δ���Ԫ���Ƿ�ɹ���"+ b);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		//��ָ��ʱ���ȡ������Ԫ��
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);//����˫�˻������
		for(int i = 0; i < 10; i ++){
			queue.offer(i);
		}
		for(int i = 0; i < 20; i ++){
			try {
				Integer b = queue.poll(5, TimeUnit.SECONDS);
				System.out.println("��"+ i +"�ζ�ȡ����Ԫ���ǣ�"+ b);
			} catch (InterruptedException e) {
				System.out.println();
				e.printStackTrace();
			}
		}
		
	}
}












