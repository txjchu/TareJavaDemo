package day05.case05;

import java.util.concurrent.BlockingQueue;

/**
 * �κ�ϰ��	������ ==== ������	��ʾ˫�˻�����п���ͬʱ��ȡ�̡߳�
 * 
 * �ܽ᣺ 1.�趨һ�����������������̵߳�������Ȼ����run�������ظ����á�����˫�˻����̶߳��еĲ���������߳������Ĳ������뿪��
 * 	   2.˫�˻������put/take��pull/push����ȡ��4�ַ�������������
 * 	   3.��������ֵΪObject
 * 	   4.BlockingQueue�д������������produce()�ķ���ֵObject.˫�˻���������������߳�ͬʱ���д桢ȡ������
 * @author Administrator
 *
 */
public class Download implements Runnable{
	
	//˫�˻������
	private BlockingQueue queue;
	//������
	public Download(BlockingQueue q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				System.out.println("������Ƶ����"+ index);
				queue.put(produce());//�����̷߳���˫�˻������
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	} 
	
	//˯��
	int index = 0;
	public Object produce(){
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "������Ƶ"+ index++;
	}
	
}
