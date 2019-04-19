package day05.copy;
/**
 * ��������
 * @author Administrator
 *
 */
public class SyncDemo05 {
	public static void main(String[] args) {
		final DeathLock d = new DeathLock();
		Thread t1 = new Thread(){
			public void run(){
				d.methodA();
				System.out.println(this.getName() +"������a�����ˣ�");
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d.methodB();
				System.out.println(this.getName() +"������b������!");
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
		synchronized(key1 ) {
			Thread t = Thread.currentThread();//��ȡ��ǰ�߳�
			System.out.println(t +"��������a����...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(t +"����a������ϣ�");
			
			//�˴��߳�t1ֻ�е�����b�����Ż��ͷ�key1
			methodB();
		}
	}
	
	public void methodB(){
		//t2�߳̽�key2��ס
		synchronized(key2){
			Thread t = Thread.currentThread();
			System.out.println(t +"���ڵ���b����....");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(t +"����b������ϣ�");
			
			//�˴��߳�t2ֻ�е�����a���������ͷ�key2
			methodA();
		}
	}
}












