package day04.copy;
/**
 * static Thread currentThread()
 * �߳��ṩ�ĸþ�̬����������ȡ���е�ǰ�������̡߳�
 * 
 * String  toString()
 * Thread�̵߳�toString���������ص��ַ����������߳��������ȼ����߳��顣
 * @author Administrator
 *
 */
public class ThreadDemo04 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("��������main�������߳��ǣ�"+ mainThread);
		//main�̵߳���dosome����
		dosome();
		
		Thread nmthread = new Thread(){
			public void run(){
				/*
				 * ��ǰ�߳�nmhread������start������ֻҪ��ȡ��CPUʱ��Ƭ�󣬾ͻῪʼִ��run����������
				 * run�����л�ȡ�̻߳�ȡ�ľ���nmthread��
				 */
				//�鿴����run�������߳�
				Thread nmt = Thread.currentThread();
				System.out.println("�Զ����̣߳�"+ nmt);
				
				dosome();
			}
		};
		nmthread.start();
		
	}
	
	public static void dosome(){
		//�鿴���е�ǰdosome�������߳���
		Thread t = Thread.currentThread();
		System.out.println("����dosome�������߳��ǣ�"+ t);
	}
}














