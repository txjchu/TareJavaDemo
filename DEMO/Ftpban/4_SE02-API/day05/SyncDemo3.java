package day05;
/**
 * ��̬������ʹ��synchronized.
 * synchronized���ξ�̬��������������Ϊ
 * ��ǰ�����
 * �����:Class���͵�ʵ����JVM�ڼ����κ�һ����ʱ��
 * ���ᴴ��һ��Class���͵�ʵ�����������࣬����ÿ��
 * �඼����ֻ��һ��Class��ʵ����������synchronized
 * �ھ�̬�����о��Ǹ����Classʵ��������
 * ���ԣ�����߳����ۺ�ʱ�εص���ͬһ����̬����ʱ��
 * ������ͬ��Ч����
 * 
 * ����
 * @author Administrator
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final SyncDemo3 d1 = new SyncDemo3();
		final SyncDemo3 d2 = new SyncDemo3();
		Thread t1 = new Thread(){
			public void run(){
				d1.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d2.dosome();
			}
		};
		t1.start();
		t2.start();
	}
	
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t+"���ڵ���dosome����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"����dosome���!");
	}
}


