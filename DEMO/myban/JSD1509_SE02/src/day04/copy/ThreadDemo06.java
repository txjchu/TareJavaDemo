package day04.copy;
/**
 * �̵߳����ȼ�
 * �̵߳��ȵĹ������ɿأ������̶߳���
 * 1.ʱ��Ƭ���̲��ɿأ�
 * 2.ʱ��Ƭ������ĸ��̲߳��ɿء�
 * �߳�ֻ�ܱ���������ʱ��Ƭ�󲢷����У���������Ҫ���ȡʱ��Ƭ��
 * 
 * �����߳����ȼ��������̶ȵĸ�Ԥ�̵߳��ȹ����������ϣ��߳����ȼ��ߵ��̷߳���ʱ��Ƭ�Ĵ����ࡣ
 * @author Administrator
 *
 */
public class ThreadDemo06 {
	public static void main(String[] args) {
		Thread min = new Thread(){
			public void run(){
				for(int i = 0; i < 10000; i ++){
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread(){
			public void run(){
				for(int i = 0; i < 10000; i ++){
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i = 0; i < 10000; i ++){
					System.out.println("norm");
				}
			}
		};
		min.setPriority(Thread.MIN_PRIORITY);//�������ȼ���С
		min.setPriority(Thread.MAX_PRIORITY);//�������ȼ����
		min.start();
		norm.start();
		max.start();
	}
}











