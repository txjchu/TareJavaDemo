package day04;
/**
 * �߳����ȼ�
 * 
 * �̵߳��ȵĹ������ɿأ������̶߳��ԣ�
 * 1.ʱ��Ƭ���̲��ɿأ�
 * 2.ʱ��Ƭ������ĸ��̲߳��ɿأ�
 * 
 * �߳�ֻ�ܱ���������ʱ��Ƭ�󲢷����У���������Ҫ���ȡʱ��Ƭ��
 * 
 * �����߳����ȼ��������̶ȵĸ�Ԥ�̵߳��ȹ�����
 * �����ϣ��߳����ȼ��ߵ��̷߳���ʱ��Ƭ�Ĵ����ࡣ
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		
		Thread min=new Thread(){
			public void run(){
				for(int i=0;i<200;i++){
					System.out.println("min");
				}
			}	
		};
			
		Thread max=new Thread(){	
			public void run(){
				for(int i=0;i<200;i++){
					System.out.println("max");
				}
			}
		};
		
		Thread norm=new Thread(){	
			public void run(){
				for(int i=0;i<200;i++){
					System.out.println("norm");
				}
			}
		};	
			min.setPriority(Thread.MIN_PRIORITY);
			min.setPriority(Thread.MAX_PRIORITY);
			min.start();
			norm.start();
			max.start();
		}
}