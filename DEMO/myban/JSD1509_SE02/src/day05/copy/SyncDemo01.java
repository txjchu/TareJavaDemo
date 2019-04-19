package day05.copy;
/**
 * 
 * @author Administrator
 *
 */
public class SyncDemo01 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int been = table.getBeen();
					//ģ��˴�����û��ʱ��Ƭ�ˣ������߳��л�
					Thread.yield();
					System.out.println("�߳�1"+ this.getName() +":"+ been);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int been = table.getBeen();
					//ģ��˴�����û��ʱ��Ƭ�ˣ��������߳��л�
					Thread.yield();
					System.out.println("�߳�2"+ this.getName() +":"+ been);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
/**
 * static void yield()
 * ��̬����ʹ��ǰ�߳������ó�CPU�ص�Runnable״̬���ȴ�����ʱ��Ƭ��
 * @author Administrator
 *
 */
class Table{
	private int beens = 20;
	/*
	 * ��һ��������synchronized���κ󣬸÷�����Ϊͬ������������̲߳���ͬʱ���뷽���ڲ�ִ�С�
	 * ����������synchronized�������Ķ�����ǵ�ǰ���������Ķ���this��
	 */
	public synchronized int getBeen(){
		if(beens == 0){
			throw new RuntimeException("û�ж����ˣ�");
		}
		//ģ��˴�����û��ʱ��Ƭ�ˣ��������߳��л�
		Thread.yield();
		System.out.println(Thread.currentThread() +"���ڵ���...");
		return beens --;
	}
}
















