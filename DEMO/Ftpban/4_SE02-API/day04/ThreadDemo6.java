package day04;
/**
 * �߳����ȼ�
 * 
 * �̵߳��ȵĹ������ɿأ������̶߳���:
 * 1:ʱ��Ƭ���̲��ɿ�
 * 2:ʱ��Ƭ������ĸ��̲߳��ɿ�
 * 
 * �߳�ֻ�ܱ���������ʱ��Ƭ�󲢷����У�����
 * ����Ҫ���ȡʱ��Ƭ��
 * 
 * �����߳����ȼ��������̶ȵĸ�Ԥ�̵߳���
 * ����
 * �����ϣ��߳����ȼ��ߵ��̷߳���ʱ��Ƭ�Ĵ����ࡣ
 * 
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("norm");
				}
			}
		};		
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);		
		min.start();
		norm.start();
		max.start();
		
	}
}









