package day04;
/**
 * static Thread currentThread()
 * 
 * �߳��ṩ�ĸþ�̬����������ȡ���е�ǰ�������̡߳�
 * 
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("����main�������߳��ǣ�"+main);
	
		//main�̵߳���dosome����
		dosome();
		
		Thread thread=new Thread(){			//�����ڲ��࣬�Զ���������Thread-0 
			public void run(){
				/*
				 * ��ǰ�߳�thread������start������ֻҪ��ȡ��CPUʱ��Ƭ��
				 * �ͻῪʼִ��run����������run�����л�ȡ�̻߳�ȡ�ľ���thread��
				 * 
				 */
				//�鿴����run�������߳�
				Thread t=Thread.currentThread();
				System.out.println("�Զ����̣߳�"+t);
				
				dosome();			//----˭���õ�
			}
		};
		thread.start();
		
	}
	
	public static void dosome(){
		//�鿴���е�ǰdosome�������߳��ǣ�
		Thread t=Thread.currentThread();
		System.out.println("����dosome�������߳��ǣ�"+t);
	}
	
	
}

