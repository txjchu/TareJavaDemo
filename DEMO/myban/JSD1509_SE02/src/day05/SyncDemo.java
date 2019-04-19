package day05;
/**
 * ���̲߳�����ȫ����
 * �����߳�Ǯ���Ĳ�ȷ���Ͳ��ɿ�  �����¶���߳�������ͬһ��Դʱ�����ܳ������غ����
 * Ϊ�ˣ���Ҫ�����Ҫ�������ɸ��ģ�����������Ϊ���ŶӸɣ�������
 * �첽��ͬ����
 * @author Administrator
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean=table.getBean();
					//ģ������������û��ʱ���ˣ��������߳��л�
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2=new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}	
class Table{
	private int beans=20;
	/*
	 * ��һ��������synchronized �����Ժ󣬸÷�����Ϊ��ͬ����������
	 * ����̲߳���ͬʱ���뷽���ڲ�ִ�С�
	 * 
	 * ����������synchronized�������Ķ�����ǵ�ǰ���������Ķ���this����
	 * 
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("û�ж����ˣ�");
		}
		//ģ������������û��ʱ���ˣ������߳��л�
		Thread.yield();
		return beans--;
		
	}
}
	

