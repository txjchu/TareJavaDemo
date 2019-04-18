package day05;
/**
 * ����
 * @author Administrator
 *
 */
public class SyncDemo5 {
	public static void main(String[] args) {
		final DeathLock d = new DeathLock();
		Thread t1 = new Thread(){
			public void run(){
				d.methodA();
				System.out.println(getName()+"������a������");
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d.methodB();
				System.out.println(getName()+"������b������");
			}
		};
		t1.start();
		t2.start();
	}
}

class DeathLock{
	//����������
	Object key1 = new Object();
	Object key2 = new Object();
	
	public void methodA(){
		//t1�߳̽�key1��ס
		synchronized (key1) {//t2�����t1�ͷ�key1
			Thread t = Thread.currentThread();
			System.out.println(t+"��������a����");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			//t1�߳�ֻ�е�����b�����Ż��ͷ�key1
			methodB();		
		}
	}
	public void methodB(){
		//t2�Ὣkey2��������
		synchronized (key2) {//t1�����t2�ͷ�key2
			Thread t = Thread.currentThread();
			System.out.println(t+"��������b����");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			//t2ֻ�е�����a�����Ż��ͷ�key2
			methodA();		
		}
	}
}






