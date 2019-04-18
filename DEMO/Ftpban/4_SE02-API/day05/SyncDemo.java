package day05;
/**
 * ���̲߳�����ȫ����
 * �����߳��л��Ĳ�ȷ���ɲ��ɿأ����¶���߳�
 * ������ͬһ��Դʱ�����ܳ������غ����
 * Ϊ�ˣ�Ҫ������Ҫ��"���ɸ���"��Ϊ"�ŶӸ�"��
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
					int bean = table.getBean();
					//ģ������������û��ʱ���ˣ������߳��л�
					Thread.yield();
					System.out.println(
						getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					//ģ������������û��ʱ���ˣ������߳��л�
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
	private int beans = 20;
	/*
	 * ��һ��������synchronized�����Ժ󣬸÷���
	 * ��Ϊͬ������������̲߳���ͬʱ���뷽���ڲ�
	 * ִ�С�
	 * ����������synchronized�������������
	 * ��ǰ������������(this)
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("û�ж�����!");
		}
		//ģ������������û��ʱ���ˣ������߳��л�
		Thread.yield();
		return beans--;
	}
}




