package day05.copy;
/**
 * synchronized�Ļ�����Ч��
 * ��ʹ��synchronized�����δ������κ�ֻҪ���Ķ�����ͬ�������δ���;����˻���Ч����
 * @author Administrator
 *
 */
public class SyncDemo04 {
	public static void main(String[] args) {
		final Foo f = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				f.methodA();//����a����
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				f.methodB();//����b����
			}
		};
		t1.start();
		t2.start();
		//�۲��̻߳�������
		//��f����a����ʱ����Ϊa������b��������ͬ���ģ���ʱ��Ϊͬһ�������ڵ��ã����Բ����˻�������ֻ��һ��һ���߳����С�
	}	
}

class Foo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t +"���ڵ���a����...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t +"����a������ϣ�");
	}
	public synchronized void methodB(){
		Thread t = Thread.currentThread();//��ȡ��ǰ�߳�
		System.out.println(t +"���ڵ���b����....");
		try {
			Thread.sleep(5000);//����5��
		} catch (InterruptedException e) {
		}
		System.out.println(t +"����b������ϣ�");
	}
}












