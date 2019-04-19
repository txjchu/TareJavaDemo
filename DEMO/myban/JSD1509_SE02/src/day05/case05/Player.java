package day05.case05;

import java.util.concurrent.BlockingQueue;

/**
 * �κ�ϰ��	������ ===== ������  ��ʾ˫�˶��п���ͬʱ��ȡ
 * @author Administrator
 *
 */
public class Player implements Runnable {
	//˫�˻������
	private BlockingQueue queue;
	//������
	public Player(BlockingQueue q){
		this.queue = q;
	}
	@Override
	public void run() {
		try {
			while(true){
				consume(queue.take());
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//���ѷ���	���Ӷ�����ȡ��Ԫ��
	public void consume(Object o){//consume ����
		System.out.println("������Ƶ"+ o);
	}
	
	
	
	
}
