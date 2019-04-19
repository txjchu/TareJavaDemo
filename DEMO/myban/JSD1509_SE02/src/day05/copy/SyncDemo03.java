package day05.copy;
/**
 * ��̬������ʹ��synchronized.
 * synchronized���ξ�̬��������������Ϊ��ǰ�����
 * �����Class���͵�ʵ����JVM�ڼ����κ�һ����ʱ�����ᴴ��һ��Class���͵�ʵ���������࣬����ÿ���඼
 * ����ֻ��һ��Class��ʵ����������synchronized�ھ�̬�����о��Ǹ����Classʵ�������ġ�
 * ���ԣ�����߳����ۺ�ʱ�εص���ͬһ����̬����ʱ��������ͬ��Ч����
 * 
 * ����
 * @author Administrator
 *
 */
public class SyncDemo03 {
	public static void main(String[] args) {
		final SyncDemo03 d1 = new SyncDemo03();
		final SyncDemo03 d2 = new SyncDemo03();
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
	
	public static synchronized void dosome(){//��̬��ͬ������
		Thread t = Thread.currentThread();
		System.out.println(t +"���ڵ���dosome����...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t +"����dosome��ϣ�");
	}
}













